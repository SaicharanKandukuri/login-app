package com.ztest.local.task01;

import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class helpers {

    public static Boolean isVaildUserName(EditText data) {
        String text = data.getText().toString().trim();

        if (text.isEmpty()) {
            data.setError("Username cannot be empty");
            return false;
        }

        return true;
    }

    public static Boolean isVaildPassword(EditText data) {
        // 8 characters
        String password = data.getText().toString().trim();

        if (password.isEmpty()) {
            data.setError("password field cannot be empty");
            return false;
        }

        if (password.length() <= 8) {
            data.setError("password length less than 8");
            return false;
        }

        return true;
    }

    public static Boolean isConfirmVaild(EditText firstPass, EditText SecondPass) {
        String password1 = firstPass.getText().toString().trim();
        String password2 = SecondPass.getText().toString().trim();

        // if not equal
        if (!password1.equals(password2)) {
            firstPass.setError("Password do not Match");
            SecondPass.setError("Password do not Match");
            return false;
        }

        return true;
    }

    public static Boolean validEmail(EditText data) {
        String Email = data.getText().toString().trim();

        if (Email.isEmpty()) {
            data.setError("Email filed cannot be empty");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            data.setError("Enter a valid Email address!");
            return false;
        }
        return true;
    }

    public static Boolean validAgreement(CheckBox box) {
        return box.isChecked();
    }
    public static Boolean validRadio(RadioGroup rg) {
        return rg.getCheckedRadioButtonId() != -1;
    }

}
