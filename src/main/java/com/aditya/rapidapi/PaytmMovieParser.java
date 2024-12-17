package com.aditya.rapidapi;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class PaytmMovieParser extends MovieParser {
	
	public void populate(List<String>opts) {
		
				try {

//					OkHttpClient client = new OkHttpClient().newBuilder()
//							.build();
					MediaType mediaType = MediaType.parse("text/plain");
					RequestBody body = RequestBody.create(mediaType, "");
					Request request = new Request.Builder()
							.url("https://apiproxy.paytm.com/v3/movies/upcoming?city=delhi-ncr&version=3&site_id=1&channel=HTML5&child_site_id=1")
							.method("GET",null)
							.addHeader("authority", "apiproxy.paytm.com")
							.addHeader("accept", "*/*")
							.addHeader("accept-language", "en-US,en;q=0.9")
							.addHeader("origin", "https://paytm.com")
							.addHeader("referer", "https://paytm.com/")
							.addHeader("sec-ch-ua", "\"Chromium\";v=\"118\", \"Google Chrome\";v=\"118\", \"Not=A?Brand\";v=\"99\"")
							.addHeader("sec-ch-ua-mobile", "?0")
							.addHeader("sec-ch-ua-platform", "\"Windows\"")
							.addHeader("sec-fetch-dest", "empty")
							.addHeader("sec-fetch-mode", "cors")
							.addHeader("sec-fetch-site", "same-site")
							.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/118.0.0.0 Safari/537.36")
							.addHeader("Cookie", "__cf_bm=GK_yO1kRrR1gAqesUNXxCeuivNhWrYneoy9Bv.XkWhY-1698333892-0-Adntc6iLI5/Py7QsKXvIlEmKm1jMwBS/hXC8Vo3zcbkUKWoN16UPdBXGTHK92ACJYOxrIfwY07HDcvBKDiIwO4w=; _cfuvid=0mJJcUaU8UpeB8UfF7HJTib8VOumlFCr643H1vWBgL0-1698333892197-0-604800000")
							.build();
				//	Response response = client.newCall(request).execute();
				//	String last = opts.get(0);
					
//					MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
//					RequestBody body = RequestBody.create(mediaType,
//							"draw=1&columns%5B0%5D%5Bdata%5D=image&columns%5B0%5D%5Bname%5D="
//							+ "&columns%5B0%5D%5Bsearchable%5D=true&"
//							+ "columns%5B0%5D%5Borderable%5D=false&"
//							+ "columns%5B0%5D%5Bsearch%5D%5Bvalue%5D=&c"
//							+ "olumns%5B0%5D%5Bsearch%5D%5Bregex%5D=false&"
//							+ "columns%5B1%5D%5Bdata%5D=title&"
//							+ "columns%5B1%5D%5Bname%5D=&columns%5B1%5D%5Bsearchable%5D=true"
//							+ "&columns%5B1%5D%5Borderable%5D=false&"
//							+ "columns%5B1%5D%5Bsearch%5D%5Bvalue%5D=&"
//							+ "columns%5B1%5D%5Bsearch%5D%5Bregex%5D=false&"
//							+ "columns%5B2%5D%5Bdata%5D=category"
//							+ "&columns%5B2%5D%5Bname%5D=&"
//							+ "columns%5B2%5D%5Bsearchable%5D=true&"
//							+ "columns%5B2%5D%5Borderable%5D=false&"
//							+ "columns%5B2%5D%5Bsearch%5D%5Bvalue%5D=&"
//							+ "columns%5B2%5D%5Bsearch%5D%5Bregex%5D=false&"
//							+ "columns%5B3%5D%5Bdata%5D=genre&columns%5B3%5D%5Bname%5D=&"
//							+ "columns%5B3%5D%5Bsearchable%5D=true&"
//							+ "columns%5B3%5D%5Borderable%5D=false&"
//							+ "columns%5B3%5D%5Bsearch%5D%5Bvalue%5D=&"
//							+ "columns%5B3%5D%5Bsearch%5D%5Bregex%5D=false&"
//							+ "columns%5B4%5D%5Bdata%5D=languages&columns%5B4%5D%5Bname%5D=&"
//							+ "columns%5B4%5D%5Bsearchable%5D=true&"
//							+ "columns%5B4%5D%5Borderable%5D=false&"
//							+ "columns%5B4%5D%5Bsearch%5D%5Bvalue%5D=&"
//							+ "columns%5B4%5D%5Bsearch%5D%5Bregex%5D=false&"
//							+ "columns%5B5%5D%5Bdata%5D=platform&columns%5B5%5D%5Bname%5D=&columns%5B5%5D%5Bsearchable%5D=true&columns%5B5%5D%5Borderable%5D=false&columns%5B5%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B5%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B6%5D%5Bdata%5D=theatrical-year&columns%5B6%5D%5Bname%5D=&columns%5B6%5D%5Bsearchable%5D=true&columns%5B6%5D%5Borderable%5D=false&columns%5B6%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B6%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B7%5D%5Bdata%5D=streaming-date&columns%5B7%5D%5Bname%5D=&columns%5B7%5D%5Bsearchable%5D=true&columns%5B7%5D%5Borderable%5D=false&columns%5B7%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B7%5D%5Bsearch%5D%5Bregex%5D=false&columns%5B8%5D%5Bdata%5D=recommended&columns%5B8%5D%5Bname%5D=&columns%5B8%5D%5Bsearchable%5D=true&columns%5B8%5D%5Borderable%5D=false&columns%5B8%5D%5Bsearch%5D%5Bvalue%5D=&columns%5B8%5D%5Bsearch%5D%5Bregex%5D=false&order%5B0%5D%5Bcolumn%5D=0&order%5B0%5D%5Bdir%5D=asc"
//							+ "&start=0&"
//							+ "length="+last+"&"
//							+ "search%5Bvalue%5D=&search%5Bregex%5D=false&"
//							+ "mode=&action=mi_events_load_data&"
//									+ "filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&"
//							//		+ "filters%5Blanguage%5D%5B%5D=Hindi&filters%5Blanguage%5D%5B%5D=Hindi&filters%5B"
//						//	+ "filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&filters%5Bcategory%5D%5B%5D=Film&filters%5Bcategory%5D%5B%5D=Tv+show&"
//						//	+ "filters%5Blanguage%5D%5B%5D=Hindi&filters%5Blanguage%5D%5B%5D=Hindi&filters%5B"
//							+ "platform%5D%5B%5D=&filters%5Bplatform%5D%5B%5D=");
//					Request request = new Request.Builder()
//					  .url("https://www.binged.com/wp-admin/admin-ajax.php")
//					  .method("POST", body)
//					  .addHeader("authority", "www.binged.com")
//					  .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
//					  .addHeader("accept-language", "en-US,en;q=0.9")
//					  .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
//					  .addHeader("cookie", "_ga=GA1.2.1247171916.1664015083; __auc=7550ad7e1836f07284be9451077; quads_browser_width=1280; _gid=GA1.2.1945437163.1669556877; __asc=560d930d184b958378c5a99bf07; __gpi=UID=000009dc28c0ff75:T=1664015069:RT=1669556876:S=ALNI_MZbttxVXAtaA6VctIp-2jef_EGIgA; _gat_gtag_UA_137500918_1=1; __gads=ID=c429954407cd2fcb-229a0f3fa8d800cf:T=1664015069:S=ALNI_MZ7bZIKEGD6HHZaAKyA7hZe1kgOSQ")
//					  .addHeader("origin", "https://www.binged.com")
//					  .addHeader("referer", "https://www.binged.com")
////					  /advanced-search/?"
////					  		+ "category[]=Film&category[]=Tv%20show&category[]=Film"
////					  		+ "&category[]=Tv%20show&"
////					  		+ "language[]=Hindi&language[]=Hindi&"
////					  		+ "platform[]=&platform[]="
////					  		+ "&s=advanced"
////					  		+ "&title=")
//					  .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"107\", \"Chromium\";v=\"107\", \"Not=A?Brand\";v=\"24\"")
//					  .addHeader("sec-ch-ua-mobile", "?0")
//					  .addHeader("sec-ch-ua-platform", "\"Windows\"")
//					  .addHeader("sec-fetch-dest", "empty")
//					  .addHeader("sec-fetch-mode", "cors")
//					  .addHeader("sec-fetch-site", "same-origin")
//					  .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
//					  .addHeader("x-requested-with", "XMLHttpRequest")
//					  .build();
					Response response = MovieUtils.call(request);
					MovieUtils.processPaytm(response);
					//insert(al);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

/*	public static void process(Response r) {
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

	}*/
	public  ArrayList<MovieBean> transform(Response r)
	{
		try {
			
		String s = r.body().string();
		Gson gson = new Gson();
		Root result = gson.fromJson(s, Root.class);
		System.out.println(s);
		result.getData().forEach((d)->System.out.println(d));
		
		}catch(Exception e) {}
				return null;
	 }

}
