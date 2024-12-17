package com.aditya.rapidapi;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public abstract class MovieParser {

	abstract void populate(List<String>options);
	
	abstract ArrayList<MovieBean> transform(Response response);
	
	  void insert(ArrayList<MovieBean> al) {
		 MovieUtils.persist(al);
	 }
}
