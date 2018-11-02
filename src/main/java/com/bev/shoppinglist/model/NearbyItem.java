package com.bev.shoppinglist.model;

import java.util.Objects;
import java.util.UUID;

public class NearbyItem {

    private String key;
    private String text;
    private String ownerName;
    private Integer itemQuantity = 1;

    public NearbyItem(String text) {
        super();
        this.key = UUID.randomUUID().toString();
        this.text = text;
        this.itemQuantity = 1;
        this.ownerName = "Paul";
    }

    public NearbyItem(String key, String text, Integer itemQuantity, String ownerName) {
        super();
        this.key = key;
        this.text = text;
        this.itemQuantity = itemQuantity;
        this.ownerName = ownerName;
    }

    public NearbyItem() {
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
        NearbyItem that = (NearbyItem) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
