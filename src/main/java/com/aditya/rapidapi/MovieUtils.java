package com.aditya.rapidapi;

import java.io.File;
import com.jcraft.jsch.JSch;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.mysql.cj.Session;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieUtils {
	
	static AsyncHttpClient client = new DefaultAsyncHttpClient();
	static final String DB_URL =  "jdbc:mysql://localhost:3306/moviedb";
	static final String USER = "root";
	static final String PASS =  "";

	static String jumpserverHost = "3.7.21.1";
	static String jumpserverUsername = "ec2-user";
	// The hostname/IP address and port, you would use on the SSH server
// to connect to the database.
// If the database runs on the same machine as the SSH server, use "localhost".
	static String databaseHost = "localhost";
	static int databasePort = 3306;
	String databaseUsername = "dbuser";
	String databasePassword = "dbpass";

	
	public static  Response call(Request request) {
		try {
			/*client.prepare("GET",
					"https://unogsng.p.rapidapi.com/search?" + "limit=20&offset=0&query=&countrylist=337&"
							+ "country_andorunique=or&start_year=1900&" + "end_year=2022&start_rating=&end_rating=10&"
							+ "genrelist=&type="
							// + "&audio=Hindi"
							+ "&audio=Hindi%20[Original]" + "&subtitle=&"
							+ "audiosubtitle_andor=or&person=&filterby=&orderby=DateDesc")
					.setHeader("X-RapidAPI-Key", "e22e0b22cemshd9c1f6cda290b90p15e4e3jsnf008bfdad4c2")
					.setHeader("X-RapidAPI-Host", "unogsng.p.rapidapi.com").execute().toCompletableFuture()
					.thenAccept(rapidapi::process).join();
			// process(null);

			client.close();*/
			
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					
					Response response = client.newCall(request).execute();
					return response;
					//process(response);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public static void process(Response r) {
		try {

			String s = r.body().string();
			Gson gson = new Gson(); // Or use new GsonBuilder().create();
			Root result = gson.fromJson(s, Root.class);
			System.out.println(s);
			result.getData().forEach(MovieUtils::transform);
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void processImdb(Response r) {
		try {

			String s = r.body().string();
			Gson gson = new Gson(); // Or use new GsonBuilder().create();
			Example result = gson.fromJson(s, Example.class);
			System.out.println(s);
			result.getResults().forEach(MovieUtils::transformImdb);
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void processPaytm(Response r) {
		try {

			String s = r.body().string();
			Gson gson = new GsonBuilder().create(); // Or use new GsonBuilder().create();
			System.out.println(s);
			PaytmData result = gson.fromJson(s, PaytmData.class);

			result.getUpcomingMovieData().forEach(MovieUtils::transformPaytm);
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void transformPaytm(UpcomingMovieDatum d) {
		try {
			System.out.println(d.getMovieName());
			JSch jsch = new JSch();
// Public key authentication example
// (but you can use password authentication, if appropriate).
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			jsch.setKnownHosts("3.7.21.1");
			jsch.addIdentity("C:\\Users\\Lenovo\\Downloads\\ottmovie.pem");

			// Connect to SSH jump server (this does not show an authentication code)

			JSch.setConfig("server_host_key", JSch.getConfig("server_host_key") + ",ssh-rsa");
			 JSch.setConfig("PubkeyAcceptedAlgorithms", JSch.getConfig("PubkeyAcceptedAlgorithms") + ",ssh-rsa");
			com.jcraft.jsch.Session session = jsch.getSession(jumpserverUsername, jumpserverHost);
			session.setConfig(config);
			session.connect();

// Forward automatically chosen local free port through the SSH channel
// to database host/port
			int forwardedPort = session.setPortForwardingL(0, databaseHost, databasePort);

// Connect to the forwarded port (the local end of the SSH tunnel).
// If you don't use JDBC, but another database client,
// just connect it to the localhost:forwardedPort
			String url = "jdbc:mysql://localhost:" + forwardedPort;
//		Connection con =
//				DriverManager.getConnection(url, databaseUsername, databasePassword);

			try (Connection conn = DriverManager.getConnection(url, USER, PASS);
				 Statement stmt = conn.createStatement();
			) {

				System.out.println("Inserting records into the table...");
				String sql = "INSERT INTO filmbase "
						//	+ "(`id`, `link`, `image`, `title`,"
						//	+ " `theatrical-year`,"
						//	+ " `release-year`, `streaming-date/date`, `streaming-date/soon`,"
						//	+ " `streaming-date/unknown`, `streaming-date/display`, `category`,"
						//	+ " `genre`, `languages`, `platform`, `recommended`, `recommendation`) "
						+ "VALUES ('" +
						d.getContentId() + "','" +
						"','" +
						d.getMoviePosterUrl() + "','" +
						d.getMovieName().replaceAll("'", "\\\\'").trim() + "','" +
						"','" +
						"','" +
						d.getReleaseDate() + "','" +
						"','" +
						"','" +
						d.getReleaseDate() + "','" +
						"FeatureMovie','" +
						String.join(",", d.getGenre()) + "','" +
						String.join(",", d.getLanguageGroup()) + "','" + "Theatre" + "','" +

						"','" +
						"')";
				System.out.println(sql);
				stmt.executeUpdate(sql);
				System.out.println("Inserted records" + d.getMovieName() + " into the table...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch(com.jcraft.jsch.JSchException e)
		{
			e.printStackTrace();
		}


	}


	public static void transformImdb(ResultItem d) {
		System.out.println(d.getTitle());
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
		) {
			String sDate1="21 Oct 2023";
			//LocalDate date = LocalDate.parse(sDate1);
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(d.getTitledate());
			// Execute a query
			String platformString = "";
			String synopsis =d.getSynopsis();
			if(synopsis !=null && d.getSynopsis().length()>1023)
			{
				synopsis = synopsis.substring(0,1023);
			}

			String sql = "INSERT INTO imdbdata "


			//INSERT INTO `imdbdata`
					// (`avgrating`, `clist`, `id`, `imdbid`, `imdbrating`, `img`, `nfid`, `poster`,
					// `runtime`, `synopsis`, `title`, `titledate`, `top250`, `top250tv`, `vtype`, `year`) VALUES (
			+ "VALUES (" +
					d.getAvgrating() +",'"+
					d.getClist() +"',"+
					d.getId() +",'"+
					d.getImdbid() + "',"+d.getImdbrating() +",'"+ d.getImg() +"','"+ d.getNfid() +"','"+ d.getPoster() +"',"+ d.getRuntime() +",'"+
					synopsis +"','"+
					d.getTitle().replaceAll("'", "\\\\'") +"','"+
					d.getTitledate() +"',"+
					d.getTop250() +","+
					d.getTop250tv() +",'"+
					d.getVtype() +"',"+
					d.getYear()
					 + ")";
//			sql += " ON DUPLICATE KEY UPDATE " +
//					"  `streaming-date/date` =  '" + dt.toString()+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			System.out.println("Inserted records"+d.getTitle()+" into the table...");
		} catch (SQLException e) {
			e.printStackTrace();}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


	}
	public static void transform(Datum d)
	{
	/*	System.out.println(d.getStreamingDate().getDate() + "\t" +
				d.getId() + "\t" +
		d.getCategory() +"\t"+
		d.getTitle() + "\t" +
		d.getGenre() +"\t" +
		d.getPlatform() +"\t" +
		d.getLanguages() +"\n");*/
		// Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	    	   String sDate1="21 Oct 2023";
	    	   //LocalDate date = LocalDate.parse(sDate1);
	    	   SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
	    	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	    	    System.out.println(sdf2.format(sdf.parse(sDate1)));
	         // Execute a query
			 String platformString = "";
			 if(d.getPlatform() !=null && d.getPlatform().size()>0)
			 {
				 platformString = d.getPlatform().get(0).split("/")[d.getPlatform().get(0).split("/").length-1];
				 if(platformString !=null && platformString.length()>4)
					 platformString = platformString.substring(0, platformString.length()-4);
				 else
				 {
					 System.out.println(d.getPlatform().get(0));
				 }
			 }
			  Date dt = Date.valueOf(sdf2.format(sdf.parse(d.getStreamingDate())));
	         System.out.println("Inserting records into the table..." +dt);
	         String sql = "INSERT INTO moviebase "
	         	//	+ "(`id`, `link`, `image`, `title`,"
	         	//	+ " `theatrical-year`,"
	         	//	+ " `release-year`, `streaming-date/date`, `streaming-date/soon`,"
	         	//	+ " `streaming-date/unknown`, `streaming-date/display`, `category`,"
	         	//	+ " `genre`, `languages`, `platform`, `recommended`, `recommendation`) "
	         		+ "VALUES ('" +
	         		d.getId() +"',NULL,NULL,'"+
	         		d.getLink() +"','"+
	         		d.getImage() +"','"+
	         		d.getTitle().replaceAll("'", "\\\\'") +"','"+
	          		d.getTheatricalYear() +"','"+
	         		d.getReleaseYear() +"','"+
					 dt+"','"+
	         		//Date.valueOf(sdf2.format(sdf.parse(d.getStreamingDate()))) +"','"+
	         		 "','"+
	         		"','"+
	         		d.getStreamingDate()+"','"+
	         		d.getCategory() +"','"+
	         		d.getGenre() +"','"+
	         		d.getLanguages() +"','"+ platformString +"','"+

	         		d.getRecommended() +"','"+
	         		d.getRecommendation() + "')";
			 sql += " ON DUPLICATE KEY UPDATE " +
					 "  `streaming-date/date` =  '" + dt.toString()+"'";
	         System.out.println(sql);
	         stmt.executeUpdate(sql);
	          System.out.println("Inserted records"+d.getTitle()+" into the table...");   	  
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	   }

	public static void scrapeIamges() {


		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
		) {
			String sql ="select image from moviebase order by `streaming-date/date` desc LIMIT 1 " ; //18446744073709551610
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			int i=0,errcount=0;
			while (rs.next()) {

				i++;
				//Thread.sleep(500);
				String lastName = rs.getString("image");

				String fullurl = lastName.substring(0,lastName.lastIndexOf('.')-7) +lastName.substring(lastName.lastIndexOf('.'),lastName.length());
				String imagename = fullurl.split("/")[lastName.split("/").length-1];
				try{	imagename = java.net.URLEncoder.encode(imagename, "UTF-8");
				System.out.println(lastName + "\n" + fullurl + imagename);

				streamFromUrl(fullurl,"E:\\images\\full\\"+imagename);
			}
			catch (IOException e) {
				e.printStackTrace();
				//System.out.println("ERROR::::" +  fullurl)
				errcount++;
			}
				System.out.println("processed::" + i + "Error" + errcount);
		} }catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void streamFromUrl(String downloadUrl, String filePath) throws IOException {
	//	downloadUrl = java.net.URLEncoder.encode(downloadUrl, "UTF-8");

		try (InputStream in = new URL(downloadUrl).openStream()) {
			Files.copy(in, Paths.get(new File(filePath).toURI()), StandardCopyOption.REPLACE_EXISTING);
		}

	}



	 static void persist(ArrayList<MovieBean> al)
	{
		for(MovieBean d:al){
			try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			         Statement stmt = conn.createStatement();
			      ) {		      
			    	   String sDate1="31-12-1998";  
			    	   //LocalDate date = LocalDate.parse(sDate1);
			    	   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			    	    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			    	    System.out.println(sdf2.format(sdf.parse(sDate1)));
			         // Execute a query
			         System.out.println("Inserting records into the table...");          
			         String sql = "INSERT INTO movieinfo "
			         	//	+ "(`id`, `link`, `image`, `title`,"
			         	//	+ " `theatrical-year`,"
			         	//	+ " `release-year`, `streaming-date/date`, `streaming-date/soon`,"
			         	//	+ " `streaming-date/unknown`, `streaming-date/display`, `category`,"
			         	//	+ " `genre`, `languages`, `platform`, `recommended`, `recommendation`) "
			         		+ "VALUES ('" +
			         		d.getId() +"','"+
			         		d.getLink() +"','"+
			         		d.getImage() +"','"+
			         		d.getTitle() +"','"+
			          		d.getTheatricalYear() +"','"+
			         		d.getReleaseYear() +"','"+
			         		Date.valueOf(sdf2.format(sdf.parse(d.getStreamingDate()))) +"','"+
			         		d.getStreamingDateSoon() +"','"+
			         		d.getSreamingDateUnknown() +"','"+
			         		d.getStreamingDisplay()+"','"+
			         		d.getCategory() +"','"+
			         		d.getGenre() +"','"+
			         		d.getLanguages() +"','"+
			         		d.getPlatform() +"','"+
			         		d.getRecommended() +"','"+
			         		d.getRecommendation() + "')";
			         System.out.println(sql);
			         stmt.executeUpdate(sql);
			          System.out.println("Inserted records"+d.getTitle()+" into the table...");   	  
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			
		}
	}
}
