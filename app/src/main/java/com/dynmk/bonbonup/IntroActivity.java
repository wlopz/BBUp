package com.dynmk.bonbonup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

/**
 * Created by WiLo on 2/13/2015.
 */
public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_intro);
        Log.i("BunBunUp", "MainActivity Created");
    }

    public void startMenuActivity(View v){
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    protected void onResume(){
        super.onResume();
        Log.i("BunBunUp", "IntroActivity Resumed");
    }

    protected void onPause(){
        super.onPause();
        Log.i("BunBunUp", "IntroActivity Paused");
    }

    protected void onStop(){
        super.onStop();
        Log.i("BunBunUp", "IntroActivity Stopped");
    }
}
