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

public class MochaActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener{
    ArrayList<Order> myOrder;

    Button mochaBackBtn;

    Button mochaCaramelBtn;
    TextView mochaCaramelTitle;
    TextView mochaCaramelPrice;

    Button mochaCinnamonBtn;
    TextView mochaCinnamonTitle;
    TextView mochaCinnamonPrice;

    Button mochaWhiteBtn;
    TextView mochaWhiteTitle;
    TextView mochaWhitePrice;

    Button mochaChocolateBtn;
    TextView mochaChocolateTitle;
    TextView mochaChocolatePrice;

    Button mochaIcedBtn;
    TextView mochaIcedTitle;
    TextView mochaIcedPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocha);

        mochaBackBtn = (Button) findViewById(R.id.mochaBackBtn);

        mochaCaramelBtn = (Button) findViewById(R.id.mochaCaramelBtn);
        mochaCaramelTitle = (TextView) findViewById(R.id.mochaCaramelTitle);
        mochaCaramelPrice = (TextView) findViewById(R.id.mochaCaramelPrice);

        mochaCinnamonBtn = (Button) findViewById(R.id.mochaCinnamonBtn);
        mochaCinnamonTitle = (TextView) findViewById(R.id.mochaCinnamonTitle);
        mochaCinnamonPrice = (TextView) findViewById(R.id.mochaCinnamonPrice);

        mochaWhiteBtn = (Button) findViewById(R.id.mochaWhiteBtn);
        mochaWhiteTitle = (TextView) findViewById(R.id.mochaWhiteTitle);
        mochaWhitePrice = (TextView) findViewById(R.id.mochaWhitePrice);

        mochaChocolateBtn = (Button) findViewById(R.id.mochaChocolateBtn);
        mochaChocolateTitle = (TextView) findViewById(R.id.mochaChocolateTitle);
        mochaChocolatePrice = (TextView) findViewById(R.id.mochaChocolatePrice);

        mochaIcedBtn = (Button) findViewById(R.id.mochaIcedBtn);
        mochaIcedTitle = (TextView) findViewById(R.id.mochaIcedTitle);
        mochaIcedPrice = (TextView) findViewById(R.id.mochaIcedPrice);

        myOrder = (ArrayList<Order>) getIntent().getSerializableExtra("MyOrder");

        mochaBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });

        mochaIcedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mochaIcedTitle.getText().toString();
                double price = Double.parseDouble(mochaIcedPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        mochaChocolateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mochaChocolateTitle.getText().toString();
                double price = Double.parseDouble(mochaChocolatePrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        mochaWhiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mochaWhiteTitle.getText().toString();
                double price = Double.parseDouble(mochaWhitePrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        mochaCinnamonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mochaCinnamonTitle.getText().toString();
                double price = Double.parseDouble(mochaCinnamonPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        mochaCaramelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mochaCaramelTitle.getText().toString();
                double price = Double.parseDouble(mochaCaramelPrice.getText().toString().replace("$", ""));
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
                Toast.makeText(MochaActivity.this, "Thank You for Your Order!", Toast.LENGTH_SHORT).show();
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