package com.example.android.musicalstructureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        bindingSongs.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView songCurrent = view.findViewById(R.id.song);
                TextView artist = view.findViewById(R.id.artist);
                MainActivity.song = MainActivity.songsList.get(new Random().nextInt(MainActivity.songsList.size()));
                for (int j = 0; j < MainActivity.songsList.size(); j++) {
                    if (MainActivity.songsList.get(j).getmSong().contentEquals(songCurrent.getText()) && MainActivity.songsList.get(j).getmArtistName().contentEquals(artist.getText())) {
                        MainActivity.song = MainActivity.songsList.get(j);
                    }
                }
                MainActivity.intentCurrentSong.putExtra("song", MainActivity.song.getmSong());
                MainActivity.intentCurrentSong.putExtra("artist", MainActivity.song.getmArtistName());
                MainActivity.intentCurrentSong.putExtra("image", MainActivity.song.getmAlbumImage());
                startActivity(MainActivity.intentCurrentSong);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_songs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu:
                startActivity(MainActivity.mainMenu);
                break;
            case R.id.albums:
                startActivity(MainActivity.albumIntent);
                break;
            case R.id.artists:
                startActivity(MainActivity.artistsIntent);
                break;
            case R.id.now_playing:
                MainActivity.intentCurrentSong.putExtra("song", MainActivity.song.getmSong());
                MainActivity.intentCurrentSong.putExtra("image", MainActivity.song.getmAlbumImage());
                startActivity(MainActivity.intentCurrentSong);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}