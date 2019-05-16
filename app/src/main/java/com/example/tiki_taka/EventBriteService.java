package com.example.tiki_taka;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class EventBriteService {

        public static void findEvents(String location, Callback callback) {
            /*the okhttp client sends the request*/
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.EVENTBRITEBASE_URL).newBuilder();
            urlBuilder.addQueryParameter(Constants.EventBrite_Events_QUERY_PARAMETER, location);
            String url = urlBuilder.build().toString();

            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", Constants.EventBriteToken)
                    .build();

        }

    }

