package com.example.roshan.zappfood.ModelClass;

/**
 * Created by roshan on 2/2/17.
 */

public class Menu_item {
    private String Id;
    private String Menu_Type;
    private String Item_Name;
    private String Item_Price;
    private String Image;
    private String Description;
    private String quantity;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMenu_Type() {
        return Menu_Type;
    }

    public void setMenu_Type(String menu_Type) {
        Menu_Type = menu_Type;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }

    public String getItem_Price() {
        return Item_Price;
    }

    public void setItem_Price(String item_Price) {
        Item_Price = item_Price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
