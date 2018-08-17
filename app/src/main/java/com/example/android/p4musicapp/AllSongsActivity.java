package com.example.android.p4musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * the custom adapter implementation is based on the Udacity's and Google's Miwok application
 * original source of the code: https://github.com/udacity/ud839_Miwok
 */
public class AllSongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.all_songs);
        setContentView(R.layout.song_list);
        //create a list of songs by using arraylist and custom adapter
        final ArrayList<Songstwo> songs = new ArrayList<Songstwo>();
        songs.add(new Songstwo("Foo fighters", "Bridge burning", R.drawable.foofighters_wl));
        songs.add(new Songstwo("Foo fighters", "Walk", R.drawable.foofighters_wl));
        songs.add(new Songstwo("Foo fighters", "These days", R.drawable.foofighters_wl));
        songs.add(new Songstwo("Foo fighters", "Rope", R.drawable.foofighters_wl));
        songs.add(new Songstwo("Sheryl Crow", "Run Baby Run", R.drawable.sherylcrow_snmc));
        songs.add(new Songstwo("Sheryl Crow", "All I wanna Do", R.drawable.sherylcrow_snmc));
        songs.add(new Songstwo("Sheryl Crow", "Strong Enough", R.drawable.sherylcrow_snmc));
        songs.add(new Songstwo("Muse", "Starlight", R.drawable.muse_bhar));
        songs.add(new Songstwo("Muse", "Knights of Cydonia", R.drawable.muse_bhar));
        songs.add(new Songstwo("Muse", "Assassin", R.drawable.muse_bhar));


        // Create a songadapter, whose data source is a list of songs.

        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the list object in the view hierarchy of the activity.

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the Listview use the SongAdapter created above, so that the ListView will display list items for each song in the list.
        listView.setAdapter(adapter);

       // If the user choose any item from the list, that song will be started in the now playing activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              Intent intent = new Intent(AllSongsActivity.this, NowPlaying.class);
               intent.putExtra("Playing", (Parcelable) songs.get(position));
                startActivity(intent);
            }
        });
    }
}