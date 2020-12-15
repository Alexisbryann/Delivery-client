package com.alexis.delivery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alexis.delivery.Adapters.CategoriesAdapter;
import com.alexis.delivery.Models.CategoriesModel;
import com.alexis.delivery.R;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment implements View.OnClickListener{

    ArrayList<CategoriesModel> categoryList;
    private CategoriesAdapter mCategoriesAdapter;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.categories_fragment,container,false);
        mRecyclerView = view.findViewById(R.id.rv_categories);

        categoryList = new ArrayList<CategoriesModel>();
        categoryList.add(new CategoriesModel("Phones",R.drawable.phones));
        categoryList.add(new CategoriesModel("Black Friday",R.drawable.black_friday));
        categoryList.add(new CategoriesModel("Food",R.drawable.food));
        categoryList.add(new CategoriesModel("Global",R.drawable.global));
        categoryList.add(new CategoriesModel("Official Stores",R.drawable.official_stores));
        categoryList.add(new CategoriesModel("Pay",R.drawable.pay));
        categoryList.add(new CategoriesModel("Play & Win",R.drawable.play_win));
        categoryList.add(new CategoriesModel("Televisions",R.drawable.televisions));

        mCategoriesAdapter = new CategoriesAdapter(getContext(),categoryList);
        mManager = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.setAdapter( mCategoriesAdapter);
        
        return view;
    }


    @Override
    public void onClick(View v) {

    }
}
