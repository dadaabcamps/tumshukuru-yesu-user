package com.drcdadaab.tumshukuruyesuuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSongActivity extends AppCompatActivity {

    TextView textViewSongContent;
    String title, content, hymnNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_song);

        textViewSongContent = (TextView) findViewById(R.id.textViewSongContent);

        Intent i = getIntent();
        title = i.getStringExtra("titleKey");
        content = i.getStringExtra("ContentKey");
        hymnNumber = i.getStringExtra("HymnNumberKey");

        textViewSongContent.setText (content);

        getSupportActionBar().setTitle(hymnNumber+".  "+title);


    }
}
