package com.alexis.delivery.Fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.alexis.delivery.Adapters.BlackFridayAdapter;
import com.alexis.delivery.Models.BlackFridayModel;
import com.alexis.delivery.R;

import java.util.ArrayList;

public class BlackFridayDealsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private BlackFridayAdapter mBlackFridayAdapter;
    ArrayList<BlackFridayModel> mList;
    private Button mAdd_to_cart;

    public BlackFridayDealsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_black_friday_deals,container,false);

        mRecyclerView = view.findViewById(R.id.rv_black_friday);
        mLinearLayoutManager = new LinearLayoutManager(getContext());

        mList = new ArrayList<>();
        mList.add(new BlackFridayModel(R.drawable.soya_beans,"Lorem Ipsum neque- 2kg ","200 ksh",5,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.jenny_beans,"Lorem Ipsum neque porro- 2kg","800 ksh",5,"Available on jumia express"));
        mList.add(new BlackFridayModel(R.drawable.kabras_sugar,"Lorem Ipsum neque- 2kg","500 ksh",3,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.mumias_sugar,"Lorem Ipsum neque porro- 3kg","200 ksh",4,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.red_beans,"Lorem Ipsum- 2kg","100 ksh",3,""));
        mList.add(new BlackFridayModel(R.drawable.rice_daawat,"Lorem Ipsum est - 5kg","100 ksh",3,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.rice_pearl,"Lorem Ipsum neque - 2kg","1000 ksh",3,""));
        mList.add(new BlackFridayModel(R.drawable.rice_sunrice,"Lorem Ipsum - 1kg","10 ksh",5,""));
        mList.add(new BlackFridayModel(R.drawable.batteries,"Lorem Ipsum neque porro","20ksh",3,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.bluetooth_accessories,"Lorem ","50 ksh",3,""));
        mList.add(new BlackFridayModel(R.drawable.headsets,"Lorem Ipsum","456 ksh",3,""));
        mList.add(new BlackFridayModel(R.drawable.portable_powerbanks,"Lorem Ipsum neque","809 ksh",4,"Available on Jumia express."));
        mList.add(new BlackFridayModel(R.drawable.screen_protectors,"Lorem qui dolorem","55 ksh",3,""));
        mList.add(new BlackFridayModel(R.drawable.smart_watches,"Lorem Ipsum neque","90 ksh",5,""));


        mBlackFridayAdapter = new BlackFridayAdapter(getContext(),mList);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mBlackFridayAdapter);

        mAdd_to_cart = view.findViewById(R.id.btn_add_to_cart);

            return view;
    }
}
