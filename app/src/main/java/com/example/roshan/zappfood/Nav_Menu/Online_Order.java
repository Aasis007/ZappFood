package com.example.roshan.zappfood.Nav_Menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roshan.zappfood.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Online_Order extends Fragment {


    public Online_Order() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_online__order, container, false);
    }

}
