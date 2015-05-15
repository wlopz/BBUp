package com.dynmk.bonbonup.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.dynmk.bonbonup.R;
import com.dynmk.bonbonup.app.AppController;
import com.dynmk.bonbonup.model.Blusas;

import java.util.List;

public class BlusasGridAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Blusas> blusasGrid;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public BlusasGridAdapter(Activity activity, List<Blusas> blusasGrid) {
        this.activity = activity;
        this.blusasGrid = blusasGrid;
    }

    @Override
    public int getCount() {
        return blusasGrid.size();
    }

    @Override
    public Object getItem(int location) {
        return blusasGrid.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.grid_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView marca = (TextView) convertView.findViewById(R.id.marca);
        TextView color = (TextView) convertView.findViewById(R.id.color);
        TextView tipo = (TextView) convertView.findViewById(R.id.tipo);
        TextView ref = (TextView) convertView.findViewById(R.id.ref);

        // getting blusas data for the row
        Blusas m = blusasGrid.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // titulo
        titulo.setText(m.getTitulo());

        // marca
        marca.setText(m.getMarca());

        // color
        color.setText(m.getColor());

        // tipo
        tipo.setText(m.getTipo());

        // referencia
        ref.setText(String.valueOf(m.getRef()));

        return convertView;
    }

}
