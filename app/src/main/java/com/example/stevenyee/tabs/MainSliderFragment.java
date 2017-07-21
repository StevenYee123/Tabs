package com.example.stevenyee.tabs;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainSliderFragment extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 2;

    public MainSliderFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //In order to call references in a fragment, we must use a View for the fragment to use
        final View view = inflater.inflate(R.layout.fragment_main_slider, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable(){
            @Override
            public void run(){
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new CameraFragment();
            }
            return null;
        }
        @Override
        public int getCount(){
            return int_items;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "HOME";
                case 1:
                    return "CAMERA";
            }
            return null;
        }
    }

}

