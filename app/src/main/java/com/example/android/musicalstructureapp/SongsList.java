package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.android.musicalstructureapp.databinding.ActivityListBinding;

import java.util.Random;

public class SongsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActivityListBinding bindingSongs = DataBindingUtil.setContentView(this, R.layout.activity_list);
        AdapterSongs adapterSongs = new AdapterSongs(this, R.layout.songs_list, MainActivity.songsList);
        bindingSongs.listView.setAdapter(adapterSongs);
        Intent intent = new Intent(this, NowPlaying.class);
        bindingSongs.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView songCurrent = view.findViewById(R.id.song);
                TextView artist = view.findViewById(R.id.artist);
                MainActivity.song = MainActivity.songsList.get(new Random().nextInt(MainActivity.songsList.size()));
                for (int j = 0; j < MainActivity.songsList.size(); j++) {
                    if (MainActivity.songsList.get(j).getSong().contentEquals(songCurrent.getText()) && MainActivity.songsList.get(j).getArtistName().contentEquals(artist.getText())) {
                        MainActivity.song = MainActivity.songsList.get(j);
                    }
                }
                intent.putExtra("song", MainActivity.song.getSong());
                intent.putExtra("artist", MainActivity.song.getArtistName());
                intent.putExtra("image", MainActivity.song.getAlbumImage());
                startActivity(intent);
            }
        });
    }
}