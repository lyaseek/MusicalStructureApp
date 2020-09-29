package com.example.android.musicalstructureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.android.musicalstructureapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static
    List<Song> songsList = Arrays.asList(
            new Song("Appache 207", "Treppen Haus", R.mipmap.treppenhaus_appache, "Boot"),
            new Song("Elderbrook", "Why do we shake in the cold?", R.mipmap.why_do_we, "All My Love"),
            new Song("Washed Out", "Purple Noon", R.mipmap.purplenoon, "Face Up"),
            new Song("TWO LANES", "Lights", R.mipmap.lights, "The Rest Is Noise"),
            new Song("Taylor Swift", "folklore", R.mipmap.folklore, "the 1"),
            new Song("Rhye", "Blood", R.mipmap.blood, "Taste"));
    Boolean playStatus = false;
    static Song song;
    static Intent songsIntent;
    static Intent intentCurrentSong;
    static Intent artistsIntent;
    static Intent albumIntent;
    static Intent mainMenu;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        songsIntent = new Intent(MainActivity.this, SongsList.class);
        intentCurrentSong = new Intent(MainActivity.this, NowPlaying.class);
        artistsIntent = new Intent(MainActivity.this, ArtistsList.class);
        albumIntent = new Intent(MainActivity.this, AlbumList.class);
        mainMenu = new Intent(MainActivity.this, MainActivity.class);
        song = songsList.get(new Random().nextInt(songsList.size()));
        if (NowPlaying.isSongSelected) {
            binding.currentSong.setText(getIntent().getStringExtra("song"));
            binding.albumImage.setImageResource(getIntent().getIntExtra("image", 50));
            for (int j = 0; j < songsList.size(); j++) {
                if (songsList.get(j).getmSong().contentEquals(binding.currentSong.getText())) {
                    song = MainActivity.songsList.get(j);
                }
                NowPlaying.isSongSelected = false;
            }
        } else {
            binding.currentSong.setText(song.getmSong());
            binding.albumImage.setImageResource(song.getmAlbumImage());
        }
        binding.artistText.setOnClickListener(this);
        binding.albumText.setOnClickListener(this);
        binding.songsText.setOnClickListener(this);
        binding.play.setOnClickListener(this);
        binding.forward.setOnClickListener(this);
        binding.currentSongString.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(getApplicationContext());
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.songs:
                startActivity(songsIntent);
                break;
            case R.id.albums:
                startActivity(albumIntent);
                break;
            case R.id.artists:
                startActivity(artistsIntent);
                break;
            case R.id.now_playing:
                intentCurrentSong.putExtra("song", song.getmSong());
                intentCurrentSong.putExtra("image", song.getmAlbumImage());
                startActivity(intentCurrentSong);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.artist_text:
                startActivity(artistsIntent);
                break;
            case R.id.album_text:
                startActivity(albumIntent);
                break;
            case R.id.songs_text:
                startActivity(songsIntent);
                break;
            case R.id.play:
                if (playStatus) {
                    binding.play.setImageResource(R.drawable.ic_baseline_pause_24);
                    playStatus = false;
                } else {
                    binding.play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                    playStatus = true;
                }

                break;
            case R.id.forward:
                song = songsList.get(new Random().nextInt(songsList.size()));
                binding.currentSong.setText(song.getmSong());
                binding.albumImage.setImageResource(song.getmAlbumImage());
                break;
            case R.id.currentSongString:
                intentCurrentSong.putExtra("song", song.getmSong());
                intentCurrentSong.putExtra("image", song.getmAlbumImage());
                startActivity(intentCurrentSong);
                break;
            default:
                break;
        }
    }
}
