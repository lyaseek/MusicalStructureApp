package com.example.android.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.android.musicalstructureapp.databinding.ActivityListBinding;

import java.util.stream.Collectors;

public class ArtistsList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayAdapter<String> adapterArtist = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.songsList.stream().map(Song::getArtistName).collect(Collectors.toList()));
        ActivityListBinding bindingArtists = DataBindingUtil.setContentView(this, R.layout.activity_list);
        bindingArtists.listView.setAdapter(adapterArtist);
    }
}