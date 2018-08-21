package com.example.android.p4musicapp;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

// this class is for the now playing song.

public class NowPlaying extends AppCompatActivity {
    private Songstwo songsplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Set the content of the activity to use the now_paying.xml layout file
        setContentView(R.layout.now_playing);

        TextView backToMainM =(TextView) findViewById(R.id.backToMainM);
        backToMainM.setOnClickListener(new View.OnClickListener() {
            // This is the back action to the main menu
            @Override
            public void onClick(View view) {
                Intent backMIntent = new Intent(NowPlaying.this, MainActivity.class);
                startActivity(backMIntent);
            }});

        Intent intent = getIntent();
        Songstwo songs = intent.getParcelableExtra("Playing");

        // Check whether there is data in the intent - i.e. the now playing button was called directly from the main activity
        if (intent.getExtras() != null) {
            //if the intent is called and not empty

            int imageRes = songs.getAlbumId();
            String artist = songs.getArtistName();
            String title = songs.getSongName();

            ImageView imageView = findViewById(R.id.nowplayingalbum);
            imageView.setImageResource(imageRes);

            TextView textView1 = findViewById(R.id.nowplayingartist);
            textView1.setText(artist);

            TextView textView2 = findViewById(R.id.nowplayingtitle);
            textView2.setText(title);
        } else {
            //if the intent is empty, then the default information should be displayed
            ImageView imageView = findViewById(R.id.nowplayingalbum);
            imageView.setImageResource(R.drawable.albumempty);

            TextView textView1 = findViewById(R.id.nowplayingartist);
            textView1.setText("empty");

            TextView textView2 = findViewById(R.id.nowplayingtitle);
            textView2.setText("empty");
        }


    }
}