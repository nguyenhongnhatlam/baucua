package com.example.duanbaucua;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Manhinh2 extends AppCompatActivity {
    Button buttonPlay;
    ImageView imageView3,imageView4,imageView5;
    ArrayList<Integer> mang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh2);
        buttonPlay = (Button)findViewById(R.id.buttonPlay);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);

        mang = new ArrayList<Integer>();
        mang.add(R.drawable.bau);
        mang.add(R.drawable.cua);
        mang.add(R.drawable.tom);
        mang.add(R.drawable.ca);
        mang.add(R.drawable.nai);
        mang.add(R.drawable.ga);

        buttonPlay. setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Random r = new Random();
                int n = r.nextInt(mang.size());
                imageView3.setImageResource(mang.get(n));

                int m = r.nextInt(mang.size());
                imageView4.setImageResource(mang.get(m));

                int k = r.nextInt(mang.size());
                imageView5.setImageResource(mang.get(k));

            }
        });

    }
}