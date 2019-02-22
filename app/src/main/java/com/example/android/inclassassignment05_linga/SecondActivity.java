package com.example.android.inclassassignment05_linga;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String title = intent.getStringExtra(MainActivity.title_text);
        String content = intent.getStringExtra(MainActivity.content_text);

        getSupportActionBar().setTitle(title);


        TextView textView2 = (TextView) findViewById(R.id.text_textView_content);
        textView2.setText(content);
    }
}
