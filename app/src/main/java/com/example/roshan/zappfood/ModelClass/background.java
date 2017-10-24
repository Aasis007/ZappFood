package com.example.roshan.zappfood.ModelClass;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

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

public class background extends AsyncTask<String, Void, String> {
    Context context;

    public background(Context ctxt) {
        this.context = ctxt;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String cart_url = Constants.BASE_URL +"/Zappfood/cart.php";

        if (type.equals("cart")) {
            try {
                String item_name = params[1];
                String item_price = params[2];
                String quantity = params[3];
                String table_id = params[4];

                URL url = new URL(cart_url);

                System.out.println("Http conection " +url.openConnection());
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =URLEncoder.encode("Item_name", "UTF-8") + "=" + URLEncoder.encode(item_name, "UTF-8") + "&" + URLEncoder.encode("Item_prie", "UTF-8") + "=" + URLEncoder.encode(item_price, "UTF-8") + "&" + URLEncoder.encode("quantity", "UTF-8") + "=" + URLEncoder.encode(quantity, "UTF-8") + "&" + URLEncoder.encode("table_id", "UTF-8") + "=" + URLEncoder.encode(table_id, "UTF-8");
                Log.d("Background", "Post Data = " + post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream stream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream, "iso-8859-1"));
                String result = "Inserted ";
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
    }

//    public void execute(String cart, int txt_item_name, int foodPrice, int spinner) {
//    }
}

