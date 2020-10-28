package com.pim.criptocoin.service;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpServiceExterno extends AsyncTask<Void,Void, String> {
    String url;

    public HttpServiceExterno(String url){
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder strBuilder = new StringBuilder();
        String str = "";

        try{
            URL url;
            url = new URL(this.url);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                strBuilder.append(scanner.next());
                str += strBuilder + scanner.nextLine();
            }

            //Log.e("StrBuilder", strBuilder.toString());
            //Log.e("Str", str);
            /*JSONArray jArray = new JSONArray(strBuilder.toString());
            p = new Gson().fromJson(jArray.getJSONObject(0).toString(), Permissao.class);*/
        }catch (Exception e){
            e.printStackTrace();
        }

        //Log.e("StrBuilder", str);
        return str;
    }
}
