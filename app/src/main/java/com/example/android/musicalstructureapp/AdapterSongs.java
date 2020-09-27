package com.example.android.musicalstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterSongs extends ArrayAdapter<Song> {
    List<Song> songsList;

    public AdapterSongs(Context context, int textViewResourceId, List<Song> objects) {
        super(context, textViewResourceId, objects);
        songsList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.songs_list, null);
        TextView textView = (TextView) v.findViewById(R.id.song);
        TextView textView2 = (TextView) v.findViewById(R.id.artist);
        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        imageView.setImageResource(songsList.get(position).getAlbumImage());
        textView2.setText(songsList.get(position).getArtistName());
        textView.setText(songsList.get(position).getSong());
        return v;
    }
}

