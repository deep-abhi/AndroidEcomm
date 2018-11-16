package com.softcrylic.training.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcrylic.training.R;
import com.softcrylic.training.activity.DetailActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter < ProductViewHolder > {


    private Context mContext;
    private List< ProductData > mProductList;

   public  MyAdapter(Context mContext, List < ProductData > mProductList){
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView;
        mView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_row_item, parent, false);
        return new ProductViewHolder(mView);
    }
    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
                  holder.mImage.setImageResource(mProductList.get(position).getProductImage());
                  holder.mTitle.setText(mProductList.get(position).getProductName());
                  holder.mCardView.setOnClickListener(new View.OnClickListener(){
                      @Override
                      public void onClick(View view){
                          Intent mIntent = new Intent(mContext,DetailActivity.class);
                                           mIntent.putExtra("Title", mProductList.get(holder.getAdapterPosition()).getProductName());
                                           mIntent.putExtra("Description", mProductList.get(holder.getAdapterPosition()).getProductDescription());
                                           mIntent.putExtra("Image", mProductList.get(holder.getAdapterPosition()).getProductImage());
                                           mContext.startActivity(mIntent);
                      }
                  });
    }
    @Override
    public int getItemCount() {
        return mProductList.size();
    }


}
