import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
public class Actors {
    public static final String API_KEY = "g6xmG45Gyp4MrdnXYQkW1g==EfClMRrFdwpizhBP";
    long netWorth;
    Boolean isAlive;

    public Actors(long netWorth, boolean isAlive){
        this.isAlive = isAlive;
        this.netWorth = netWorth;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public long getNetWorthViaApi(String actorsInfoJson){
        JSONArray jsonArray = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        long result = jsonObject.getLong("net_worth");
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        JSONArray jsonArray = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        boolean statues = jsonObject.getBoolean("is_alive");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        JSONArray jsonArray = new JSONArray(actorsInfoJson);
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        String date = jsonObject.getString("death");
        return date;
    }

}