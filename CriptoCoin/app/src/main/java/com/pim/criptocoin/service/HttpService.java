package com.pim.criptocoin.service;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.pim.criptocoin.model.Permissao;

import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpService extends AsyncTask<Void,Void, String> {
    String action;
    int id;

    public HttpService(String action, int id){
        this.action = action;
        this.id = id;
    }

    @Override
    protected String doInBackground(Void... voids) {

        StringBuilder strBuilder = new StringBuilder();
        String str = "";
        try{
            URL url;
            if(id > 0){
                url = new URL("https://criptocoinapi.azurewebsites.net/criptocoin/" + action + "/" + id);
            }else {
                url = new URL("https://criptocoinapi.azurewebsites.net/criptocoin/" + action);
            }

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNextLine()) {
                //strBuilder.append(scanner.next());
                str += /*strBuilder +*/ scanner.nextLine();
            }

            //Log.e("StrBuilder", strBuilder.toString());
            //Log.e("Str", str);
            /*JSONArray jArray = new JSONArray(strBuilder.toString());
            p = new Gson().fromJson(jArray.getJSONObject(0).toString(), Permissao.class);*/
        }catch (Exception e){
            Log.e("AcessouErro",e.toString());
            e.printStackTrace();
        }

        //Log.e("StrBuilder", str);
        return str;
    }
}
