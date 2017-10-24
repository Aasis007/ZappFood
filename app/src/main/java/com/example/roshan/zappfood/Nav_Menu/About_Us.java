package com.example.roshan.zappfood.Nav_Menu;

import android.app.ActionBar;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshan.zappfood.R;


public class About_Us extends Fragment {

    public About_Us() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about__us, container, false);
    }
    @Override
    public void onResume() {
        super.onResume();
//        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        ActionBar actionBar = activity.getSupportActionBar();
//        actionBar.setTitle(R.string.my_fragment_title);
//        ActionBar actionBar = getActivity().getSupportActionBar();
//        getActivity().getSupportActionBar().setTitle("Online Order");
    }
}
