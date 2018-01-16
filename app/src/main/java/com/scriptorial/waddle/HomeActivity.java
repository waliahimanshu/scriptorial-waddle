package com.scriptorial.waddle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.scriptorial.waddle.database.User;
import com.scriptorial.waddle.database.UserDao;
import com.scriptorial.waddle.database.UserDatabase;
import com.scriptorial.waddle.login.LoginActivity;
import com.scriptorial.waddle.publisher.PublishActivity;

public class HomeActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    // Firebase instance variables
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    public static final String ANONYMOUS = "anonymous";
    private String mUsername;
    private String mPhotoUrl;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PublishActivity.getLaunchIntent(getBaseContext()));
                //                startActivity(ScrollingActivity.getLaunchIntent(getBaseContext()));
            }
        });

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            // Not signed in, launch the Sign In activity

            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        } else {
            
            String[] split = firebaseUser.getDisplayName().split(" ");
            UserDao userDao = UserDatabase.getInstance(getBaseContext()).getUserDao();

            if (userDao.findById(firebaseUser.getUid())!=null)
            userDao.insert(
                    new User(firebaseUser.getUid(), split[0], split[1], mPhotoUrl));
            if (firebaseUser.getPhotoUrl() != null) {
                firebaseUser.getPhotoUrl().toString();
            }
        }

        mGoogleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this /* FragmentActivity */, this /*
        OnConnectionFailedListener */).addApi(Auth.GOOGLE_SIGN_IN_API).build();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.signout_main, menu);
        return true;
    }


    /**
     * sign out
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                firebaseAuth.signOut();
                Auth.GoogleSignInApi.signOut(mGoogleApiClient);
                mUsername = ANONYMOUS;
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(HomeActivity.class.getSimpleName(), "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
}