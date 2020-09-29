package com.example.android.musicalstructureapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.android.musicalstructureapp.databinding.ActivityListBinding;

public class AlbumList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActivityListBinding bindingAlbum = DataBindingUtil.setContentView(this, R.layout.activity_list);
        AdapterAlbum adapterAlbum = new AdapterAlbum(this, R.layout.albums_list, MainActivity.songsList);
        bindingAlbum.listView.setAdapter(adapterAlbum);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_albums, menu);
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
