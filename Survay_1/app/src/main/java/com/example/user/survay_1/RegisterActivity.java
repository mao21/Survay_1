package com.example.user.survay_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;


public class RegisterActivity extends AppCompatActivity {
    private EditText Name ;
    private EditText Email ;
    private EditText Password ;
    private Button Register ;
    private TextView goToLogin ;
    private FirebaseAuth mAuth;


    private void RegisterUser(){
        String nameString = Name.getText().toString().trim();
        String emailString = Email.getText().toString().trim();
        String passwordString = Password.getText().toString().trim();
        if(nameString.isEmpty()){
            Name.setError("Please enter your full name to sign up");
            Name.requestFocus();
            return;
        }
        if(emailString.isEmpty()){
                Email.setError("Please enter an email to sign up");
                Email.requestFocus();
                return;
            }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
                Email.setError("Please enter a valid email to sign up");
                Email.requestFocus();
                return;
        }
        if(passwordString.isEmpty()){
                    Password.setError("Please enter a password to sign up");
                    Password.requestFocus();
                    return;
        }

        mAuth.createUserWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Sign up successful",Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(RegisterActivity.this, SecondActivity.class);
                    RegisterActivity.this.startActivity(myIntent);
                }
        }
    });
    }



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = (EditText) findViewById(R.id.name_editText);
        Email = (EditText) findViewById(R.id.email_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        Register = (Button) findViewById(R.id.register_Button);
        goToLogin = (TextView) findViewById(R.id.goToLogin_TextView);
        mAuth = FirebaseAuth.getInstance();
        //Go To Login text will send you to the login activity when clicked on
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(myIntent);
            }
        });


            Register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RegisterUser();

                }
            });


        }

    }


