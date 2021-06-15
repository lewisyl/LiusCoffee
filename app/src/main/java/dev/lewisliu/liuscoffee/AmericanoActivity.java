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

import java.util.ArrayList;

public class AmericanoActivity extends AppCompatActivity implements NumberPicker.OnValueChangeListener {
    ArrayList<Parcelable> myOrder;
    Button americanoBackBtn;
    Button americanoHotBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_americano);

        americanoBackBtn = (Button) findViewById(R.id.americanoBackBtn);
        americanoHotBtn = (Button) findViewById(R.id.americanoHotBtn);

        myOrder = (ArrayList<Parcelable>) getIntent().getParcelableArrayListExtra("MyOrder");

        americanoBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backHome();
            }
        });

        americanoHotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
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

    public void show()
    {

        final Dialog d = new Dialog(this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button dialogOrderBtn = (Button) d.findViewById(R.id.dialogOrderBtn);
        Button dialogCancelBtn = (Button) d.findViewById(R.id.dialogCancelBtn);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(20);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        dialogOrderBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                // tv.setText(String.valueOf(np.getValue()));
                d.dismiss();
            }
        });
        dialogCancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }
}