package com.asus.taxassignment.Utils;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SingletonRequest {

    private static SingletonRequest mInstance;
    private RequestQueue mRequestQueue;


    private SingletonRequest(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }


    public static synchronized SingletonRequest getInstance(Context context) {

        if (mInstance == null) {

            mInstance = new SingletonRequest(context);

        }

        return mInstance;
    }


    public RequestQueue getRequestQueue() {

        return mRequestQueue;

    }
}
