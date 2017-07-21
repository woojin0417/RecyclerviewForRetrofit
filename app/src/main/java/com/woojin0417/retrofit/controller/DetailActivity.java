package com.woojin0417.retrofit.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.woojin0417.retrofit.R;

/**
 * Created by ash on 2017-07-20.
 */

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView txtRank,txtNm;
    Toolbar mActionBarToolbar;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.image_header);
        txtRank=(TextView)findViewById(R.id.header);
        txtNm=(TextView)findViewById(R.id.username);
        String rank=getIntent().getExtras().getString("rank");
        String url=getIntent().getExtras().getString("url");
        String Nm=getIntent().getExtras().getString("Nm");

        txtRank.setText(rank);
        txtNm.setText(Nm);
        Glide.with(this).load(url).into(imageView);
        getSupportActionBar().setTitle("Details Activity");

    }
   @Override
    public boolean onCreateOptionsMenu(Menu menu)
   {
       MenuInflater inflater=getMenuInflater();
       inflater.inflate(R.menu.detail,menu);
       MenuItem menuItem=menu.findItem(R.id.action_share);
       return true;
   }
}
