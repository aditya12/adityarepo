package com.aditya.rapidapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[]args )
    {
        System.out.println( "Hello World!" );
        MovieParser bmp = new BingedMovieParser();
        System.out.println( "Hello World!" );

       // MovieParser pmp = new PaytmMovieParser();
       // MovieParser imp = new ImdbParser();

        List<String>opts = new ArrayList<String>();opts.add("50");
        bmp.populate(opts);
        System.out.println( "Hello World!" );
      //  pmp.populate(opts);
  //BingedMovieParser mu = new MovieUtils();
   //     MovieUtils.scrapeIamges();
    }
}
