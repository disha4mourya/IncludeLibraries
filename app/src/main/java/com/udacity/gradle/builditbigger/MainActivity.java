package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.libandroid.ShowJokes;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.pbLoadJoke);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new OnTaskCompleted() {

            @Override
            public void onTaskCompleted(String result) {
                progressBar.setVisibility(View.GONE);
                openShowJokeIntent(result);
            }
        });
        asyncTask.execute();
    }

    public void openShowJokeIntent(String joke) {
        Intent intent = new Intent(this, ShowJokes.class);
        intent.putExtra(getString(R.string.jokes), joke);
        startActivity(intent);
    }

}
