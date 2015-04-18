package com.dynmk.bonbonup;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by WiLo on 2/13/2015.
 */
public class FmMenu extends Fragment {

    int[] imagenes = {
            R.drawable.jeans,
            R.drawable.blusas,
            R.drawable.leggings,
    };

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lay_menufragment, container, false);

        //galeria de imagenes

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[0]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[1]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[2]));

        mViewPager.setAdapter(mSectionsPagerAdapter);

        return rootView;

        //imagen
        /**ImageView imagen = (ImageView) rootView.findViewById(R.id.imageJns);

         imagen.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

        startActivity(new Intent(getActivity(),JeansActivity.class));

        }

        });
         return rootView;**/
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentos;
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            fragmentos = new ArrayList<Fragment>();
        }

        public void addfragments(Fragment xfragment){
            fragmentos.add(xfragment);
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        @Override
        public int getCount() {
            return fragmentos.size();
        }

        /**@Override
        public Object instantiateItem(View collection, final int pos) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View page = inflater.inflate(R.layout.activity_jeans, null);

        page.setOnClickListener(new OnClickListener(){
        @Override
        public void onClick(View v) {

        startActivity(new Intent(getActivity(),JeansActivity.class));

        }
        });


        ((ViewPager) collection).addView(page, 0);
        return page;
        }**/

    }


    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static PlaceholderFragment newInstance(int imagen) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        public void onClick(View v){

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

            ImageView mainimages = (ImageView) rootView.findViewById(R.id.imageView1);
            mainimages.setImageResource(imagen);

            mainimages.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent activityIntent = new Intent();

                    Intent intent = new Intent();

                    switch(imagen){
                        case R.drawable.jeans:
                            intent = new Intent(getActivity(), JeansActivity.class);
                            break;
                        case R.drawable.blusas:
                            intent = new Intent(getActivity(), BlusasActivity.class);
                            break;
                        case R.drawable.leggings:
                            intent = new Intent(getActivity(), LeggingsActivity.class);
                            break;
                    }

                    startActivity(intent);

                }


            });

            return rootView;
        }
    }

}

