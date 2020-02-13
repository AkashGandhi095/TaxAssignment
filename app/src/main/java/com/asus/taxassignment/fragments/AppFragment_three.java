package com.asus.taxassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asus.taxassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment_three extends Fragment {


    public AppFragment_three() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_fragment_three, container, false);

        //navigate to first fragment
        view.findViewById(R.id.fragmentOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.appFragment_one);
            }
        });


        //navigate to second fragment
        view.findViewById(R.id.fragmentSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.appFragment_two);
            }
        });
        return view;
    }

}
