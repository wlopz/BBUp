package com.wlodsgn.bunbunup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader;
import com.wlodsgn.bunbunup.adapter.CustomListAdapter;
import com.wlodsgn.bunbunup.adapter.FlickrAdapter;
import com.wlodsgn.bunbunup.app.AppController;
import com.wlodsgn.bunbunup.model.Jeans;

/**
 * Created by WiLo on 3/4/2015.
 */
public class JeansDetailsActivity extends ActionBarActivity {
    private static String Titulo="titulo";
    private static String Marca="marca";
    private static String Colour="color";
    private static String Tipo="tipo";
    private static String Referencia="ref";

    private static String bitmapfull="thumbnailUrlFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeansdetails);
        /**getSupportActionBar().hide();**/

        ListOrGridItemClickListener listener = new ListOrGridItemClickListener();

        //Back button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

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

        ImageLoader imageLoader = AppController.getInstance().getImageLoader();
        String bitmap = i.getStringExtra("image");
        NetworkImageView thumbNail = (NetworkImageView) findViewById(R.id.thumbnail);
        thumbNail.setImageUrl(bitmap, imageLoader);

        /**ImageLoader imageLoaderFS = AppController.getInstance().getImageLoader();
        String bitmapfull = i.getStringExtra("imagefs");
        NetworkImageView thumbNailFS = (NetworkImageView) findViewById(R.id.thumbnailFS);
        thumbNailFS.setImageUrl(bitmapfull, imageLoaderFS);**/

        ImageLoader imageLoader2 = AppController.getInstance().getImageLoader();
        String bitmap2 = i.getStringExtra("image2");
        NetworkImageView thumbNail2 = (NetworkImageView) findViewById(R.id.thumbnail2);
        thumbNail2.setImageUrl(bitmap2, imageLoader2);

        ImageLoader imageLoader3 = AppController.getInstance().getImageLoader();
        String bitmap3 = i.getStringExtra("image3");
        NetworkImageView thumbNail3 = (NetworkImageView) findViewById(R.id.thumbnail3);
        thumbNail3.setImageUrl(bitmap3, imageLoader3);

    }

    private class ListOrGridItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(JeansDetailsActivity.this, JnsDetailFSViewActivity.class);
            /**NetworkImageView photo = FlickrAdapter.getItem(position);**/
            /**bitmapfull = ((String) FlickrAdapter.getItem(position)).getThumbnailUrlFS();**/
            intent.putExtra(JnsDetailFSViewActivity.EXTRA_IMAGE_URL, bitmapfull);


            startActivity(intent);
        }

    }



    public void onClickHandler(View v){
        switch(v.getId()){
            case R.id.thumbnail:
                startActivity(new Intent(this,JeansActivity.class));

            case R.id.thumbnail2:
                startActivity(new Intent(this,JeansActivity.class));

            case R.id.thumbnail3:
                startActivity(new Intent(this,JeansActivity.class));

            /**case R.id.thumbnailFS:
                startActivity(new Intent(this,JeansActivity.class));**/
        }

    }



}
