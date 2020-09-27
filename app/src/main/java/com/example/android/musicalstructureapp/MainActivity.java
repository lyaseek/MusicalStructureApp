package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.musicalstructureapp.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static
    List<Song> songsList = Arrays.asList(
            new Song("Appache 207", "Treppen Haus", R.mipmap.treppenhaus_appache, "Boot"),
            new Song("Elderbrook", "Why do we shake in the cold?", R.mipmap.why_do_we, "All My Love"),
            new Song("Washed Out", "Purple Noon", R.mipmap.purplenoon, "Face Up"),
            new Song("TWO LANES", "Lights", R.mipmap.lights, "The Rest Is Noise"),
            new Song("Taylor Swift", "folklore", R.mipmap.folklore, "the 1"),
            new Song("Rhye", "Blood", R.mipmap.blood, "Taste"));
    int b = 1;
    static Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song = songsList.get(new Random().nextInt(songsList.size()));
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (NowPlaying.v) {
            binding.currentSong.setText(getIntent().getStringExtra("song"));
            binding.albumImage.setImageResource(getIntent().getIntExtra("image", 50));
            for (int j = 0; j < songsList.size(); j++) {
                if (songsList.get(j).getSong().contentEquals(binding.currentSong.getText())) {
                    song = MainActivity.songsList.get(j);
                }
            }
        } else {
            binding.currentSong.setText(song.getSong());
            binding.albumImage.setImageResource(song.getAlbumImage());
        }
        Intent artistsIntent = new Intent(this, ArtistsList.class);
        binding.artistText.setOnClickListener(view -> {
            startActivity(artistsIntent);
        });
        Intent albumIntent = new Intent(this, AlbumList.class);
        binding.albumText.setOnClickListener(view -> {
            startActivity(albumIntent);
        });
        Intent songsIntent = new Intent(this, SongsList.class);
        binding.songsText.setOnClickListener(view -> {
            startActivity(songsIntent);
        });
        binding.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b % 2 != 0) {
                    binding.play.setImageResource(R.drawable.ic_baseline_pause_24);
                } else {
                    binding.play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                }
                b++;
            }
        });
        binding.forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song = songsList.get(new Random().nextInt(songsList.size()));
                binding.currentSong.setText(song.getSong());
                binding.albumImage.setImageResource(song.getAlbumImage());
            }
        });
        Intent intentCurrentSong = new Intent(this, NowPlaying.class);
        binding.currentSongString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentCurrentSong.putExtra("song", song.getSong());
                intentCurrentSong.putExtra("image", song.getAlbumImage());
                intentCurrentSong.putExtra("artist", song.getArtistName());
                startActivity(intentCurrentSong);
            }
        });
    }
}
//app:imageResource="@{song.albumImage}"