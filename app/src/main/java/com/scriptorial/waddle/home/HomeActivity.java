package com.scriptorial.waddle.home;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.scriptorial.waddle.R;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}