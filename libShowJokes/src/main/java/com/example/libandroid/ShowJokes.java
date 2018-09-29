package com.example.libandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.bakerj.infinitecards.InfiniteCardView;

public class ShowJokes extends AppCompatActivity implements View.OnClickListener {

    String[] separatedJokes;
    private InfiniteCardView mCardView;
    private BaseAdapter mAdapter1, mAdapter2;
    private boolean mIsAdapter1 = true;
    Button btnPre, btnChange, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_jokes);

        initialiseButtons();
        getDataFromIntent();
    }

    public void initialiseButtons() {
        btnPre = findViewById(R.id.pre);
        btnPre.setOnClickListener(this);

        btnChange = findViewById(R.id.change);
        btnChange.setOnClickListener(this);

        btnNext = findViewById(R.id.next);
        btnNext.setOnClickListener(this);
    }

    public void getDataFromIntent() {
        separatedJokes = getIntent().getStringExtra(getString(R.string.jokes)).split(getString(R.string.split_key));
        if (separatedJokes.length == 1) {
            btnPre.setVisibility(View.GONE);
            btnChange.setVisibility(View.GONE);
            btnNext.setVisibility(View.GONE);
        }

        setDataOnCards();
    }

    public void setDataOnCards() {
        mCardView = findViewById(R.id.view);
        mAdapter1 = new CardAdapter(separatedJokes);
        mAdapter2 = new CardAdapter(separatedJokes);
        mIsAdapter1 = !mIsAdapter1;
        mCardView.setAdapter(mAdapter2);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.pre) {
            if (mIsAdapter1) {
                new Style2().setStyle(mCardView);
                mCardView.bringCardToFront(mAdapter1.getCount() - 1);
            } else {
                new Style1().setStyle(mCardView);
                mCardView.bringCardToFront(mAdapter2.getCount() - 1);
            }
        } else if (i == R.id.next) {
            if (mIsAdapter1) {
                new Style2().setStyle(mCardView);
            } else {
                new Style3().setStyle(mCardView);
            }
            mCardView.bringCardToFront(1);
        } else if (i == R.id.change) {
            if (mCardView.isAnimating()) {
                return;
            }
            if (mIsAdapter1) {
                new Style2().setStyle(mCardView);
                mCardView.setAdapter(mAdapter1);
            } else {
                new Style1().setStyle(mCardView);
                mCardView.setAdapter(mAdapter2);
            }
        }
    }
}
