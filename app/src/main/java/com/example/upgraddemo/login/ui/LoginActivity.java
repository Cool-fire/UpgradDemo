package com.example.upgraddemo.login.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.upgraddemo.R;

public class LoginActivity extends AppCompatActivity {

    private Button loginBttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final String link = "https://stackexchange.com/oauth/dialog?client_id=14832&scope=no_expiry&redirect_uri=https://stackexchange.com/oauth/login_success";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupViews();
        loginBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openTabinBrowser(link);
                    finish();
            }

        });
    }

        private void openTabinBrowser(String link) {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(link));
        }
    private void setupViews() {
        loginBttn = findViewById(R.id.button);
    }
}
