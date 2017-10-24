package com.example.roshan.zappfood.Nav_Menu;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.roshan.zappfood.Acitivities_Packages.Appetizers;
import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.ModelClass.Constants;
import com.example.roshan.zappfood.ModelClass.DbHandler;
import com.example.roshan.zappfood.ModelClass.HttpHandler;
import com.example.roshan.zappfood.ModelClass.Menu_item;
import com.example.roshan.zappfood.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */

public class Home extends Fragment {
    Animation Fade_in,Fade_out;
    ViewFlipper viewFlipper;
    View myView;
    private ListView lv;
    SharedPreferences sharedPreferences;
    private DbHandler mydb;
    String[] quantity = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11","12","13","14","15","16","17","18","19","20"};


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_home, container, false);
        viewFlipper=(ViewFlipper) myView.findViewById(R.id.ViewFlipper);
        lv = (ListView) myView.findViewById(R.id.fav_list_view);
        viewFlipper.setAnimation(Fade_in);
        viewFlipper.setAnimation(Fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(2000);
        new JSONTask().execute(Constants.BASE_URL +"/Zappfood/Menu/favourite.php");
     //   new JSONTask().execute("http://192.168.100.7/Zappfood/Menu/favourite.php");

//        lv.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                        HashMap<String, String> item = favourite.get(position);
//                        if(item.containsKey("Item_name")) {
//                            String tel = item.get("Item_name");
//                            if(tel.equals("Item_name"))
//                                startActivity(new Intent(getActivity(), Appetizers.class));
//                        }
//
//
//
//                    }
//                }
//        );

        return myView;
    }

    //json parsing

    public class JSONTask extends AsyncTask<String, String, List<Menu_item>> {
        @Override
        protected List<Menu_item> doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;
            List<Menu_item> menu_items = new ArrayList<>();
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String finaljson = buffer.toString();
                Log.i("JSON", "String = " + finaljson);
                JSONArray array = new JSONArray(finaljson);

                int size = array.length();
                for (int i = 0; i < size; i++) {
                    JSONObject j = array.getJSONObject(i);
                    Menu_item menu_item = new Menu_item();
                    menu_item.setItem_Name(j.optString("Item_name"));
                    menu_item.setItem_Price(j.optString("Item_price"));
                    menu_item.setQuantity(j.optString("quantity"));
                    menu_items.add(menu_item);
                }
                return menu_items;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return menu_items;
        }
        @Override
        protected void onPostExecute(List<Menu_item> result) {
            super.onPostExecute(result);

            Menu_Adapter adapter=new Menu_Adapter(getActivity(),R.layout.favourite_item,result);
            lv.setAdapter(adapter);
        }


    }
    public class Menu_Adapter extends ArrayAdapter {
        public List<Menu_item> menu_items;
        private int resource;
        private LayoutInflater inflater;


        public Menu_Adapter(Context context, int resource, List<Menu_item> objects) {
            super(context, resource, objects);
            menu_items = objects;
            this.resource = resource;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Menu_Adapter.ViewHolder holder=null;
            sharedPreferences = getActivity().getSharedPreferences("table_no", Context.MODE_PRIVATE);
            String tableId = sharedPreferences.getString("table_id","");



            if (convertView == null) {
                holder=new Menu_Adapter.ViewHolder();
                convertView = inflater.inflate(R.layout.favourite_item, null);
                mydb=new DbHandler(getActivity());
                holder.txt_table_id=(TextView)convertView.findViewById(R.id.txt_table_id);
                holder. tvName = (TextView) convertView.findViewById(R.id.txt_item_name);
                holder.tvprice=(TextView)convertView.findViewById(R.id.txt_foodPrice);
                holder.txt_price=(TextView)convertView.findViewById(R.id.foodPrice);
                holder.quantity=(TextView)convertView.findViewById(R.id.quantity);
                holder.tv_subtotal=(TextView)convertView.findViewById(R.id.txt_id);
                holder.spinner1=(Spinner)convertView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, quantity);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                holder.spinner1.setAdapter(adapter);
                convertView.setTag(holder);
            }
            else{
                holder=(Menu_Adapter.ViewHolder) convertView.getTag();
            }
            //data insert
            holder.tvName.setText(menu_items.get(position).getItem_Name());
            holder.quantity.setText(menu_items.get(position).getQuantity());
            holder.tvprice.setText(menu_items.get(position).getItem_Price());
            String  sub_price=holder.tvprice.getText().toString();
            String  quantity1=holder.quantity.getText().toString();
            int item_price= Integer.parseInt(sub_price)/Integer.parseInt(quantity1);
            holder.txt_price.setText(Integer.toString(item_price));
            holder.tv_subtotal.setText(menu_items.get(position).getId());
            holder.txt_table_id.setText(tableId);
            final Menu_Adapter.ViewHolder finalHolder = holder;

            holder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (finalHolder.spinner1.getSelectedItemPosition()>0)
                    {
                        int price=(Integer.parseInt(finalHolder.txt_price.getText().toString()));
                        int subtotal=price *(finalHolder.spinner1.getSelectedItemPosition());
                        finalHolder.tv_subtotal.setText(String .format(String.valueOf(subtotal)));
                        mydb.insertData(finalHolder.tvName.getText().toString(), String.valueOf(subtotal), finalHolder.spinner1.getSelectedItemPosition(),finalHolder.txt_table_id.getText().toString());
                        Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
                }

            });
            return convertView;
        }
        class ViewHolder{
            private  TextView tvName,tv_subtotal,quantity,tvprice,txt_price,txt_table_id;
            private Spinner spinner1;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
