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
        Actors actor = new Actors(0, true, new ArrayList<>());
        boolean flag = false;
        String movieData = "", actorData = "";
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

        flag = false;
        while (!flag) {

            System.out.println("Choose an actor from the list above");
            actor.name = scanner.nextLine();
            flag = movie.actorsList.contains(actor.name);
            if (!flag){
                System.out.println("Error: Actor Not In The List");
            }
        }
        actorData = actor.getActorData(actor.name);
        actor.setAttributes(actorData);
        displayActorData(actor);
    }

    public static void displayActorData(Actors actor) {
        System.out.println("Name: " + actor.name);
        System.out.println("Net Worth: " + actor.netWorth);
        System.out.println("Birthday: " + actor.birthday);
        if (!actor.isAlive) {
            System.out.println("Death: " + actor.deathDate);
        }
        System.out.println("Age: " + actor.age);
        for (String occupation : actor.occupationsList) {
            System.out.println("-" + occupation);
        }
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