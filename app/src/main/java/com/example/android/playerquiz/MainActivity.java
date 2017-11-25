package com.example.android.playerquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    HashMap<String,Integer> Players=new HashMap<>();
    ImageView image1,image2;
    TextView txPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView) findViewById(R.id.playerImage1);
        image2 =(ImageView)findViewById(R.id.playerImage2);
        txPlayer = (TextView) findViewById(R.id.playerName);
        Players.put("messi", R.mipmap.messi);
        Players.put("ronaldo", R.mipmap.ronaldo2);
        Players.put("benzema", R.mipmap.benzema);
        Players.put("aita", R.mipmap.aita);
        Players.put("lukaku", R.mipmap.lukaku);

        setImagesAndName("benzemA", image2);


    }

    /*
    *setImages used to set the imageViews with the new pics.
     */
    private void setImagesAndName(String player1, ImageView IM) {
        //make text in lowercase.
        player1 = player1.toLowerCase();

        //set the images.
        //players is a hashmap
        IM.setImageResource(Players.get(player1));
        if (IM == image1) {
            setSecondImage(Players.get(player1), image2);
        } else {
            setSecondImage(Players.get(player1), image1);
        }
        txPlayer.setText(player1);

    }

    /*
    To set The secound image not the same of the first image
     */
    private void setSecondImage(int player1ID, ImageView IM) {
        List<Integer> valuesList = new ArrayList<>(Players.values());
        int randomIndex = new Random().nextInt(valuesList.size());

        Integer randomValue;
        do {
            randomValue = valuesList.get(randomIndex);
        } while (randomValue == player1ID);

        IM.setImageResource(randomValue);
    }

   /* private int setRandomPlayer(){
        List<Integer> valuesList = new ArrayList<>(Players.values());
        int randomIndex = new Random().nextInt(valuesList.size());

        Integer randomValue;
        randomValue = valuesList.get(randomIndex);

        return randomValue;


    }*/

}
