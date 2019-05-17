package com.example.tiki_taka;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EventBriteService {

        public static void findEvents( Callback callback) {
            /*the okhttp client sends the request*/
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.EVENTBRITEBASE_URL).newBuilder();
            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", Constants.EventBriteToken)
                    .build();

            Call call = client.newCall(request);
            call.enqueue(callback);

        }

    public ArrayList<Event> processResults(Response response){
        ArrayList<Event> event = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject eventbriteJSON = new JSONObject(jsonData);
            JSONArray eventJSONa = eventbriteJSON.getJSONArray("events");
            if (response.isSuccessful()){
                for (int i = 0; i < eventJSONa.length(); i++){
                    JSONObject eventsJSON = eventJSONa.getJSONObject(i);
                    String name = eventsJSON.getJSONObject("name").getString("text");
                    String description = eventsJSON.getJSONObject("description").getString("text");
                    String start = eventsJSON.getJSONObject("end").getString("local");
                    String end = eventsJSON.getJSONObject("end").getString("local");
                    ArrayList<String> address = new ArrayList<>();
                    JSONArray addressJSON = eventsJSON.getJSONObject("location").getJSONArray("display_address");
                    for (int y = 0; y < addressJSON.length(); y++){
                        address.add(addressJSON.get(y).toString());
                    }
                    Event events = new Event(name, description, start, end
                            );
                    event.add(events);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return event;
    }

}