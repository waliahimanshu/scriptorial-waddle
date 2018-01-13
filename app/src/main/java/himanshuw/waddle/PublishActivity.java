package himanshuw.waddle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;
import himanshuw.scriptorial_waddle.R;

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
}
