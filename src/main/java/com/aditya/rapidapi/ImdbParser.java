package com.aditya.rapidapi;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ImdbParser extends MovieParser {

    public void populate(List<String>opts) {

        try {
           // String last = opts.get(0);


          //  MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");

    for(int i=10;i<20;i++) {
        int offset = 100*i;
        Request request = new Request.Builder()
                .url("https://unogsng.p.rapidapi.com/search?newdate=2002-08-15&orderby=dateDesc&limit=100&countrylist=337&audio=hindi&offset="+offset+"&end_year=2025")
                .get()
                .addHeader("X-RapidAPI-Key", "e22e0b22cemshd9c1f6cda290b90p15e4e3jsnf008bfdad4c2")
                .addHeader("X-RapidAPI-Host", "unogsng.p.rapidapi.com")
                .build();


        Response response = MovieUtils.call(request);
        MovieUtils.processImdb(response);
        Thread.sleep(1000);
    }
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
