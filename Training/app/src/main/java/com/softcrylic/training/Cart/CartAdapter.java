package com.softcrylic.training.Cart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softcrylic.training.Cart.CartViewHolder;
import com.softcrylic.training.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter <CartViewHolder>{

    private Context mContext;
    private List<ModelCart> mCartList;

    public  CartAdapter(Context mContext, List < ModelCart > mCartList){
        this.mContext = mContext;
        this.mCartList = mCartList;
    }
    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView;
        mView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recylerview_row_cart, parent, false);
        return new CartViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final CartViewHolder cartViewHolder, int i) {
           cartViewHolder.mImage.setImageResource(mCartList.get(i).getProductImage());
           cartViewHolder.mTitle.setText(mCartList.get(i).getProductName());
           cartViewHolder.mPrice.setText(mCartList.get(i).getProductPrice());

    }

    @Override
    public int getItemCount() {
        return mCartList.size();
    }
}
