/**
 * Date:2018/08/23
 * purpose: create class about movie
 */

import java.util.regex.*;

class Movie {
    // Todo: create a movie list
    String movieName;
//    int moviesIndex;
    Movie(String movie){
        this.movieName = movie;
    }
}

class MovieManager {
    // movies fields;
    Movie [] movieList;
    public int moviesCount;

    // constructor movie
    MovieManager() {
        this.moviesCount = 0;
        this.movieList = new Movie[30];
    }

    // Todo:manager methods
    // add method
    public void addMovies(Movie movie) {
        movieList[moviesCount] = movie;
        moviesCount ++;
    }
    // get movie name method
    public String getMovie() {
        int index;

        // create random index
        index = (int) (Math.random() * moviesCount);
        Movie choseMovie =  movieList[index];
        return choseMovie.movieName;
    }

    // replace the words by _
    public String replaceMovie(String s) {
        String result;
        result = s.replaceAll("\\w", "_");

        return result;
    }

    // replace the word in the guess movie
    public String replaceWord(String guessmovie, String target, String replacement){
        String result;

        result = guessmovie.replaceAll(target, replacement);
        return result;
    }
}