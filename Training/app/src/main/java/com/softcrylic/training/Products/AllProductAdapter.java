package com.softcrylic.training.Products;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softcrylic.training.Cart.ModelCart;
import com.softcrylic.training.R;
import com.softcrylic.training.WishList.WishList;
import com.softcrylic.training.activity.DetailActivity;
import com.softcrylic.training.Category.ProductData;

import java.util.ArrayList;
import java.util.List;

public class AllProductAdapter extends RecyclerView.Adapter < AllProductViewHolder > {

    private Context mContext;
    private List<ProductData> mProductList;

   public static List <WishList> mWishList = new ArrayList<>();
   public static List <ModelCart> mCartList = new ArrayList<>();
   WishList mWishListData;
   ModelCart mCartData;
    RecyclerView mRecyclerView;

    public  AllProductAdapter(Context mContext, List < ProductData > mProductList){
        this.mContext = mContext;
        this.mProductList = mProductList;
    }
    @Override
    public AllProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView;
        mView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.recyclerview_row_product, parent, false);

        return new AllProductViewHolder(mView);
}
    @Override
    public void onBindViewHolder(final AllProductViewHolder holder, final int position) {
        holder.mImage.setImageResource(mProductList.get(position).getProductImage());
        holder.mTitle.setText(mProductList.get(position).getProductName());
        holder.mPrice.setText(mProductList.get(position).getProductPrice());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Title", mProductList.get(holder.getAdapterPosition()).getProductName());
                mIntent.putExtra("Description", mProductList.get(holder.getAdapterPosition()).getProductDescription());
                mIntent.putExtra("Image", mProductList.get(holder.getAdapterPosition()).getProductImage());
                mIntent.putExtra("Price", mProductList.get(holder.getAdapterPosition()).getProductPrice());
                mContext.startActivity(mIntent);
            }
        });
        holder.mWishList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                holder.mWishList.setBackgroundResource(R.drawable.heartlike);
                Toast.makeText(mContext,"Product added to WishList",Toast.LENGTH_SHORT).show();


                mWishListData = new WishList(mProductList.get(position).getProductName()
                        ,mProductList.get(position).getProductDescription(),
                        mProductList.get(position).getProductImage(),
                        mProductList.get(position).getProductPrice());
                mWishList.add(mWishListData);



              // WishListAdapter adapter = new WishListAdapter(mContext,mWishList);
              // mRecyclerView.setAdapter(adapter);


            }
        });
        holder.mAddTocart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Toast.makeText(mContext,"Product added to cart",Toast.LENGTH_SHORT).show();

                mCartData = new ModelCart(mProductList.get(position).getProductName()
                        ,mProductList.get(position).getProductDescription(),
                        mProductList.get(position).getProductImage(),
                        mProductList.get(position).getProductPrice());
                mCartList.add(mCartData);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mProductList.size();
    }

}
