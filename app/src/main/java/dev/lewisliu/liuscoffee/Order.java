package dev.lewisliu.liuscoffee;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    private String _item;
    private double _price;
    private int _quantity;

    public Order(String _item, double _price, int _quantity) {
        this._item = _item;
        this._price = _price;
        this._quantity = _quantity;
    }

    protected Order(Parcel in) {
        _item = in.readString();
        _price = in.readDouble();
        _quantity = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_item);
        dest.writeDouble(_price);
        dest.writeInt(_quantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

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
