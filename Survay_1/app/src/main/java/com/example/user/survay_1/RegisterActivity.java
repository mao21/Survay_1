package com.example.user.survay_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Email;
    private EditText Password;
    private Button Register;
    private TextView goToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText) findViewById(R.id.name_editText);
        Email = (EditText) findViewById(R.id.email_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        Register = (Button) findViewById(R.id.register_Button);
        goToLogin = (TextView) findViewById(R.id.goToLogin_TextView);

        //Go To Login text will send you to the login activity when clicked on
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(myIntent);
            }
        });
        {

            Register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(RegisterActivity.this, SecondActivity.class);
                    RegisterActivity.this.startActivity(myIntent);
                }
            });


        }
    }
}
