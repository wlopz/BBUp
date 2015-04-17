package com.dynmk.bonbonup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader;
import com.dynmk.bonbonup.app.AppController;

/**
 * Created by WiLo on 3/4/2015.
 */

public class JeansDetailsActivity extends ActionBarActivity implements View.OnClickListener {

    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";

    private static String bitmap="thumbnailUrl";
    private static String bitmap2="thumbnailUrl2";
    private static String bitmap3="thumbnailUrl3";

    /**private static String bitmapfull="thumbnailUrlFS";**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeansdetails);
        /**getSupportActionBar().hide();**/

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

    /**public void startFmContacto(View vw){
     Intent intent = new Intent(JeansDetailsActivity.this, FmContacto.class);
     startActivity(intent);
     }**/

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

            case R.id.btnstrp:
                intent = new Intent(this, CntctoDtlsActvty.class);
                startActivity(intent);
                break;
        }

    }



}
