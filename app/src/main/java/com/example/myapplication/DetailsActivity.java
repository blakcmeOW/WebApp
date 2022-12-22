package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Intent i2;
    Bundle b2;
    ImageView ivDetails;
    TextView tvDetailsName;
    TextView tvDetailPrice;
    TextView tvDescription;
    EditText quantity;
    int position=0;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b2 = new Bundle();
        setContentView(R.layout.activity_details);
        i2=getIntent();
        b2=i2.getExtras();
        position =b2.getInt("position",0);
        ivDetails = findViewById(R.id.imageDetails);
        tvDetailsName = findViewById(R.id.textDetailName);
        tvDetailPrice = findViewById(R.id.textDetailPrice);
        tvDescription = findViewById(R.id.textDescription);
        quantity = findViewById(R.id.editTextNumber);
        ivDetails.setImageDrawable(getResources().obtainTypedArray(R.array.images).getDrawable(position));
        tvDetailsName.setText(getResources().getStringArray(R.array.products)[position]);
        tvDetailPrice.setText(getResources().getStringArray(R.array.prices)[position]);
        switch (position){
            case 0:
                tvDescription.setText(R.string.sofaSet);
                break;
            case 1:
                tvDescription.setText(R.string.wardrobeCabinet);
                break;
            case 2:
                tvDescription.setText(R.string.multifunctionalWardrobeCabinet);
                break;
        }
    }
}