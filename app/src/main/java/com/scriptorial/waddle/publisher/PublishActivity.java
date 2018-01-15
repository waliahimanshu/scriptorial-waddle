package com.scriptorial.waddle.publisher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TooltipCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.scriptorial.waddle.R;

public class PublishActivity extends AppCompatActivity {

    private DatabaseReference myRef;

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, PublishActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        EditText editText = findViewById(R.id.editText);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        getDelegate().setHandleNativeActionModesEnabled(false);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        // creates user node in json
        myRef = database.getReference("users");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_action) {
            TooltipCompat.setTooltipText(findViewById(R.id.save_action), "Save your writing");

            //saves to DB
            // myRef.setValue(new User("test","test@t.com"));
        }
        return super.onOptionsItemSelected(item);

    }
}
