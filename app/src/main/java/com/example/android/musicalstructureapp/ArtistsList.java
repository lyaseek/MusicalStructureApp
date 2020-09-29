package com.example.android.musicalstructureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.android.musicalstructureapp.databinding.ActivityListBinding;

import java.util.stream.Collectors;

public class ArtistsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayAdapter<String> adapterArtist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.songsList.stream().map(Song::getmArtistName).collect(Collectors.toList()));
        ActivityListBinding bindingArtists = DataBindingUtil.setContentView(this, R.layout.activity_list);
        bindingArtists.listView.setAdapter(adapterArtist);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_artists, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu:
                startActivity(MainActivity.mainMenu);
                break;
            case R.id.songs:
                startActivity(MainActivity.songsIntent);
                break;
            case R.id.albums:
                startActivity(MainActivity.albumIntent);
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
