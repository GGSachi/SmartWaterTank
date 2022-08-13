package com.example.smartwatertank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPassword;
    TextView textViewForgetPassword, textViewRegister;
    ProgressBar progressBar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserName = (EditText) findViewById(R.id.editTextSignInUserName);
        editTextPassword =(EditText) findViewById(R.id.editTextTextPassword);

        textViewForgetPassword = (TextView) findViewById(R.id.txtSignInForgotPassword);
        textViewRegister = (TextView) findViewById(R.id.txtSignInRegister);
        progressBar = (ProgressBar) findViewById(R.id.progressBarSignIn);

        mAuth = FirebaseAuth.getInstance();

    }
    public void txtSignInForgotPasswordClicked(View v){

    }
    public void txtSignInRegisterClicked(View v){

    }
    public void buttonSignInScrSignInClicked(View v){

        String userName = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(userName).matches()){
            editTextUserName.setError("Please Enter a Valid Email");
            editTextUserName.requestFocus();
        }

        if (editTextPassword.length()<6){
            editTextPassword.setError("Please Enter a Password containing atleast six characters");
            editTextPassword.requestFocus();
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(userName,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignInActivity.this, "User has Successfully Signed In", Toast.LENGTH_LONG).show();

                }
                else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(SignInActivity.this, "User is failed to Signed In", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}