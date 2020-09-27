package com.example.android.musicalstructureapp;

import android.os.Bundle;

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
}