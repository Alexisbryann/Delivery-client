package com.alexis.delivery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.alexis.delivery.Fragments.BlackFridayDealsFragment;
import com.alexis.delivery.Models.CategoriesModel;
import com.alexis.delivery.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> implements View.OnClickListener {

    private final Context mContext;
    ArrayList mValues;
    private int mPos;
    FragmentManager mManager;

    public CategoriesAdapter(Context context, ArrayList values
    ){
        mContext = context;
        mValues = values;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        View view = layoutInflater.inflate(R.layout.item_categories,parent,false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        holder.setData((CategoriesModel) mValues.get(position));

        mPos = holder.getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onClick(View v) {
        switch (mPos){
            case 0:
                Fragment fragment = new BlackFridayDealsFragment();
//                mManager = getClass().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = mManager.beginTransaction();
                fragmentTransaction.replace(R.id.rv_black_friday, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
        }
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {

         public ImageView mImg;
         public TextView mTv1;
        CategoriesModel item;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            mImg = itemView.findViewById(R.id.imageView2);
            mTv1 = itemView.findViewById(R.id.tv_product);

        }
        public void setData(CategoriesModel item) {
            this.item = item;
            mTv1.setText(item.getProductName());
            mImg.setImageResource(item.getImage());

        }
    }

}
