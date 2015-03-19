package com.wlodsgn.bunbunup;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.toolbox.NetworkImageView;
import com.wlodsgn.bunbunup.app.AppController;
import com.wlodsgn.bunbunup.util.LruBitmapCache;

/**
 * Created by WILO on 3/17/2015.
 */
public class JnsDetailFSViewActivity extends Activity {

    public static final String EXTRA_IMAGE_URL = "thumbnailFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jnsdetailsfs);
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey(EXTRA_IMAGE_URL)) {
            finish();
            // TODO(tarandeep): toast
        }

        ((NetworkImageView) findViewById(R.id.thumbnailFS)).setImageUrl(
                extras.getString(EXTRA_IMAGE_URL), LruBitmapCache.getImageLoader());

        /**if (Build.VERSION.SDK_INT >= VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayShowHomeEnabled(true);
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }**/

    }
}
