package com.softcrylic.training.WishList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcrylic.training.R;
import com.softcrylic.training.fragment.HomeFragment;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter < WishListViewHolder >{

      public Context mContext;
      private List< WishList > mWishList;
      private HomeFragment list;

      public WishListAdapter(Context mContext,List < WishList> mWishList){
          this.mContext = mContext;
          this.mWishList = mWishList;
      }
    @Override
    public WishListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
          View mView;
        mView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_row_wishlist, viewGroup, false);

        return new WishListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final WishListViewHolder holder, int i) {
        holder.mImage.setImageResource(mWishList.get(i).getProductImage());
        holder.mTitle.setText(mWishList.get(i).getProductName());
        holder.mprice.setText(mWishList.get(i).getProductPrice());

    }

    @Override
    public int getItemCount() {
        return mWishList.size();
    }


}
