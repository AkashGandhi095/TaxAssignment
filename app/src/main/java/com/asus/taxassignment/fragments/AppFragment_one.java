package com.asus.taxassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.asus.taxassignment.R;
import com.asus.taxassignment.Utils.ApiConstants;
import com.asus.taxassignment.Utils.SingletonRequest;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppFragment_one extends Fragment implements Response.Listener<JSONObject> , Response.ErrorListener {


    public AppFragment_one() {}

    private String Url = "https://api.github.com/users/akashsarkar188";


    private ImageView profileView;
    private TextView nameView , followerView , followingView , bioView , publicRepoView , locView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_app_fragment_one, container, false);

        initViews(view);


        //Navigate to Second Fragment

        view.findViewById(R.id.fragmentTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.appFragment_two);
            }
        });

        //Navigate to Third Fragment
        view.findViewById(R.id.fragmentThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.appFragment_three);
            }
        });


        GetGitHubResponse();




        return view;
    }



    private void initViews(View view) {
        profileView = view.findViewById(R.id.profile_image);
        nameView = view.findViewById(R.id.name);
        followerView = view.findViewById(R.id.followers);
        followingView = view.findViewById(R.id.following);
        bioView = view.findViewById(R.id.bio);
        publicRepoView = view.findViewById(R.id.public_repo);
        locView = view.findViewById(R.id.loc);

    }

    private void GetGitHubResponse() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET , Url , null , this , this);

        SingletonRequest.getInstance(getActivity()).getRequestQueue().add(request);
    }



    @Override
    public void onResponse(JSONObject response) {
        if(response != null)
        {
            BindResponseToView(response);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("Error", "onErrorResponse: " +error.getMessage());
    }

    private void BindResponseToView(JSONObject response) {

        try {

            Glide.with(this).load(response.getString(ApiConstants.PROFILE_KEY)).into(profileView);

            nameView.setText(response.getString(ApiConstants.NAME_KEY));

            locView.setText(response.getString(ApiConstants.LOC_KEY));

            followerView.setText(String.valueOf(response.getInt(ApiConstants.FOLLOWERS_KEY)));

            followingView.setText(String.valueOf(response.getInt(ApiConstants.FOLLOWING_KEY)));

            bioView.setText(response.getString(ApiConstants.BIO_KEY));

            publicRepoView.setText(String.valueOf(response.getInt(ApiConstants.PUBLIC_REPO_KEY)));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
