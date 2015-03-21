package com.wlodsgn.bunbunup;

import android.app.Activity;
import android.os.Bundle;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.wlodsgn.bunbunup.app.AppController;

/**
 * Created by Harry on 20/03/2015.
 */
public class FullScreenActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreenimg);

        Bundle mExtras = getIntent().getExtras();
        String mImageUrl = (String) mExtras.get("EXTRA_IMAGE_URL");

        if (mExtras == null || !mExtras.containsKey("EXTRA_IMAGE_URL")) {
            finish();
            // TODO(tarandeep): toast
        }

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView fullScreenView;
                fullScreenView = (NetworkImageView) findViewById(R.id.fullScreenImg);
                fullScreenView.setImageUrl(mImageUrl, imageLoader);

        /*((NetworkImageView) findViewById(R.id.fullScreenImg)).setImageUrl(
                mExtras.getString("EXTRA_IMAGE_URL"), LruBitmapCache.getImageLoader());*/
    }
}
