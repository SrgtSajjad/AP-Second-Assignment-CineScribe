import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "55585491";
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;
    int year;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        this.actorsList = actorsList;
        this.rating = rating;
        this.ImdbVotes = ImdbVotes;
    }
    public Movie(int year){
        this.year = year;
    }


    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {
        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        return stringBuilder.toString();
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson) ;

        int ImdbVotes = Integer.parseInt(jsonObject.getString("imdbVotes").replace(",", ""));

        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){

        JSONObject jsonObject = new JSONObject(moviesInfoJson);
        JSONArray ratings = jsonObject.getJSONArray("Ratings");
        String rating = "";

        for (int i = 0; i < ratings.length(); i++) {

            JSONObject new_obj =  ratings.getJSONObject(i);

            if(new_obj.get("Source").equals("Internet Movie Database")) {
                rating = new_obj.getString("Value");
                break;
            }
        }

        return rating;
    }

    public int getYearMadeViaApi(String moviesInfoJson){
        JSONObject jsonObject = new JSONObject(moviesInfoJson);

        int YearMade = jsonObject.getInt("year");
        return YearMade;
    }

    public void getActorListViaApi(String movieInfoJson){

        JSONObject jsonObject = new JSONObject(movieInfoJson);

        String actorsString = jsonObject.getString("Actors");
        String[] actorsArray = actorsString.split(", ");

        for (String actor : actorsArray) {
            actorsList.add(actor);
        }
    }
}