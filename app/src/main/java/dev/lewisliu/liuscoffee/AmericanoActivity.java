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

public class AmericanoActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    ArrayList<Order> myOrder;

    Button americanoBackBtn;

    Button americanoIcedBtn;
    TextView americanoIcedTitle;
    TextView americanoIcedPrice;

    Button americanoHotBtn;
    TextView americanoHotTitle;
    TextView americanoHotPrice;

    Button americanoEspressoBtn;
    TextView americanoEspressoTitle;
    TextView americanoEspressoPrice;

    Button americanoCocktailBtn;
    TextView americanoCocktailTitle;
    TextView americanoCocktailPrice;

    Button americanoFakeBtn;
    TextView americanoFakeTitle;
    TextView americanoFakePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        americanoBackBtn = (Button) findViewById(R.id.americanoBackBtn);

        americanoHotBtn = (Button) findViewById(R.id.americanoHotBtn);
        americanoHotTitle = (TextView) findViewById(R.id.americanoHotTitle);
        americanoHotPrice = (TextView) findViewById(R.id.americanoHotPrice);

        americanoIcedBtn = (Button) findViewById(R.id.americanoIcedBtn);
        americanoIcedTitle = (TextView) findViewById(R.id.americanoIcedTitle);
        americanoIcedPrice = (TextView) findViewById(R.id.americanoIcedPrice);

        americanoEspressoBtn = (Button) findViewById(R.id.americanoEspressoBtn);
        americanoEspressoTitle = (TextView) findViewById(R.id.americanoEspressoTitle);
        americanoEspressoPrice = (TextView) findViewById(R.id.americanoEspressoPrice);

        americanoCocktailBtn = (Button) findViewById(R.id.americanoCocktailBtn);
        americanoCocktailTitle = (TextView) findViewById(R.id.americanoCocktailTitle);
        americanoCocktailPrice = (TextView) findViewById(R.id.americanoCocktailPrice);

        americanoFakeBtn = (Button) findViewById(R.id.americanoFakeBtn);
        americanoFakeTitle = (TextView) findViewById(R.id.americanoFakeTitle);
        americanoFakePrice = (TextView) findViewById(R.id.americanoFakePrice);

        myOrder = (ArrayList<Order>) getIntent().getSerializableExtra("MyOrder");

        americanoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });

        americanoHotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = americanoHotTitle.getText().toString();
                double price = Double.parseDouble(americanoHotPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        americanoIcedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = americanoIcedTitle.getText().toString();
                double price = Double.parseDouble(americanoIcedPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        americanoEspressoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = americanoEspressoTitle.getText().toString();
                double price = Double.parseDouble(americanoEspressoPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        americanoCocktailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = americanoCocktailTitle.getText().toString();
                double price = Double.parseDouble(americanoCocktailPrice.getText().toString().replace("$", ""));
                show(item, price);
            }
        });

        americanoFakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = americanoFakeTitle.getText().toString();
                double price = Double.parseDouble(americanoFakePrice.getText().toString().replace("$", ""));
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
                Toast.makeText(AmericanoActivity.this, "Thank You for Your Order!", Toast.LENGTH_SHORT).show();
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