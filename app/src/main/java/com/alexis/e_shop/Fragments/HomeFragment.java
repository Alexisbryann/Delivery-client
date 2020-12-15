package com.alexis.e_shop.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alexis.e_shop.R;

public class HomeFragment extends Fragment {

    Fragment mCategories;
    Fragment mBlackFriday;
    FragmentManager mManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);

        mCategories = new CategoriesFragment();
        mBlackFriday = new BlackFridayDealsFragment();

        loadFragment(mCategories);
        loadFragment(mBlackFriday);

        return view;
    }
    private void loadFragment(Fragment fragment) {
    // create a FragmentManager
        mManager = getActivity().getSupportFragmentManager();
    // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = mManager.beginTransaction();
    // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.container1, mCategories);
        fragmentTransaction.replace(R.id.container2, mBlackFriday);
        fragmentTransaction.commit(); // save the changes
    }
}