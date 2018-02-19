package com.example.mango.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linkLayout = (LinearLayout) findViewById(R.id.link_layout);
        linkLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://" + getString(R.string.website))));
            }
        });

        LinearLayout phoneLayout = (LinearLayout) findViewById(R.id.phone_layout);
        phoneLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + getString(R.string.phone))));
            }
        });

        LinearLayout mapLayout = (LinearLayout) findViewById(R.id.map_layout);
        mapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("https://www.google.co.in/maps/place/2465+Latham+St,+Mountain+View,+CA+94040,+USA/@37.3999133,-122.1105521,17z/data=!3m1!4b1!4m5!3m4!1s0x808fb098443680fd:0xc806a7a80752e40c!8m2!3d37.3999133!4d-122.1083634");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });


    }
}
