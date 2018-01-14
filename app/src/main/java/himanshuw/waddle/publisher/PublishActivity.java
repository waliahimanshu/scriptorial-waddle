package himanshuw.waddle.publisher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TooltipCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import himanshuw.waddle.R;

public class PublishActivity extends AppCompatActivity {

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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save_action) {
            TooltipCompat.setTooltipText(findViewById(R.id.save_action),"Save your writing");

        }
        return super.onOptionsItemSelected(item);

    }
}
