import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        runMenu();
    }
    public static void runMenu() throws IOException {
        // get title from the user
        System.out.println("Please enter the name of a movie");
        Scanner scanner = new Scanner(System.in);

        Movie movie = new Movie(new ArrayList<>(),"",0, "");
        movie.title = scanner.nextLine();
        String movieData = movie.getMovieData(movie.title);

        if (movie.checkResponse(movieData))
        {
            movie.setAttributes(movieData);
            displayMovieData(movie);
        }

        else{
            System.out.println("Error: Movie Not Found");
        }
    }

    public static void displayMovieData(Movie movie){
        System.out.println("Title: " + movie.title);
        System.out.println("Year(s) Released: " + movie.yearReleased);
        System.out.println("IMDB: " + movie.rating + " from " + movie.ImdbVotes + " votes");
        for (String actor : movie.actorsList) {
            System.out.println(actor);
        }

    }
}