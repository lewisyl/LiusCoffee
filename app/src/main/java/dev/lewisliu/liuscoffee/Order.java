package dev.lewisliu.liuscoffee;

import android.os.Parcel;

import java.io.Serializable;

public class Order implements Serializable {
    private String _item;
    private double _price;
    private int _quantity;

    public Order(String _item, double _price, int _quantity) {
        this._item = _item;
        this._price = _price;
        this._quantity = _quantity;
    }

    public String get_item() {
        return _item;
    }

    public void set_item(String _item) {
        this._item = _item;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }
}
