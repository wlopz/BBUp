package com.wlodsgn.bunbunup;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

/**
 * Created by WiLo on 2/13/2015.
 */
public class FmMenu extends Fragment {

    String[] productos = {
            "Jeans"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lay_menufragment, container, false);


        //imagen
        ImageView imagen = (ImageView) rootView.findViewById(R.id.imageJns);

        imagen.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),JeansActivity.class));

            }

        });
        return rootView;
    }
}
