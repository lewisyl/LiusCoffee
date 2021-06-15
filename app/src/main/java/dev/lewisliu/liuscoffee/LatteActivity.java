package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LatteActivity extends AppCompatActivity {
    ArrayList<Parcelable> myOrder;
    Button latteBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latte);

        latteBackBtn = (Button) findViewById(R.id.latteBackBtn);

        myOrder = (ArrayList<Parcelable>) getIntent().getParcelableArrayListExtra("MyOrder");

        latteBackBtn.setOnClickListener(new View.OnClickListener() {
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