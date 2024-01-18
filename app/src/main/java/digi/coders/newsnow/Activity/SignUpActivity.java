package digi.coders.newsnow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import digi.coders.newsnow.Helper.SharePrefManager;
import digi.coders.newsnow.Model.SharePrefModel;
import digi.coders.newsnow.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding signUpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(signUpBinding.getRoot());

        signUpBinding.radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(SignUpActivity.this, "Selected Gender : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

//        signUpBinding.signinWith.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
//            }
//        });

        SignUpData();

    }

    public void SignUpData() {
        signUpBinding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = signUpBinding.editName.getText().toString().trim();
                String email = signUpBinding.editEmail.getText().toString().trim();
                String phone_no = signUpBinding.editPhone.getText().toString().trim();
                String password = signUpBinding.editPassword.getText().toString().trim();

                if (name.length() == 0 || email.length() == 0 || phone_no.length() == 0 || password.length() == 0) {
                    Toast.makeText(SignUpActivity.this, "Enter field", Toast.LENGTH_SHORT).show();

                } else if (!isEmailValid(email)) {
                    Toast.makeText(SignUpActivity.this, "Invalid email format", Toast.LENGTH_SHORT).show();

                } else if (!isPasswordValid(password)) {
                    Toast.makeText(SignUpActivity.this, "Invalid password format", Toast.LENGTH_SHORT).show();

                } else {
                    SharePrefModel sharePrefModel = new SharePrefModel(name, email, password, phone_no, true);
                    SharePrefManager.sharePrefManager(SignUpActivity.this).InsertUsers(sharePrefModel);

                    Toast.makeText(SignUpActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                }
            }
        });
    }

    private boolean isEmailValid(String Email) {
        String string = "^(?=.*\\d)(?=.*[@gmail.com]).+$";
        String regexPattern = "^(?=.*\\d)(?=.*[@gmail.com]).+$";
        return Email.matches(string);

    }

    private boolean isPasswordValid(String Password) {
        String regexPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";
        return Password.matches(regexPattern);

    }
}