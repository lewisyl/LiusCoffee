package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    ArrayList<Order> myOrder;
    TextView myOrderSubtotal;
    TextView myOrderTax;
    TextView myOrderTotal;
    Button myOrderBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        myOrder = (ArrayList<Order>) getIntent().getSerializableExtra("MyOrder");
        myOrderSubtotal = (TextView) findViewById(R.id.myOrderSubtotal);
        myOrderTax = (TextView) findViewById(R.id.myOrderTax);
        myOrderTotal = (TextView) findViewById(R.id.myOrderTotal);
        myOrderBackBtn = (Button) findViewById(R.id.myOrderBackBtn);

        double subtotal = 0;
        double tax = 0.11;
        double total = subtotal * (1 + tax);
        ArrayList<String> orderedItems = new ArrayList<String>();
        ArrayList<String> orderedPrices = new ArrayList<String>();
        ArrayList<String> orderedQuantities = new ArrayList<String>();

        for (int i = 0; i < myOrder.size(); i++) {
            subtotal += (myOrder.get(i).get_price())*(myOrder.get(i).get_quantity());
            orderedItems.add(myOrder.get(i).get_item());
            orderedPrices.add("$ " + String.format("%.2f", myOrder.get(i).get_price()));
            orderedQuantities.add("x " + myOrder.get(i).get_quantity());
        }

        ArrayAdapter itemAdapter = new ArrayAdapter<String> (this, R.layout.ordered_items, R.id.orderedItems, orderedItems);
        ArrayAdapter priceAdapter = new ArrayAdapter<String> (this, R.layout.ordered_prices, R.id.orderedPrices, orderedPrices);
        ArrayAdapter quantityAdapter = new ArrayAdapter<String> (this, R.layout.ordered_quantities, R.id.orderedQuantities, orderedQuantities);
        ListView itemListView = (ListView) findViewById(R.id.myOrderItemList);
        ListView priceListView = (ListView) findViewById(R.id.myOrderPriceList);
        ListView quantityListView = (ListView) findViewById(R.id.myOrderQuantityList);
        itemListView.setAdapter(itemAdapter);
        priceListView.setAdapter(priceAdapter);
        quantityListView.setAdapter(quantityAdapter);

        myOrderSubtotal.setText("$" + String.format("%.2f", subtotal));
        myOrderTax.setText("$" + String.format("%.2f", (subtotal * tax)) + " (" + (tax * 100) + "%)");
        myOrderTotal.setText("$" + String.format("%.2f", (subtotal + (1 + tax))));

        myOrderBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });
    }

    private void backHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }
}