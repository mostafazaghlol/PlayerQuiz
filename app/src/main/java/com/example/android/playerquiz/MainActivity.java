package com.example.android.playerquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String,Integer> Players=new HashMap<>();
    ImageView image1,image2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView) findViewById(R.id.playerImage1);
        image2 =(ImageView)findViewById(R.id.playerImage2);
        Players.put("Messi",R.mipmap.messi);
        Players.put("Ronaldo",R.mipmap.ronaldo2);
        Players.put("Benzema",R.mipmap.benzema);
        try {
            image1.setImageResource(Players.get("Messi"));
            image2.setImageResource(Players.get("Benzema"));
        }catch (Exception e){
            Log.e("MainActivity"," "+e.getMessage());
        }
    }
}
