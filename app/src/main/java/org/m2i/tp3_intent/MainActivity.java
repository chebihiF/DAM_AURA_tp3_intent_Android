package org.m2i.tp3_intent;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn1, btnWeb, btnPhone, btnMap, btnMail, btnAgenda;
    EditText phone_txt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btn1 = findViewById(R.id.btn1);
        btnWeb = findViewById(R.id.btnWeb);
        btnPhone = findViewById(R.id.btnPhone);
        btnMap = findViewById(R.id.btnMap);
        btnMail = findViewById(R.id.btnMail);
        btnAgenda = findViewById(R.id.btnAgenda);
        phone_txt = findViewById(R.id.phoneNumber);

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webPage = Uri.parse("https://www.android.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webPage);
                startActivity(webIntent);
            }
        });

        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:"+phone_txt.getText().toString());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=paris");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mohammed@gmail.com","victor@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT,"email message text");
                //emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("content://path_to_email_attachment"));
                startActivity(emailIntent);

            }
        });

        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2021, 0, 23, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2021, 0, 23, 10, 30);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

                startActivity(calendarIntent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}