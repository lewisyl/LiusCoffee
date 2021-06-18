package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LatteActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    ArrayList<Order> myOrder;

    Button latteBackBtn;

    Button latteHotBtn;
    TextView latteHotTitle;
    TextView latteHotPrice;

    Button latteIcedBtn;
    TextView latteIcedTitle;
    TextView latteIcedPrice;

    Button latteCaramelBtn;
    TextView latteCaramelTitle;
    TextView latteCaramelPrice;

    Button latteCharcoalBtn;
    TextView latteCharcoalTitle;
    TextView latteCharcoalPrice;

    Button latteMatchaBtn;
    TextView latteMatchaTitle;
    TextView latteMatchaPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latte);

        latteBackBtn = (Button) findViewById(R.id.latteBackBtn);

        latteHotBtn = (Button) findViewById(R.id.latteHotBtn);
        latteHotTitle = (TextView) findViewById(R.id.latteHotTitle);
        latteHotPrice = (TextView) findViewById(R.id.latteHotPrice);

        latteIcedBtn = (Button) findViewById(R.id.latteIcedBtn);
        latteIcedTitle = (TextView) findViewById(R.id.latteIcedTitle);
        latteIcedPrice = (TextView) findViewById(R.id.latteIcedPrice);

        latteCaramelBtn = (Button) findViewById(R.id.latteCaramelBtn);
        latteCaramelTitle = (TextView) findViewById(R.id.latteCaramelTitle);
        latteCaramelPrice = (TextView) findViewById(R.id.latteCaramelPrice);

        latteCharcoalBtn = (Button) findViewById(R.id.latteCharcoalBtn);
        latteCharcoalTitle = (TextView) findViewById(R.id.latteCharcoalTitle);
        latteCharcoalPrice = (TextView) findViewById(R.id.latteCharcoalPrice);

        latteMatchaBtn = (Button) findViewById(R.id.latteMatchaBtn);
        latteMatchaTitle = (TextView) findViewById(R.id.latteMatchaTitle);
        latteMatchaPrice = (TextView) findViewById(R.id.latteMatchaPrice);

        myOrder = (ArrayList<Order>) getIntent().getSerializableExtra("MyOrder");

        latteBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });

        latteHotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = latteHotTitle.getText().toString();
                double price = Double.parseDouble(latteHotPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        latteIcedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = latteIcedTitle.getText().toString();
                double price = Double.parseDouble(latteIcedPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        latteCaramelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = latteCaramelTitle.getText().toString();
                double price = Double.parseDouble(latteCaramelPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        latteCharcoalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = latteCharcoalTitle.getText().toString();
                double price = Double.parseDouble(latteCharcoalPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        latteMatchaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = latteMatchaTitle.getText().toString();
                double price = Double.parseDouble(latteMatchaPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });
    }

    private void backHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is",""+newVal);

    }

    public void show(String item, double price)
    {
        final Dialog quantityDialog = new Dialog(this);
        quantityDialog.setTitle("NumberPicker");
        quantityDialog.setContentView(R.layout.dialog);
        Button dialogOrderBtn = (Button) quantityDialog.findViewById(R.id.dialogOrderBtn);
        Button dialogCancelBtn = (Button) quantityDialog.findViewById(R.id.dialogCancelBtn);
        final NumberPicker quantity = (NumberPicker) quantityDialog.findViewById(R.id.numberPicker1);
        quantity.setMaxValue(20);
        quantity.setMinValue(1);
        quantity.setWrapSelectorWheel(false);
        quantity.setOnValueChangedListener(this);
        dialogOrderBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int selectedQuantity = quantity.getValue();
                Order newOrder = new Order(item, price, selectedQuantity);
                myOrder.add(newOrder);
                quantityDialog.dismiss();
                Toast.makeText(LatteActivity.this, "Thank You for Your Order!", Toast.LENGTH_SHORT).show();
            }
        });
        dialogCancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                quantityDialog.dismiss();
            }
        });
        quantityDialog.show();
    }
}