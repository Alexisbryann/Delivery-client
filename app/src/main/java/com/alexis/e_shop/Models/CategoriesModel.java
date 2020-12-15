package com.alexis.e_shop.Models;

public class CategoriesModel {

    public String ProductName;
    public int Image;

    public CategoriesModel(String productName, int image) {
        ProductName = productName;
        Image = image;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) { Image = image;
    }
}

