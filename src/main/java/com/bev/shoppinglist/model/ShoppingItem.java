package com.bev.shoppinglist.model;

import java.util.Objects;

public class ShoppingItem {

    private String key;
    private String text;
    private Integer itemQuantity = 1;

    public ShoppingItem(String text) {
        super();
        this.text = text;
    }

    public ShoppingItem(String key, String text, Integer itemQuantity) {
        this.key = key;
        this.text = text;
        this.itemQuantity = itemQuantity;
    }

    public ShoppingItem() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShoppingItem that = (ShoppingItem) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
