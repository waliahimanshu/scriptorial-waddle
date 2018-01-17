package com.scriptorial.waddle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class ScrollingActivity extends AppCompatActivity {


    public static final int INVALID_SCROLL_RANGE = 1;
    public static final String EMPTY = " ";
    private EditText editText;

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, ScrollingActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.toolbar_layout);
        AppBarLayout appBarLayout =  findViewById(R.id.app_bar);

        //remove title from tool bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        editText = findViewById(R.id.backdrop);


//        final ImageView editButton = findViewById(R.id.edit_button);
//
//        editButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


//        textView.setText();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null)
                        .show();
            }
        });


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = INVALID_SCROLL_RANGE;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == INVALID_SCROLL_RANGE) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Title");
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbar.setTitle(EMPTY);
                    isShow = false;
                }
            }
        });


    }

    public void onClickOf(View view) {
        editText.setFocusable(true);
        editText.setEnabled(true);
        editText.setCursorVisible(true);
    }
}
