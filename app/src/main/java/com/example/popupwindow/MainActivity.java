package com.example.popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = (TextView) findViewById(R.id.textShowPopwindow);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ExtendPopupWindow.Builder(MainActivity.this).create().showAtLocation(mText,Gravity.BOTTOM,0,0);
            }
        });
    }



}
