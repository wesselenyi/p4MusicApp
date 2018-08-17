package com.example.android.p4musicapp;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * It represents the songs the user wants to listen.
 * It contains the artist's name, song title, album name and album image.
 */

public class Songstwo implements Parcelable {

    public static final Creator<Songstwo> CREATOR = new Creator<Songstwo>() {
        @Override
        public Songstwo createFromParcel(Parcel in) {
            return new Songstwo(in);
        }

        @Override
        public Songstwo[] newArray(int size) {
            return new Songstwo[size];
        }
    };
    private String mArtistName;
    private String mSongName;
    // Drawable resource ID
    private int mAlbumID;

    public Songstwo(String artistName, String songName, int albumID) {
        mArtistName = artistName;
        mSongName = songName;
        mAlbumID = albumID;
    }

    protected Songstwo(Parcel in) {
        mArtistName = in.readString();
        mSongName = in.readString();
        mAlbumID = in.readInt();
    }

    /**
     * Get the Artist's name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the song's name
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the image resource ID
     */
    public int getAlbumId() {

        return mAlbumID;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mArtistName);
        parcel.writeString(mSongName);
        parcel.writeInt(mAlbumID);
    }
}
