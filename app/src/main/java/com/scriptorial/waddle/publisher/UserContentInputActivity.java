package com.scriptorial.waddle.publisher;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.scriptorial.waddle.R;
import com.scriptorial.waddle.database.AppDatabase;
import com.scriptorial.waddle.database.Posts.Posts;
import com.scriptorial.waddle.database.Posts.PostsDao;
import com.scriptorial.waddle.database.Posts.PostsRepositoryImpl;
import com.scriptorial.waddle.home.HomeActivity;

public class UserContentInputActivity extends AppCompatActivity
        implements UserContentInputFragment.OnFragmentInteractionListener {

    public static final int INVALID_SCROLL_RANGE = 1;
    public static final String EMPTY = " ";
    private EditText editText;
    private UserContentInputViewModel mViewModel;

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, UserContentInputActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_content_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.toolbar_layout);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);

        // my_child_toolbar is defined in the layout file

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

        PostsDao postsDao = AppDatabase.getInstance(this).getPostsDao();
        mViewModel = new UserContentInputViewModel(new PostsRepositoryImpl(postsDao));

        editText = findViewById(R.id.edit_question_text);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setFocusable(true);
                editText.setCursorVisible(true);
                editText.setClickable(true);
                editText.setTextColor(getResources().getColor(R.color.light_bg_dark_primary_text));

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null)
                        .show();
            }
        });

        //
        //        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
        //            boolean isShow = false;
        //            int scrollRange = INVALID_SCROLL_RANGE;
        //            @Override
        //            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        //                if (scrollRange == INVALID_SCROLL_RANGE) {
        //                    scrollRange = appBarLayout.getTotalScrollRange();
        //                }
        //                if (scrollRange + verticalOffset == 0) {
        //                    collapsingToolbar.setTitle("Title");
        //                    isShow = true;
        //                } else if(isShow) {
        //                    collapsingToolbar.setTitle(EMPTY);
        //                    isShow = false;
        //                }
        //            }
        //        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "saving....", Toast.LENGTH_SHORT).show();

                Intent launchIntent = HomeActivity.getLaunchIntent(this);

                startActivity(launchIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(this, "saving....", Toast.LENGTH_SHORT).show();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.publisher_content_fragment);
       EditText viewById = findViewById(R.id.edit_question_text);
        EditText answer =  findViewById(R.id.editText_answer);
        viewById.getText();

        mViewModel.insertPosts(new Posts(1, auth.getCurrentUser().getUid(), answer.getText().toString(),
                viewById.getText().toString()));
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
