package com.example.user.survay_1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private TextView goToRegister;
    private FirebaseAuth mAuth;

    private void SignInUser(){
        String emailString = Email.getText().toString().trim();
        String passwordString = Password.getText().toString().trim();
        if(emailString.isEmpty()){
            Email.setError("Please enter an email to sign up");
            Email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailString).matches()){
            Email.setError("Please enter a valid email to sign in");
            Email.requestFocus();
            return;
        }
        if(passwordString.isEmpty()){
            Password.setError("Please enter a password to sign in");
            Password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailString, passwordString)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),"Sign In successful",Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                            MainActivity.this.startActivity(myIntent);
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
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
           SignInUser();

            }
        });


    }



}

