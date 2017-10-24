package com.example.roshan.zappfood.Nav_Menu;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.zappfood.Check_Out;
import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.ModelClass.DbHandler;
import com.example.roshan.zappfood.ModelClass.Menu_item;
import com.example.roshan.zappfood.ModelClass.background;
import com.example.roshan.zappfood.R;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.roshan.zappfood.ModelClass.DbHandler.table_name;
import static com.example.roshan.zappfood.R.id.spinner;

/**
 * A simple {@link Fragment} subclass.
 */

public class Cart extends Fragment {
    private View view;
    private DbHandler myDb;
    private ListView lv;
    private TextView txt_total,txt_subtotal,txt_vat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.cart_list_view, container, false);
        lv=(ListView)view.findViewById(R.id.detail_list_view);
        txt_total = (TextView)view.findViewById(R.id.txt_total);
        txt_subtotal=(TextView)view.findViewById(R.id.txt_Subtotal);
        txt_vat = (TextView)view.findViewById(R.id.txt_vat);
        myDb=new DbHandler(getActivity());

             //cursor activity
        Cursor cursor = myDb.viewData();
        String[] from = {myDb.col_2,myDb.col_3,myDb.col_4,myDb.col_5};
        int[] to = {R.id.txt_item_name, R.id.foodPrice,R.id.spinner1,R.id.table_no};
        final cursor_adapter cd = new cursor_adapter(view.getContext(), R.layout.fragment_cart, cursor, from, to, 0);
        lv.setAdapter(cd);
        myDb.deleteDataSingle();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (isVisible()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // This code will always run on the UI thread, therefore is safe to modify UI elements.
                            Cursor c = myDb.total();
                            int sub_total = c.getInt(c.getColumnIndex("total_price"));
                            double vat = sub_total * 0.13;
                            double total = sub_total + vat;
                            txt_subtotal.setText(String.valueOf("Sub Total : " + sub_total));
                            txt_vat.setText(String.format("Vat : %.2f ", vat));
                            txt_total.setText(String.valueOf("Total : " + total));
                        }
                    });
                }
            }
        },0, 1000);

        cursor.requery();
        cd.notifyDataSetChanged();
        setHasOptionsMenu(true);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                checkOutItem(parent,position);
           }
       });
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new Order_Now()).commit();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            Cursor cursor = myDb.viewData();
            if (cursor.moveToFirst()){
                do {
                    String itemname=cursor.getString(cursor.getColumnIndex(myDb.col_2));
                    String price=cursor.getString(cursor.getColumnIndex(myDb.col_3));
                    String quantity=cursor.getString(cursor.getColumnIndex(myDb.col_4));
                   String table_no=cursor.getString(cursor.getColumnIndex(myDb.col_5));
                    new background(getActivity()).execute("cart",itemname,price,quantity,table_no);
                    Toast.makeText(getActivity(),""+item+" added to ordered list", Toast.LENGTH_SHORT).show();
                }while (cursor.moveToNext());
            }

            myDb.deletedata(table_name);
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }

    public void checkOutItem(AdapterView<?> parent,int position)
    {
        Cursor cursor = null;
        cursor = (Cursor) parent.getItemAtPosition(position);
//        Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
//        animation1.setDuration(1000);
//        view.startAnimation(animation1);
        String item=cursor.getString(cursor.getColumnIndex(myDb.col_2));
        String price=cursor.getString(cursor.getColumnIndex(myDb.col_3));
        String quantity=cursor.getString(cursor.getColumnIndex(myDb.col_4));
        String table_no=cursor.getString(cursor.getColumnIndex(myDb.col_5));
        new background(getActivity()).execute("cart",item,price,quantity,table_no);
    }

  public  class cursor_adapter extends SimpleCursorAdapter{
    LayoutInflater inflater;
    private int layout;


      public cursor_adapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
          super(context, layout, c, from, to, flags);
      }

      class ViewHolder{
          private Spinner spinner;
          private TextView txt_item,txt_price,txt_quantity,txt_table;
          private Button btn_delete;
      }
      public View newView(Context _context, Cursor _cursor, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) _context.getSystemService(_context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_cart, parent, false);
         ViewHolder holder=new ViewHolder();
          view.setTag(holder);
          holder. spinner=(Spinner)view.findViewById(R.id.spinner);
          holder.txt_item=(TextView)view.findViewById(R.id.txt_item_name);
          holder.txt_price=(TextView)view.findViewById(R.id.foodPrice);
          holder. txt_quantity=(TextView)view.findViewById(R.id.spinner1);
          holder. txt_table=(TextView)view.findViewById(R.id.table_no);
          holder.btn_delete=(Button)view.findViewById(R.id.btn_delete);

        return view;
    }

    @Override
    public void bindView(View view, Context context, final Cursor cursor) {
        super.bindView(view, context, cursor);
        final ViewHolder holder = (ViewHolder) view.getTag();
        final String item=cursor.getString(cursor.getColumnIndex(myDb.col_2));
        holder.txt_item.setText(item);
        final String table_no=cursor.getString(cursor.getColumnIndex(myDb.col_5));
        holder.txt_table.setText(table_no);
        final String c_quantity=cursor.getString(cursor.getColumnIndex(myDb.col_4));
        holder. txt_quantity.setText(c_quantity);
        final String price=cursor.getString(cursor.getColumnIndex(myDb.col_3));
        holder. txt_price.setText(price);
        String[] quantity = {holder.txt_quantity.getText().toString(),"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11","12","13","14","15","16","17","18","19","20"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        holder. spinner.setAdapter(adapter);
        holder.txt_quantity.setVisibility(View.GONE);
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
                animation1.setDuration(2000);
                v.startAnimation(animation1);
                myDb.deleteData(item);
                Toast.makeText(getActivity(), "Item "+item+" deleted from cart", Toast.LENGTH_SHORT).show();
                cursor.requery();
                notifyDataSetChanged();
            }
        });
       holder. spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (holder.spinner.getSelectedItemPosition()>0)
                {
                    String count= String.valueOf(holder.spinner.getSelectedItemPosition());
                    int price1=(Integer.parseInt(holder.txt_price.getText().toString()));
                    int pre_quantity=(Integer.parseInt(holder.txt_quantity.getText().toString()));
                    int subtotal=(price1 / pre_quantity)*(holder.spinner.getSelectedItemPosition());
                    holder.txt_quantity.setVisibility(View.GONE);
                    holder.txt_quantity.setText(count);
                    holder.txt_price.setText(String.format(String.valueOf(subtotal)));
                    myDb.insertData(item, String.valueOf(subtotal), Integer.parseInt(count),table_no);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity(), "Added to cart", Toast.LENGTH_SHORT).show();
            }

        });



    }

}
}

