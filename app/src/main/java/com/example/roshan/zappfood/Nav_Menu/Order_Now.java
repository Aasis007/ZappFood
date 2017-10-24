package com.example.roshan.zappfood.Nav_Menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.ModelClass.Category_Model;
import com.example.roshan.zappfood.R;
import com.example.roshan.zappfood.Recycler_View_Package.Categorie_Adapter;

import java.util.ArrayList;
import java.util.List;


public class Order_Now extends Fragment {

    public Order_Now() {
    }

    private RecyclerView recyclerView;
    private Categorie_Adapter pAdapter;
    private View view;
    private ActionBar actionBar;
    final private  int ArrayImage[] = {R.drawable.sapgetti,R.drawable.bara,R.drawable.chicken,R.drawable.chowmein,R.drawable.burger,R.drawable.pizza,R.drawable.sapgetti,R.drawable.desert,R.drawable.burger,R.drawable.pizza};
    final private    int Place[] = {R.id.apetizer,R.id.breakfast,R.id.lunch,R.id.biryani,R.id.snacks,R.id.fast_food,R.id.deserts,R.id.nepali_specialist,R.id.dinner,R.id.beverage};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        view= inflater.inflate(R.layout.fragment_order__now, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        ArrayList categorie_model_detail = prepareData();
        pAdapter = new Categorie_Adapter(getActivity(),categorie_model_detail);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);
        pAdapter.notifyDataSetChanged();

        return view;
    }
    private ArrayList prepareData(){

        ArrayList categorie_detail = new ArrayList<>();
        for(int i = 0; i< ArrayImage.length; i++){
            Category_Model category_model = new Category_Model();
            category_model.setImage(ArrayImage[i]);
            category_model.setTitle(Place[i]);
            categorie_detail.add(category_model);
        }
        return categorie_detail;
    }
    @Override
    public void onResume() {
        super.onResume();
        //getActivity().setTitle(R.string.app_name);
        ((MainActivity) getActivity())
                .setActionBarTitle("Category");
    }
}
