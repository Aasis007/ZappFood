package com.example.roshan.zappfood.Recycler_View_Package;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.zappfood.Acitivities_Packages.Appetizers;
import com.example.roshan.zappfood.Acitivities_Packages.Beverage;
import com.example.roshan.zappfood.Acitivities_Packages.Biryani;
import com.example.roshan.zappfood.Acitivities_Packages.Breakfast;
import com.example.roshan.zappfood.Acitivities_Packages.Deserts;
import com.example.roshan.zappfood.Acitivities_Packages.Dinner;
import com.example.roshan.zappfood.Acitivities_Packages.Fastfood;
import com.example.roshan.zappfood.Acitivities_Packages.Lunch;
import com.example.roshan.zappfood.Acitivities_Packages.Nepali_Specialaist;
import com.example.roshan.zappfood.Acitivities_Packages.Snacks;
import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.ModelClass.Category_Model;
import com.example.roshan.zappfood.R;

import java.util.ArrayList;

/**
 * Created by roshan on 2/1/17.
 */

public class Categorie_Adapter extends RecyclerView.Adapter<Categorie_Adapter.MyViewHolder>{
    private ArrayList<Category_Model> category_models;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView spot_image;
        private TextView spot_text;

        public MyViewHolder(View view) {
            super(view);
            spot_text = (TextView)view.findViewById(R.id.txt_spot_name);
            spot_image = (ImageView) view.findViewById(R.id.spot_image);
            context = view.getContext();
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            //  Toast.makeText(view.getContext(), DataProvider.JAVA_BOOKS[getAdapterPosition()], Toast.LENGTH_SHORT).show();
            String item= spot_text.getText().toString();
            Toast.makeText(view.getContext(),"You Clicked : "+item, Toast.LENGTH_SHORT).show();

            switch (getAdapterPosition()){
                case 0:
                    intent =  new Intent(context,Appetizers.class);
                    break;
                case 1:
                    intent =  new Intent(context, Breakfast.class);
                    break;
                case 2:
                    intent =  new Intent(context, Lunch.class);
                    break;
                case 3:
                    intent =  new Intent(context, Biryani.class);
                    break;
                case 4:
                    intent =  new Intent(context, Snacks.class);
                    break;
                case 5:
                    intent =  new Intent(context, Fastfood.class);
                    break;
                case 6:
                    intent =  new Intent(context, Deserts.class);
                    break;
                case 7:
                    intent =  new Intent(context, Nepali_Specialaist.class);
                    break;
                case 8:
                    intent =  new Intent(context, Dinner.class);
                    break;
                case 9:
                    intent =  new Intent(context, Beverage.class);
                    break;
                default:
                    intent =  new Intent(context, MainActivity.class);
                    break;
           }
            context.startActivity(intent);
        }
    }


    public Categorie_Adapter(Context context, ArrayList<Category_Model> category_model) {
        this.category_models= category_model;
        this.context =context;

    }



    @Override
    public Categorie_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categorie_detail, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(Categorie_Adapter.MyViewHolder holder, int position) {

        holder.spot_text.setText(category_models.get(position).getTitle());
//        ImageLoader.getInstance().displayImage(spotsList.get(position).getImage(), holder.spot_image);
        holder.spot_image.setImageResource(category_models.get(position).getImage());
    }



    @Override
    public int getItemCount() {
        return category_models.size();
    }
}
