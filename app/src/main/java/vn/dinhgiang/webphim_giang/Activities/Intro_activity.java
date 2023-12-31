package vn.dinhgiang.webphim_giang.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.dinhgiang.webphim_giang.R;

public class Intro_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button btnToLogin = findViewById(R.id.button);
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến Login activity
                Intent intent = new Intent(Intro_activity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}