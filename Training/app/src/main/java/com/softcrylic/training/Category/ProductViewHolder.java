package com.softcrylic.training.Category;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softcrylic.training.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mTitle;
    CardView mCardView = itemView.findViewById(R.id.cardview);
    public ProductViewHolder(View itemView){
        super(itemView);
        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);

    }
}
