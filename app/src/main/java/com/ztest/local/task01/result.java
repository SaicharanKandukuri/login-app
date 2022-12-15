package com.ztest.local.task01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    TextView[] tv = new TextView[3];
    Button back;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv[0] = findViewById(R.id.Email);
        tv[1] = findViewById(R.id.Passwordl);
        tv[2] = findViewById(R.id.username);
        back = findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();

        String Email = bundle.getString("email");
        String pass = String.valueOf(bundle.getString("pass").length());
        String userName = bundle.getString("name");

        tv[0].setText(Email);
        tv[1].setText(getString(R.string.pmsg)+" "+pass);
        tv[2].setText(userName);

        back.setOnClickListener(
                view -> {
                    finish();
                }
        );
    }
}