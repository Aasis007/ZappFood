package com.example.roshan.zappfood.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.zappfood.Login.Background;
import com.example.roshan.zappfood.MainActivity;
import com.example.roshan.zappfood.R;

public class Login_Screen extends AppCompatActivity {
TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__screen);
        textView = (TextView)findViewById(R.id.txt_scan);
        final String ttl = getIntent().getExtras().getString("table_id");
        textView.setText(ttl);
        sharedPreferences = getSharedPreferences("table_no", Context.MODE_PRIVATE);
        Button btn_login=(Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation1 = new AlphaAnimation(0.3f, 1.0f);
                animation1.setDuration(2000);
                view.startAnimation(animation1);
                String txt_vie=textView.getText().toString().trim();
               SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("table_id", textView.getText().toString());
                editor.apply();
                new Background(Login_Screen.this).execute("login",txt_vie);
            }
        });
    }
}

