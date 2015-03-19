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

/**
 * Created by WiLo on 2/13/2015.
 */
public class FmMenu extends Fragment {

    String[] productos = {
            "Jeans"
    };

    int[] imagenes = {
            R.drawable.veroxjeans1,
            R.drawable.veroxjeans2,
            R.drawable.veroxjeans3,
            R.drawable.veroxjeans4,
            R.drawable.veroxjeans5,
            R.drawable.veroxjeans6,
            R.drawable.veroxjeans7
    };

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.lay_menufragment, container, false);



        //lista
        ListView lista = (ListView) rootView.findViewById(R.id.listView1);
        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long l) {
                switch(position){
                    case 0 :
                    Intent ii = new Intent(getActivity(), JeansActivity.class);
                    startActivity(ii);
                    break;
                }

            }

        });

        //galeria de imagenes

        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[0]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[1]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[2]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[3]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[4]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[5]));
        mSectionsPagerAdapter.addfragments(PlaceholderFragment.newInstance(imagenes[6]));

        mViewPager.setAdapter(mSectionsPagerAdapter);

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


    public static class PlaceholderFragment extends Fragment {

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

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageView1);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }

}
