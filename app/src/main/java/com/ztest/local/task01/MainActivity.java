package com.ztest.local.task01;

import static java.lang.Thread.sleep;

import com.ztest.local.task01.helpers;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText[] test = new EditText[4];
    EditText normal;
    Button b1;
    RadioGroup r1;
    CheckBox agreement;

    public static final String emailHelpeer = "email";
    public static final String passHelpeer  = "pass";
    public static final String nameHelpeer  = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test[0] = findViewById(R.id.EmailPrompt);
        test[1] = findViewById(R.id.editTextTextPassword);
        test[2] = findViewById(R.id.editTextTextPassword2);
        test[3] = findViewById(R.id.UsernamePrompt);
        r1      = findViewById(R.id.radio_group1);
        b1      = findViewById(R.id.SubmitButton);
        agreement = findViewById(R.id.checkBox);

        Intent result = new Intent(MainActivity.this, result.class);
        Bundle bridge = new Bundle();

        b1.setOnClickListener(
                view -> {
                    if (
                            helpers.isVaildUserName(test[3])
                            && helpers.isVaildPassword(test[1])
                            && helpers.isVaildPassword(test[2])
                            && helpers.isConfirmVaild(test[1], test[2])
                            && helpers.validEmail(test[0])
                            && helpers.validRadio(r1)
                    ) {
                        if (!helpers.validAgreement(agreement)) {
                            Toast.makeText(
                                    MainActivity.this,
                                    "Accept License agreement",
                                    Toast.LENGTH_LONG
                            ).show();
                        } else {
                            Toast.makeText(
                                    MainActivity.this,
                                    "Success",
                                    Toast.LENGTH_LONG
                            ).show();

                            // should trigger a function
                            result.putExtra(emailHelpeer, test[0].getText().toString());
                            result.putExtra(passHelpeer, test[1].getText().toString());
                            result.putExtra(nameHelpeer, test[3].getText().toString());

                            startActivity(result);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Incomplete Options?", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}