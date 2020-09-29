package com.example.android.musicalstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterAlbum extends ArrayAdapter<Song> {
    List<Song> songsList;

    public AdapterAlbum(Context context, int textViewResourceId, List<Song> objects) {
        super(context, textViewResourceId, objects);
        songsList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.albums_list, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.album);
        TextView textView2 = (TextView) convertView.findViewById(R.id.artist);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageResource(songsList.get(position).getmAlbumImage());
        textView2.setText(songsList.get(position).getmArtistName());
        textView.setText(songsList.get(position).getmAlbum());
        return convertView;
    }
}

