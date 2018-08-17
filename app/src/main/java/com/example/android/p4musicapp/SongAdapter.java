package com.example.android.p4musicapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songstwo> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    /**
     * This is the specific custom constructor. This constructor is based on the Miwok application
     * original source of the code: https://github.com/udacity/ud839_Miwok
     */
    public SongAdapter(Activity context, ArrayList<Songstwo> songs) {

        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.all_songs, parent, false);
        }

        // Get the current song object located at this position in the list
        Songstwo currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the artist's name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.artist_name);
        // Get the version name from the current song object and
        // set this text on the name TextView
        nameTextView.setText(currentSong.getArtistName());

        // Find the TextView in the list_item.xml layout with the song name
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.song_name);
        // Get the song namer from the current song object and
        // set this text on the number TextView
        numberTextView.setText(currentSong.getSongName());

        // Find the ImageView in the list_item.xml layout with the album's picture
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.album_picture);
        // Get the album's resource ID from the current song object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getAlbumId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }


}
