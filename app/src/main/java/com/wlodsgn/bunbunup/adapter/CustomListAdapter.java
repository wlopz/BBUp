package com.wlodsgn.bunbunup.adapter;

import com.wlodsgn.bunbunup.JnsDetailFSViewActivity;
import com.wlodsgn.bunbunup.R;
import com.wlodsgn.bunbunup.app.AppController;
import com.wlodsgn.bunbunup.model.Jeans;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by WiLo on 3/3/2015.
 */
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Jeans> jeansItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, List<Jeans> jeansItems) {
        this.activity = activity;
        this.jeansItems = jeansItems;
    }

    @Override
    public int getCount() {
        return jeansItems.size();
    }

    @Override
    public Object getItem(int location) {
        return jeansItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail2 = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail2);
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail3 = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail3);
        TextView titulo = (TextView) convertView.findViewById(R.id.titulo);
        TextView marca = (TextView) convertView.findViewById(R.id.marca);
        TextView color = (TextView) convertView.findViewById(R.id.color);
        TextView tipo = (TextView) convertView.findViewById(R.id.tipo);
        TextView ref = (TextView) convertView.findViewById(R.id.ref);

        // getting verox jeans data for the row
        Jeans m = jeansItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // thumbnail image 2
        thumbNail2.setImageUrl(m.getThumbnailUrl2(), imageLoader);

        // thumbnail image 3
        thumbNail3.setImageUrl(m.getThumbnailUrl3(), imageLoader);

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
