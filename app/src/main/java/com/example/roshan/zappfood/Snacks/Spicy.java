package com.example.roshan.zappfood.Snacks;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.roshan.zappfood.ModelClass.Constants;
import com.example.roshan.zappfood.ModelClass.DbHandler;
import com.example.roshan.zappfood.ModelClass.Menu_item;
import com.example.roshan.zappfood.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import android.os.Handler;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Spicy extends Fragment {

    View myView;
    SharedPreferences sharedPreferences;
    private ListView lv_item;
    private ProgressDialog dialog;
    private DbHandler mydb;
    private SwipeRefreshLayout swipeRefreshLayout;
    String[] quantity = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11","12","13","14","15","16","17","18","19","20"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.activity_appetizers, container, false);
        dialog = new ProgressDialog(this.getActivity());
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading, please wait");
        new JSONTask().execute(Constants.BASE_URL +"/Zappfood/Menu/spicy_food.php");
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity())
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        ImageLoader.getInstance().init(config);
        lv_item = (ListView)myView . findViewById(R.id.detail_list_view);
        return myView;
    }


    public class JSONTask extends AsyncTask<String, String, List<Menu_item>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(!((getActivity())).isFinishing())
            {
                //show dialog
                dialog.show();
            }

        }

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
                    menu_item.setId(j.optString("Id"));
                    menu_item.setMenu_Type(j.optString("Menu_Type"));
                    menu_item.setItem_Name(j.optString("Item_Name"));
                    menu_item.setImage(Constants.BASE_URL +"/Zappfood/Image/" + j.getString("Image"));
                    menu_item.setItem_Price(j.optString("Item_Price"));
                    menu_item.setDescription(j.optString("Description"));
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
            dialog.dismiss();
            Menu_Adapter adapter=new Menu_Adapter(getActivity(),R.layout.menu_item,result);
            lv_item.setAdapter(adapter);
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
            inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder=null;
            sharedPreferences = getActivity().getSharedPreferences("table_no", Context.MODE_PRIVATE);
            String tableId = sharedPreferences.getString("table_id","");



            if (convertView == null) {
                holder=new ViewHolder();
                convertView = inflater.inflate(R.layout.menu_item, null);
                mydb=new DbHandler(getActivity());
                holder.imageicon = (ImageView) convertView.findViewById(R.id.avatar);
                holder.txt_table_id=(TextView)convertView.findViewById(R.id.txt_table_id);
                holder. tvName = (TextView) convertView.findViewById(R.id.txt_item_name);
                holder. tvDescription = (TextView) convertView.findViewById(R.id.description);
                holder.tvprice=(TextView)convertView.findViewById(R.id.txt_foodPrice);
                holder.txt_price=(TextView)convertView.findViewById(R.id.foodPrice);
                holder.tv_subtotal=(TextView)convertView.findViewById(R.id.txt_id);
                holder.spinner1=(Spinner)convertView.findViewById(R.id.spinner);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, quantity);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                holder.spinner1.setAdapter(adapter);
                convertView.setTag(holder);
            }
            else{
                holder=(ViewHolder) convertView.getTag();
            }
            //data insert
            holder.tvName.setText(menu_items.get(position).getItem_Name());
            holder.tvDescription.setText(menu_items.get(position).getDescription());
            holder.tvprice.setText(menu_items.get(position).getItem_Price());
            String sub_price=holder.tvprice.getText().toString();
            holder.txt_price.setText("Rs. "+sub_price);
            holder.tv_subtotal.setText(menu_items.get(position).getId());
            holder.txt_table_id.setText(tableId);
            Log.d("MainActivity", "Image = " + menu_items.get(position).getImage());
            ImageLoader.getInstance().displayImage(menu_items.get(position).getImage(), holder.imageicon);
            final ViewHolder finalHolder = holder;

            holder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    if (finalHolder.spinner1.getSelectedItemPosition()>0)
                   {
                       int price=(Integer.parseInt(finalHolder.tvprice.getText().toString()));
                       int subtotal=price *(finalHolder.spinner1.getSelectedItemPosition());
                       finalHolder.tv_subtotal.setText(String .format(String.valueOf(subtotal)));
                       mydb.insertData(finalHolder.tvName.getText().toString(), String.valueOf(subtotal), finalHolder.spinner1.getSelectedItemPosition(),finalHolder.txt_table_id.getText().toString());
                     //  mydb.updateData(finalHolder.tvName.getText().toString(),String.valueOf(subtotal),finalHolder.spinner1.getSelectedItemPosition());

                       //  mydb.updateData(null,finalHolder.tvName.getText().toString(),String.valueOf(subtotal), finalHolder.spinner1.getSelectedItemPosition());
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
            private ImageView imageicon;
            private  TextView tvName,tv_subtotal,tvDescription,tvprice,txt_price,txt_table_id;
            private Spinner spinner1;
        }
    }


}
