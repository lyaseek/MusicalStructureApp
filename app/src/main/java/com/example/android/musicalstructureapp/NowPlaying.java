package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.android.musicalstructureapp.databinding.ActivityNowPlayingBinding;

public class NowPlaying extends AppCompatActivity {
    static Boolean v = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ActivityNowPlayingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_now_playing);
        binding.nowImage.setImageResource(getIntent().getIntExtra("image", 2));
        binding.nowArtist.setText(getIntent().getStringExtra("artist"));
        binding.nowSong.setText(getIntent().getStringExtra("song"));
        Intent intent = new Intent(this, MainActivity.class);
        binding.mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v = true;
                intent.putExtra("image", getIntent().getIntExtra("image", 2));
                intent.putExtra("song", getIntent().getStringExtra("song"));
                startActivity(intent);
            }
        });
    }
}