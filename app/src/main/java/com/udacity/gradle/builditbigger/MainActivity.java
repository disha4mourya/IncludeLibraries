package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.libandroid.ShowJokes;
import com.example.libjava.JokeModel;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.pbLoadJoke);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        progressBar.setVisibility(View.VISIBLE);
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new OnTaskCompleted() {

            @Override
            public void onTaskCompleted(String result) {
                progressBar.setVisibility(View.GONE);
                showJoke(result);
            }
        });
        asyncTask.execute(new Pair<Context, String>(this, "Manfred"));

    }

    public void showJoke(String joke) {
        Intent intent = new Intent(this, ShowJokes.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }

}
