package com.example.user.survay_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private TextView goToRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.email_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        Login = (Button) findViewById(R.id.login_Button);
        goToRegister = (TextView) findViewById(R.id.goToRegister_TextView);

        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
              Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(myIntent);
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });


    }


    private void validate(String userName, String userPassword) {
        if (userName.equals("123") && userPassword.equals("123")) {
            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
            MainActivity.this.startActivity(myIntent);
        }
    }
}

