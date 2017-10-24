package com.example.roshan.zappfood.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.ModelClass.Constants;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by roshan on 12/19/16.
 */

public class Background extends AsyncTask<String, Void, String> {
    Context context;
    Activity activity;

    public Background(Context ctxt) {
        this.context = ctxt;
        activity =(Activity) ctxt;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String cart_url = Constants.BASE_URL +"/Zappfood/login.php";

        if (type.equals("login")) {
            try {
                String table_id = params[1];
                URL url = new URL(cart_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =URLEncoder.encode("table_id", "UTF-8") + "=" + URLEncoder.encode(table_id, "UTF-8");
                Log.d("Background", "Post Data = " + post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream stream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, "iso-8859-1"));
                String result = "Success ";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                stream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context,result, Toast.LENGTH_LONG).show();
        System.out.println("Background :: result = " + result);
        try {
            JSONObject jsonObjet=new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
            JSONArray jsonArray=jsonObjet.getJSONArray("server_response");
            JSONObject jo=jsonArray.getJSONObject(0);
            String code=jo.getString("code");
            String message=jo.getString("message");
            if (code.equals("login_true")){

                    activity.startActivity(new Intent(activity, MainActivity.class));


                Toast.makeText(activity, ""+message, Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(activity, "Login failed", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

