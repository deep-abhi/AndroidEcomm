package com.softcrylic.training.Category;

import android.content.Intent;

public class ProductData {
    private String productName;
    private String productDescription;
    private int productImage;
    private String productPrice;

    public ProductData (String productName,String productDescription,int productImage){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }
    public ProductData (String productName,String productDescription,int productImage,String productPrice){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = "Rs."+productPrice;
    }

    public String getProductName(){
        return productName;
    }
    public String getProductDescription(){
        return productDescription;
    }
    public int getProductImage(){
        return productImage;
    }
    public String getProductPrice(){return productPrice;}
}
