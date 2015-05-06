package com.dynmk.bonbonup;


import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viewpagerindicator.LinePageIndicator;
import java.util.List;
import java.util.ArrayList;

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

        //Custom text
        String fontPath = "fonts/Mistral.ttf";
        String fontPath2 = "fonts/AvenirLTStd-Light.otf";
        String fontPath3 = "fonts/AvenirLTStd-Roman.otf";

        TextView cstmTxt1 = (TextView) rootView.findViewById(R.id.customtext1);
        Typeface tf1 = Typeface.createFromAsset(getActivity().getAssets(),fontPath);
        cstmTxt1.setTypeface(tf1);

        TextView cstmTxt2 = (TextView) rootView.findViewById(R.id.customtext2);
        Typeface tf2 = Typeface.createFromAsset(getActivity().getAssets(),fontPath2);
        cstmTxt2.setTypeface(tf2);

        TextView cstmTxt3 = (TextView) rootView.findViewById(R.id.customtext3);
        Typeface tf3 = Typeface.createFromAsset(getActivity().getAssets(),fontPath3);
        cstmTxt3.setTypeface(tf3);

        TextView cstmTxt4 = (TextView) rootView.findViewById(R.id.mueva_img);
        Typeface tf4 = Typeface.createFromAsset(getActivity().getAssets(),fontPath2);
        cstmTxt4.setTypeface(tf4);

        //galeria de imagenes

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[0]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[1]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[2]));

        mViewPager.setAdapter(mSectionsPagerAdapter);

        //Set the pager with an adapter
        ViewPager pager = (ViewPager)rootView.findViewById(R.id.pager);
        /**pager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));**/

        //Bind the title indicator to the adapter
        LinePageIndicator lineIndicator = (LinePageIndicator)rootView.findViewById(R.id.lines);
        lineIndicator.setViewPager(pager);

        return rootView;

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

