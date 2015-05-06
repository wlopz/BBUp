package com.dynmk.bonbonup;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader;
import com.dynmk.bonbonup.app.AppController;

public class JeansDetailsActivity extends ActionBarActivity implements View.OnClickListener {

    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";

    private static String bitmap="thumbnailUrl";
    private static String bitmap2="thumbnailUrl2";
    private static String bitmap3="thumbnailUrl3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeansdetails);

        //Custom text
        String fontPath = "fonts/AvenirLTStd-Roman.otf";
        String fontPath2 = "fonts/AvenirLTStd-Light.otf";

        TextView cstmTxt1 = (TextView) findViewById(R.id.titulo);
        Typeface tf1 = Typeface.createFromAsset(getAssets(),fontPath);
        cstmTxt1.setTypeface(tf1);

        TextView cstmTxt2 = (TextView) findViewById(R.id.colortitle);
        Typeface tf2 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt2.setTypeface(tf2);

        TextView cstmTxt3 = (TextView) findViewById(R.id.color);
        Typeface tf3 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt3.setTypeface(tf3);

        TextView cstmTxt4 = (TextView) findViewById(R.id.tipotitle);
        Typeface tf4 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt4.setTypeface(tf4);

        TextView cstmTxt5 = (TextView) findViewById(R.id.tipo);
        Typeface tf5 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt5.setTypeface(tf5);

        TextView cstmTxt6 = (TextView) findViewById(R.id.marcatitle);
        Typeface tf6 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt6.setTypeface(tf6);

        TextView cstmTxt7 = (TextView) findViewById(R.id.marca);
        Typeface tf7 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt7.setTypeface(tf7);

        TextView cstmTxt8 = (TextView) findViewById(R.id.reftitle);
        Typeface tf8 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt8.setTypeface(tf8);

        TextView cstmTxt9 = (TextView) findViewById(R.id.ref);
        Typeface tf9 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt9.setTypeface(tf9);

        TextView cstmTxt10 = (TextView) findViewById(R.id.info);
        Typeface tf10 = Typeface.createFromAsset(getAssets(),fontPath);
        cstmTxt10.setTypeface(tf10);

        TextView cstmTxt11 = (TextView) findViewById(R.id.hazclick);
        Typeface tf11 = Typeface.createFromAsset(getAssets(),fontPath2);
        cstmTxt11.setTypeface(tf11);

        //Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // enabling action bar app icon and behaving it as toggle button
        actionBar.setLogo(R.drawable.ic_main);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        //Redirect to Contacto
        Log.i("BunBunUp", "Contacto Redirected");

        Intent i=getIntent();
        String titulo = i.getStringExtra(Titulo);
        TextView titleName = (TextView) findViewById(R.id.titulo);
        titleName.setText(titulo);

        String marca = i.getStringExtra(Marca);
        TextView marcaName = (TextView) findViewById(R.id.marca);
        marcaName.setText(marca);

        String color = i.getStringExtra(Colour);
        TextView colorName = (TextView) findViewById(R.id.color);
        colorName.setText(color);

        String tipo = i.getStringExtra(Tipo);
        TextView tipoName = (TextView) findViewById(R.id.tipo);
        tipoName.setText(tipo);

        String ref = i.getStringExtra(Referencia);
        TextView refName = (TextView) findViewById(R.id.ref);
        refName.setText(ref);


        for (int num = 1; num <= 3; num++) {
            String pos;
            if (num == 1) {
                pos = "";
            } else {
                pos = String.valueOf(num);
            }

            ImageLoader imageLoader = AppController.getInstance().getImageLoader();
            String bitmap = i.getStringExtra(new String("image" + pos));

            NetworkImageView thumbNail;

            switch(num) {
                case 1:
                    thumbNail = (NetworkImageView) findViewById(R.id.thumbnail);
                    thumbNail.setImageUrl(bitmap, imageLoader);
                    break;
                case 2:
                    thumbNail = (NetworkImageView) findViewById(R.id.thumbnail2);
                    thumbNail.setImageUrl(bitmap, imageLoader);
                    break;
                case 3:
                    thumbNail = (NetworkImageView) findViewById(R.id.thumbnail3);
                    thumbNail.setImageUrl(bitmap, imageLoader);
                    break;
            }
        }

    }

    public void onClick(View v){
        Intent i = getIntent();
        Intent intent;
        switch(v.getId()){
            case R.id.thumbnail:
                intent = new Intent(this, FullScreenActivity.class);
                intent.putExtra("EXTRA_IMAGE_URL", i.getStringExtra("image"));
                startActivity(intent);
                break;

            case R.id.thumbnail2:
                intent = new Intent(this, FullScreenActivity.class);
                intent.putExtra("EXTRA_IMAGE_URL", i.getStringExtra("image2"));
                startActivity(intent);
                break;

            case R.id.thumbnail3:
                intent = new Intent(this, FullScreenActivity.class);
                intent.putExtra("EXTRA_IMAGE_URL", i.getStringExtra("image3"));
                startActivity(intent);
                break;

        }

    }



}
