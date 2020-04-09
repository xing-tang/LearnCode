package com.open.learncode.handler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import learncode.open.com.learncode.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jump1(View view) {
        startActivity(new Intent(this, HandlerActivity_1.class));
    }

    public void jump2(View view) {
        startActivity(new Intent(this, HandlerActivity_2.class));
    }

    public void jump3(View view) {
        startActivity(new Intent(this, HandlerActivity_3.class));
    }

    public void jump4(View view) {
        startActivity(new Intent(this, HandlerActivity_4.class));
    }
}
