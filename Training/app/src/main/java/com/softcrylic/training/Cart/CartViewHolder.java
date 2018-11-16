package com.softcrylic.training.Cart;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softcrylic.training.R;

public class CartViewHolder  extends  RecyclerView.ViewHolder{
    ImageView mImage;
    TextView mTitle;
    TextView mPrice;
    CardView mCardView = itemView.findViewById(R.id.cardview);
    public CartViewHolder(View itemView){
        super(itemView);
        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mPrice = itemView.findViewById(R.id.prodprice);
    }
}
