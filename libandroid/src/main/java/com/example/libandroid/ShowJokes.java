package com.example.libandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokes extends AppCompatActivity {

    String jokePassed = "";
    TextView tvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        tvJoke = findViewById(R.id.tvJoke);

        Intent intentData = getIntent();
        jokePassed = intentData.getStringExtra("joke");
        if (jokePassed != null)
            tvJoke.setText(jokePassed);

    }
}
