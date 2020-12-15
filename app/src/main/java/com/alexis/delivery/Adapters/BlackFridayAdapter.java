package com.alexis.delivery.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.alexis.delivery.Models.BlackFridayModel;
import com.alexis.delivery.R;

import java.util.ArrayList;

public class BlackFridayAdapter extends RecyclerView.Adapter<BlackFridayAdapter.ViewHolder> {

    private final Context mContext;
    private final ArrayList mList;


    public BlackFridayAdapter(Context context, ArrayList list){
        mContext = context;
        mList = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        View view = layoutInflater.inflate(R.layout.item_black_friday_deals,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.setData((BlackFridayModel) mList.get(position));
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImageView;
        private final TextView mTv1;
        private final TextView mTv2;
        private final TextView mTv3;
        private final RatingBar mRatingBar;
        private final Button mBtn1;
        BlackFridayModel item;
        private final ImageView mAdd;
        private final ImageView mSubtract;
        private final TextView mNum;
        int num = 1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView8);
            mTv1 = itemView.findViewById(R.id.tv_description);
            mTv2 = itemView.findViewById(R.id.tv_price);
            mTv3 = itemView.findViewById(R.id.tv_express);
            mRatingBar = itemView.findViewById(R.id.ratingBar);
            mBtn1 = itemView.findViewById(R.id.btn_add_to_cart);
            mAdd = itemView.findViewById(R.id.img_add);
            mSubtract = itemView.findViewById(R.id.img_subtract);
            mNum = itemView.findViewById(R.id.tv_num);
        }
        private void setData(BlackFridayModel item) {
            this.item = item;

            mImageView.setImageResource(item.getImage());
            mTv1.setText(item.getProduct_description());
            mTv2.setText(item.getPrice());
            mTv3.setText(item.getExpress());
            mRatingBar.setRating(5);
            mBtn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mBtn1.setVisibility(View.INVISIBLE);
                    mNum.setText(String.valueOf(num));
                }
            });
            mAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mNum.setText(String.valueOf(++num));
                }
            });
            mSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int sub = Integer.parseInt(mNum.getText().toString());
                    if (sub > 1) {
                        mNum.setText(String.valueOf(--num));
                    }else {
                        mBtn1.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }


}
