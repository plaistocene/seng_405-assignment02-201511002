package com.plaistocene.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button loginButton;
    Button forgotPassword;
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        forgotPassword = findViewById(R.id.forgotPassword);
        createAccount = findViewById(R.id.createAccount);

        loginButton.setOnClickListener(view -> dataVerification());

        forgotPassword.setOnClickListener(view -> notImplemented());

        createAccount.setOnClickListener(view -> notImplemented());
    }

    private void notImplemented() {
        Toast t = Toast.makeText(getApplicationContext(),
                "This Function is Not Implemented Yet",
                Toast.LENGTH_SHORT);
        t.show();
    }

    private void dataVerification() {
        boolean loginVerification = true;
        if (isEmail(email)) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Email have to be valid",
                    Toast.LENGTH_SHORT);
            t.show();
            email.setError("Email is not valid");
            loginVerification = false;
        }

        if (isEmpty(password)) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "Password field must not be empty",
                    Toast.LENGTH_SHORT);
            t.show();
            password.setError("Password is required");
            loginVerification = false;
        }

        if (loginVerification) {
            Toast t = Toast.makeText(getApplicationContext(),
                    "!! Login SUCCESSFUL !!",
                    Toast.LENGTH_SHORT);
            t.show();
        }
    }

    private boolean isEmail(@NonNull EditText text) {
        CharSequence charSequence = text.getText().toString();
        return !Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }

    private boolean isEmpty(@NonNull EditText text) {
        CharSequence charSequence = text.getText().toString();
        return TextUtils.isEmpty(charSequence);
    }
}