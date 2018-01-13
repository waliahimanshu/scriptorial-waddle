package himanshuw.waddle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import himanshuw.scriptorial_waddle.R;

public class ReviewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewer);
        // registerForContextMenu(view);

    }

    /**
     * https://stackoverflow.com/questions/8569975/add-action-on-the-browsers-context-menu-after-an-image-long-press
     * https://stackoverflow.com/questions/16471764/creating-a-contextual-menu-when-long-pressing-item-in-android
     * https://stackoverflow.com/questions/25216188/add-one-more-option-to-android-messages-long-press-context-menu
     * https://developer.android.com/about/versions/marshmallow/android-6.0-changes.html#behavior-text-selection
     * https://medium.com/keepsafe-engineering/building-a-custom-overflow-menu-aaa09b0b9054
     * https://github.com/codepath/android_guides/wiki/Menus-and-Popups
     * https://medium.com/google-developers/custom-text-selection-actions-with-action-process-text-191f792d2999
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.reviewer_menu, menu);
    }
}
