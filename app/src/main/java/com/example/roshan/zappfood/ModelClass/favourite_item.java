package com.example.roshan.zappfood.ModelClass;

/**
 * Created by roshan on 2/21/17.
 */

public class favourite_item {
    private String Item_name;
    private  String Item_price;
    private  String quantity;

    public String getItem_name() {
        return Item_name;
    }

    public void setItem_name(String item_name) {
        Item_name = item_name;
    }

    public String getItem_price() {
        return Item_price;
    }

    public void setItem_price(String item_price) {
        Item_price = item_price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
