package com.example.android.playerquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    HashMap<String,Integer> Players=new HashMap<>();
    ImageView image1,image2;
    TextView txPlayer;
    String TPlayerImage1, TPlayerImage2;
    byte count = 0;


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

        setImageAndName("benzemA", image2);

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isPlayer("benzema", image2);
                Toast.makeText(MainActivity.this, String.valueOf(count), Toast.LENGTH_SHORT).show();
            }
        });


    }

    /*
    *setImages used to set the imageViews with the new pics.
     */
    private void setImageAndName(String player1, ImageView IM) {
        //make text in lowercase.
        player1 = player1.toLowerCase();

        //set the images.
        //players is a hashmap
        IM.setImageResource(Players.get(player1));
        if (IM == image1) {
            TPlayerImage1 = player1;
            setSecondImage(Players.get(player1), image2);
        } else {
            TPlayerImage2 = player1;
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

    private void isPlayer(String PlayerName, ImageView IM) {
        PlayerName = PlayerName.toLowerCase();
        /*
        if the player hit imageView  and it is the correct answer so add increment @count by 1
         and else if it will return nothing
         */
        if (IM == image1) {
            if (PlayerName.equals(TPlayerImage1)) {
                count++;
                //Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();

            }
        } else if (IM == image2) {
            if (PlayerName.equals(TPlayerImage2)) {
                count++;
                //Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();

            }
        }


    }


}
