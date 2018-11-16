package com.softcrylic.training.Products;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.softcrylic.training.R;

public class AllProductViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    TextView mPrice;
    CardView mCardView = itemView.findViewById(R.id.cardview);
    Button mWishList = itemView.findViewById(R.id.wishlist);
    Button mAddTocart = itemView.findViewById(R.id.add);
    public AllProductViewHolder(View itemView){
        super(itemView);
        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mPrice = itemView.findViewById(R.id.prodprice);
    }
}
