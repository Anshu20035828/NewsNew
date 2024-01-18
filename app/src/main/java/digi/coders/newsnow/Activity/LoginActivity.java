package digi.coders.newsnow.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import digi.coders.newsnow.Helper.SharePrefManager;
import digi.coders.newsnow.Model.SharePrefModel;
import digi.coders.newsnow.R;
import digi.coders.newsnow.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginBinding.getRoot());


        loginBinding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginBinding.email.getText().toString();
                String password = loginBinding.logPassword.getText().toString();

                if (email.length() == 0 || password.length() == 0) {
                    Toast.makeText(LoginActivity.this, "fill Data", Toast.LENGTH_SHORT).show();
                } else
                    if (isValidData(email, password)) {
                        Log.d("Ans","email : "+email);
                        Log.d("Ans","email : "+password);
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    } else {
                        // Handle the case where login is not successful
                        Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }


//    private void isValidData(String email, String password) {
//
//        SharePrefModel matchRecord = SharePrefManager.sharePrefManager(LoginActivity.this).getReadUserData();
//        if (email.matches("^[0-9]{10}$")) {
//            if (matchRecord.getPhoneNo().equalsIgnoreCase(email) && matchRecord.getPassword().equalsIgnoreCase(password)) {
//
//            }
//        } else {
//            if (matchRecord.getEmail().equalsIgnoreCase(email) && matchRecord.getPassword().equalsIgnoreCase(password)) {
//
//            }
//        }
//    }


    private boolean isValidData(String email, String password) {

        SharePrefModel matchRecord = SharePrefManager.sharePrefManager(LoginActivity.this).getReadUserData();

        if (email.equalsIgnoreCase(matchRecord.getEmail()) && password.equals(matchRecord.getPassword())) {
            SharePrefManager.sharePrefManager(LoginActivity.this).getReadUserData();
            return true;
        }

//        if (email.matches("^[0-9]{10}$")) {
//            return matchRecord.getPhoneNo().equalsIgnoreCase(email) && matchRecord.getPassword().equalsIgnoreCase(password);
//        } else {
//            return matchRecord.getEmail().equalsIgnoreCase(email) && matchRecord.getPassword().equalsIgnoreCase(password);
//        }
        return false;
    }


}
