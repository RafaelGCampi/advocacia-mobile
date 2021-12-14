package com.example.sistema_medeiros;

import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionAsyncTask extends AsyncTask<String,Void,String> {

    private ConnectionListener listener;

    public ConnectionAsyncTask(ConnectionListener listener){
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            String urlString = strings[0];
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = connection.getInputStream();
                return IOUtils.toString(inputStream, "UTF-8");
            }

        }catch (Exception e){

        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {

            JSONObject object = new JSONObject(s);

            if(listener != null){
                listener.onConnectResult(object);
            }

        }catch (Exception e){

            if(listener != null){
                listener.onConnectResult(null);
            }
        }
    }

    public interface ConnectionListener{
        void onConnectResult(JSONObject object);
    }
}

