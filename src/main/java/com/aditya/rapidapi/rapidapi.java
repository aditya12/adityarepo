package com.aditya.rapidapi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

//import java.awt.PageAttributes.MediaType;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
//import org.asynchttpclient.Request;
//import org.asynchttpclient.Response;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

class rapidapi {

	static AsyncHttpClient client = new DefaultAsyncHttpClient();
	static final String DB_URL = "jdbc:mysql://localhost/moviedb";
	static final String USER = "root";
	static final String PASS =  "";
	
	public static void main(String[] args) {
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
					MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
					RequestBody body = RequestBody.create(mediaType, "draw=1&columns%5B0%5D%5Bdata%5D=image&columns%5B0%5D%5Bname%5D=&columns%5B0%5D%5Bsearchable%5D=true&columns%5B0%5D%5Borderable%5D=false&columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B1%5D%5Bdata%5D=title&columns%5B1%5D%5Bname%5D=&columns%5B1%5D%5Bsearchable%5D=true&columns%5B1%5D%5Borderable%5D=false&columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B2%5D%5Bdata%5D=category&columns%5B2%5D%5Bname%5D=&columns%5B2%5D%5Bsearchable%5D=true&columns%5B2%5D%5Borderable%5D=false&columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B3%5D%5Bdata%5D=genre&columns%5B3%5D%5Bname%5D=&columns%5B3%5D%5Bsearchable%5D=true&columns%5B3%5D%5Borderable%5D=false&columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B4%5D%5Bdata%5D=languages&columns%5B4%5D%5Bname%5D=&columns%5B4%5D%5Bsearchable%5D=true&columns%5B4%5D%5Borderable%5D=false&columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B5%5D%5Bdata%5D=platform&columns%5B5%5D%5Bname%5D=&columns%5B5%5D%5Bsearchable%5D=true&columns%5B5%5D%5Borderable%5D=false&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B6%5D%5Bdata%5D=theatrical-year&columns%5B6%5D%5Bname%5D=&columns%5B6%5D%5Bsearchable%5D=true&columns%5B6%5D%5Borderable%5D=false&columns%5B6%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B6%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B7%5D%5Bdata%5D=streaming-date&columns%5B7%5D%5Bname%5D=&columns%5B7%5D%5Bsearchable%5D=true&columns%5B7%5D%5Borderable%5D=false&columns%5B7%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B7%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B8%5D%5Bdata%5D=recommended&columns%5B8%5D%5Bname%5D=&columns%5B8%5D%5Bsearchable%5D=true&columns%5B8%5D%5Borderable%5D=false&columns%5B8%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B8%5D%5Bsearch%5D%5Bregex%5D=false&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=asc"
							+ "&start=0&length=10&search%5Bvalue%5D=&search%5Bregex%5D=false&mode=streaming-now&action=mi_events_load_data&filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&filters%5Blanguage%5D%5B%5D=Hindi&filters%5Blanguage%5D%5B%5D=Hindi&filters%5B"
							+ "platform%5D%5B%5D=&filters%5Bplatform%5D%5B%5D=");
					Request request = new Request.Builder()
					  .url("https://www.binged.com/wp-admin/admin-ajax.php")
					  .method("POST", body)
					  .addHeader("authority", "www.binged.com")
					  .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
					  .addHeader("accept-language", "en-US,en;q=0.9")
					  .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
					  .addHeader("cookie", "_ga=GA1.2.1247171916.1664015083; __auc=7550ad7e1836f07284be9451077; quads_browser_width=1280; _gid=GA1.2.1945437163.1669556877; __asc=560d930d184b958378c5a99bf07; __gpi=UID=000009dc28c0ff75:T=1664015069:RT=1669556876:S=ALNI_MZbttxVXAtaA6VctIp-2jef_EGIgA; _gat_gtag_UA_137500918_1=1; __gads=ID=c429954407cd2fcb-229a0f3fa8d800cf:T=1664015069:S=ALNI_MZ7bZIKEGD6HHZaAKyA7hZe1kgOSQ")
					  .addHeader("origin", "https://www.binged.com")
					  .addHeader("referer", "https://www.binged.com/advanced-search/?"
					  		+ "category[]=Film&category[]=Tv%20show&category[]=Film"
					  		+ "&category[]=Tv%20show&"
					  		+ "language[]=Hindi&language[]=Hindi&"
					  		+ "platform[]=&platform[]="
					  		+ "&s=advanced"
					  		+ "&title=")
					  .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
					  .addHeader("sec-ch-ua-mobile", "?0")
					  .addHeader("sec-ch-ua-platform", "\"Windows\"")
					  .addHeader("sec-fetch-dest", "empty")
					  .addHeader("sec-fetch-mode", "cors")
					  .addHeader("sec-fetch-site", "same-origin")
					  .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
					  .addHeader("x-requested-with", "XMLHttpRequest")
					  .build();
					Response response = client.newCall(request).execute();
					process(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void process(Response r) {
		try {

			String s = r.body().string();
			Gson gson = new Gson(); // Or use new GsonBuilder().create();
			Root result = gson.fromJson(s, Root.class);
			System.out.println(s);
			result.getData().forEach(rapidapi::transform);
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	         		d.getStreamingDate() +"','"+
	         		d.getStreamingDate() +"','"+
	         		d.getStreamingDate() +"','"+
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
