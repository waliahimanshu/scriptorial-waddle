package com.scriptorial.waddle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {


    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, ScrollingActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.toolbar_layout);
        collapsingToolbar.setTitle("");

        TextView textView =
                 findViewById(R.id.backdrop);
        textView.setText("This is a long question of some exam. Pollution is causing heath issues in " +
                "many developed and developing countries. Discuss both views and give your opinion.");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null)
                        .show();
            }
        });
    }
}
