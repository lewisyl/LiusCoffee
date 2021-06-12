package dev.lewisliu.liuscoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button mochaBtn;
    Button latteBtn;
    Button americanoBtn;
    Button viewOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mochaBtn = (Button) findViewById(R.id.mainMochaBtn);
        latteBtn = (Button) findViewById(R.id.mainLatteBtn);
        americanoBtn = (Button) findViewById(R.id.mainAmericanoBtn);
        viewOrderBtn = (Button) findViewById(R.id.mainViewOrderBtn);
    }
}