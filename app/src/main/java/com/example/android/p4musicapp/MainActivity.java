package com.example.android.p4musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        // Find the View that shows all the songs in the player
        ImageView allsongs = (ImageView) findViewById(R.id.allsongs);

        // Set a click listener on that View
        allsongs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the allsongs View is clicked on.
            @Override
            public void onClick(View view) {
                Intent allsongsIntent = new Intent(MainActivity.this, AllSongsActivity.class);
                startActivity(allsongsIntent);
            }


        });

        // Find the View that shows the currently played song in the player
        ImageView nowplaying = (ImageView) findViewById(R.id.nowplaying);
// The code in this method will be executed when the nowplaying View is clicked on.
        nowplaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playingIntent = new Intent(MainActivity.this, NowPlaying.class);
                startActivity(playingIntent);
            }
        });
    }
}
