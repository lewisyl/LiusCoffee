package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {
    ArrayList<Parcelable> myOrder;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textView2 = (TextView) findViewById(R.id.textView2);



        myOrder = (ArrayList<Parcelable>) getIntent().getParcelableArrayListExtra("MyOrder");
    }

    private void backHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent.putExtra("MyOrder", myOrder));
    }
}