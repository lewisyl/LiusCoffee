package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mochaBtn;
    Button latteBtn;
    Button americanoBtn;
    Button viewOrderBtn;
    ArrayList<Order> myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mochaBtn = (Button) findViewById(R.id.mainMochaBtn);
        latteBtn = (Button) findViewById(R.id.mainLatteBtn);
        americanoBtn = (Button) findViewById(R.id.mainAmericanoBtn);
        viewOrderBtn = (Button) findViewById(R.id.mainViewOrderBtn);



        if (getIntent().getSerializableExtra("MyOrder") == null) {
            myOrder = new ArrayList<Order>();
        } else {
            myOrder = (ArrayList<Order>) getIntent().getSerializableExtra("MyOrder");
        }

        mochaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMocha();
            }
        });

        americanoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goAmericano();
            }
        });

        latteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLatte();
            }
        });

        viewOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goOrders();
            }
        });
    }

    private void goAmericano() {
        Intent intent = new Intent(this, AmericanoActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }

    private void goMocha() {
        Intent intent = new Intent(this, MochaActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }

    private void goLatte() {
        Intent intent = new Intent(this, LatteActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }

    private void goOrders() {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }
}