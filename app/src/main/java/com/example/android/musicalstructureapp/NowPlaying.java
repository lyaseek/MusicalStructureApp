package com.example.android.musicalstructureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.musicalstructureapp.databinding.ActivityNowPlayingBinding;

public class NowPlaying extends AppCompatActivity {
    static boolean isSongSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ActivityNowPlayingBinding binding = DataBindingUtil.setContentView(NowPlaying.this, R.layout.activity_now_playing);
        binding.nowImage.setImageResource(getIntent().getIntExtra("image", 2));
        binding.nowSong.setText(getIntent().getStringExtra("song"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_current_song, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu:
                isSongSelected = true;
                MainActivity.mainMenu.putExtra("image", getIntent().getIntExtra("image", 2));
                MainActivity.mainMenu.putExtra("song", getIntent().getStringExtra("song"));
                startActivity(MainActivity.mainMenu);
                break;
            case R.id.albums:
                startActivity(MainActivity.albumIntent);
                break;
            case R.id.artists:
                startActivity(MainActivity.artistsIntent);
                break;
            case R.id.songs:
                startActivity(MainActivity.songsIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}