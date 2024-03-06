import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        runMenu();
    }
    public static void runMenu() throws IOException {
        // get title from the user
        Scanner scanner = new Scanner(System.in);
        Movie movie = new Movie(new ArrayList<>(),"",0, "");
        boolean flag = false;
        String movieData = "";
        while (!flag) {

            System.out.println("Please enter the name of a movie");
            movie.title = scanner.nextLine();
            movieData = movie.getMovieData(movie.title);
            flag = movie.checkResponse(movieData);
            if (!flag){
                System.out.println("Error: Movie Not Found");
            }
        }
            movie.setAttributes(movieData);
            displayMovieData(movie);

            System.out.println("Choose an actor from the list above");

    }

    public static void displayMovieData(Movie movie){
        System.out.println("Title: " + movie.title);
        System.out.println("Year(s) Released: " + movie.yearReleased);
        System.out.println("IMDB: " + movie.rating + " from " + movie.ImdbVotes + " votes");
        System.out.println("Actors: ");
        int i = 0;
        for (String actor : movie.actorsList) {
            i++;
            System.out.println(i + ". " + actor);
        }
    }
}