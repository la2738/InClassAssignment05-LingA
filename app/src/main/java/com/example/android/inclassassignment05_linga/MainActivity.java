package com.example.android.inclassassignment05_linga;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static String title_text = "title";
    public static String content_text = "content";
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mimageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mimageView = findViewById(R.id.picture);

        Button launchActivity = (Button) findViewById(R.id.launchActivity_button);
        launchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        EditText title = (EditText) findViewById(R.id.title_editText);
        String titleMessage = title.getText().toString();

        EditText content = (EditText) findViewById(R.id.message_editText);
        String contentMessage = content.getText().toString();

        CheckBox onlySendTitle = (CheckBox) findViewById(R.id.onlyTitle_checkBox);
        boolean ifOnlySendTitle = onlySendTitle.isChecked();

        Intent intent = new Intent(this,SecondActivity.class);
        if(ifOnlySendTitle){
            intent.putExtra(title_text,titleMessage);
        }else{
            intent.putExtra(title_text,titleMessage);
            intent.putExtra(content_text,contentMessage);
        }
        startActivity(intent);
    }


    public void sendEmail(View view){
        EditText title = (EditText) findViewById(R.id.title_editText);
        String titleMessage = title.getText().toString();

        EditText content = (EditText) findViewById(R.id.message_editText);
        String contentMessage = content.getText().toString();
        CheckBox onlySendTitle = (CheckBox) findViewById(R.id.onlyTitle_checkBox);
        boolean ifOnlySendTitle = onlySendTitle.isChecked();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        if(ifOnlySendTitle){
            intent.putExtra(Intent.EXTRA_SUBJECT,titleMessage);
        }else{
            intent.putExtra(Intent.EXTRA_SUBJECT,titleMessage);
            intent.putExtra(Intent.EXTRA_TEXT,contentMessage);
        }
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mimageView.setImageBitmap(imageBitmap);
        }
    }



}





