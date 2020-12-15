package com.alexis.delivery.Models;

public class BlackFridayModel  {
    public int image;
    public String product_description;
    public String price;
    public int rating_bar;
    public String express;

    public BlackFridayModel(int image, String product_description, String price, int rating_bar, String express) {
        this.image = image;
        this.product_description = product_description;
        this.price = price;
        this.rating_bar = rating_bar;
        this.express = express;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRating_bar() {
        return rating_bar;
    }

    public void setRating_bar(int rating_bar) {
        this.rating_bar = rating_bar;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }
}
