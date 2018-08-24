/**
 * Date:2018/08/23
 * purpose: create a guess game about the movies name
 */


import java.io.File;
import java.util.Scanner;
import java.util.regex.*;


public class Main {
    public static void main(String [] args) throws Exception{
        // init the objects
        MovieManager movies = new MovieManager();
        String path = new String();
        String movieName;
        String movieReplace;
        int guessTimes = 10;
        File file;
        Scanner fileScanner;

        // choose the file being used in the game
        System.out.print("Which database do you want to choose:1 [movies]; 2 [Pinyin]:\n");
        Scanner choiceScanner = new Scanner(System.in);

        // get the file option
        int choice = choiceScanner.nextInt();

        do {
            if (choice > 2 || choice <= 0) {
                System.out.print("The choice value is out of option! Try again!\n");
                choice = choiceScanner.nextInt();
            }

            if (choice == 1) {
                path = "data/movies.txt";
                break;
            } else if (choice == 2){
                path = "data/Pinyin.txt";
                break;
            }

        } while (choice > 1 || choice <= 0);



        file = new File(path);
        fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()){
            String scanner = fileScanner.nextLine();
            Movie movie = new Movie(scanner);
            movies.addMovies(movie);
        }

        // choose the Movie name at random
        movieName = movies.getMovie();
        movieReplace = movies.replaceMovie(movieName);
//         Debugger
//        System.out.println(movieName);
//        System.out.println(movies.replaceMovie(movieName));

        // try to guess the movie name
        System.out.println("You are guessing: " + movies.replaceMovie(movieName));

        Scanner wordScanner = new Scanner(System.in);
        String word;
        String words = "";
        String checkMovie;
        int currentIndex;
        String firstWords;
        String secondWords;
        boolean checkStatus = false;
        String wrongWords = "";
        while (guessTimes > 0){
            System.out.printf("You have guessed (%d) wrong letters: %s\n", (10 - guessTimes), wrongWords);
            System.out.print("Guess a letter:");
            word = wordScanner.next();

            checkMovie = movieName;

            if (movieName.contains(word)){
                if (words.contains(word)){
                    System.out.printf("The word %s guessed. Try other word!", word);
                    continue;
                }

                currentIndex = 0;

                while (movieName.indexOf(word, currentIndex) >= 0){
                    currentIndex = checkMovie.indexOf(word, currentIndex);
                    checkMovie.replaceFirst(word, "_");

                    firstWords = movieReplace.substring(0, currentIndex);
                    secondWords = movieReplace.substring(currentIndex+1, movieName.length());
                    movieReplace = firstWords + word + secondWords;

                    currentIndex ++;
                }
                // break the loop when guessTimes is 0
                if (guessTimes == 1) {
                    break;
                }
                // break the loop when
                if (movieName.equals(movieReplace)){
                    checkStatus = true;
                    break;
                }

                System.out.printf("You are guessing: %s\n", movieReplace);
                words += word;
            } else{
                guessTimes --;
                wrongWords += word;
            }

        }

        // check tht guess status at finally
        if (checkStatus){
            System.out.print("Tada, You win!\n");
            System.out.printf("You have guessed \'%s\' correctly!", movieName);
        } else {
            System.out.printf("You have guessed (%d) wrong letters: %s\n", 10);
            System.out.printf("You loss! The movie name is %s !\n", movieName);
        }
    }
}
