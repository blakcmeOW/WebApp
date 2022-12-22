package com.example.myapplication;

import android.view.View;

public interface ItemClickListener {
    public default void Onclick(View view, int position) {

    }
}
