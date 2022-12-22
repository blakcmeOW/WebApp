package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerAdapter ra;
    Intent i1;
    Bundle b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = new Bundle();
        rv= findViewById(R.id.recyclerView);
        rv.setLayoutManager(new GridLayoutManager(this,1));
        ra = new RecyclerAdapter(this);
        ra.setOnClickListener(new ItemClickListener() {
            @Override
            public void Onclick(View view, int position) {
                i1 = new Intent(getApplicationContext(),DetailsActivity.class);
                b1.putInt("position",position);
                i1.putExtras(b1);
                startActivityForResult(i1,1);
            }
        });
        rv.setAdapter(ra);
    }
}