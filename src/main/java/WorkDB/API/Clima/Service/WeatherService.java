package WorkDB.API.Clima.Service;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    private OkHttpClient client;
    private Response response;

    private String APIkey = "ba61e79a0119a86f77cc471643451b24";

    //Getting Data from OpenWeather API
    public String getWeather(String cidade){
        client = new OkHttpClient();
        JSONObject json = null;
        String lat = "";
        String lon = "";
        Request requestLatLong = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+cidade+"&units=celsius&appid="+APIkey)
                .build();

        try {
            response = client.newCall(requestLatLong).execute();
            json = new JSONObject(response.body().string());
            lat = json.getJSONObject("coord").getString("lat");
            lon = json.getJSONObject("coord").getString("lon");

            Request requestFinal = new Request.Builder()
                    .url("http://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&appid="+APIkey+"&units=metric&lang=pt_br")
                    .build();
            response = client.newCall(requestFinal).execute();
            return response.body().string();

        }catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}