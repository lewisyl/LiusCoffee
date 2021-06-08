package dev.lewisliu.liuscoffee;

public class Order {
    private String _item;
    private double _price, _subtotal, _tax, _total;
    private int _quantity;
    private double _taxRate = 0.11;

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

    public double get_subtotal() {
        return _subtotal;
    }

    public void set_subtotal(double _subtotal) {
        this._subtotal = _subtotal;
    }

    public double get_tax() {
        return _tax;
    }

    public void set_tax(double _tax) {
        this._tax = _tax;
    }

    public double get_total() {
        return _total;
    }

    public void set_total(double _total) {
        this._total = _total;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public double get_taxRate() {
        return _taxRate;
    }

    public void set_taxRate(double _taxRate) {
        this._taxRate = _taxRate;
    }
}
