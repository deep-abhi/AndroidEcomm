package com.softcrylic.training.Cart;

public class ModelCart {
    private String productName;
    private String productDescription;
    private int productImage;
    private String productPrice;


    public ModelCart (String productName,String productDescription,int productImage,String productPrice){
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
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
