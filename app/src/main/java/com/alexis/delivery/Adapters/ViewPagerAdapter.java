package com.alexis.delivery.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alexis.delivery.Fragments.BlackFridayDealsFragment;
import com.alexis.delivery.Fragments.CategoriesFragment;
import com.alexis.delivery.Fragments.HomeFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        if (position == 0) {
            fragment = new HomeFragment();
        }else if (position == 1){
            fragment = new CategoriesFragment();
        }else if (position == 2){
            fragment = new BlackFridayDealsFragment();
        }else if (position == 3){
            fragment = new Fragment();
        }
        assert fragment != null;
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
                title = "Home";
        }
            else if (position==1) {
                title = "Categories";
        }
            else if (position==2){
                title = "Black Friday";
        }
            else if (position==3){
                title = "Help";
        }
        return title;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
