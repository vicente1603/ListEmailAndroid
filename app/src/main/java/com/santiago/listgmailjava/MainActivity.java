package com.santiago.listgmailjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.mooveit.library.Fakeit;
import com.santiago.listgmailjava.model.Email;
import com.santiago.listgmailjava.model.Emails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EmailAdapter emailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fakeit.init();
        setContentView(R.layout.activity_main);

        emailAdapter = new EmailAdapter(new ArrayList<>(Emails.fakeEmails()));

        RecyclerView rv = findViewById(R.id.recycleview_main);
        rv.setAdapter(emailAdapter);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmail();
                rv.scrollToPosition(0);
            }
        });

    }


    private void addEmail() {

        try {

            Date sdf = new SimpleDateFormat("dd/MM/yy", new Locale("pt", "BR")).parse(
                    Fakeit.dateTime().dateFormatter()
            );

            StringBuilder preview = new StringBuilder();
            for (int i = 0; i < 10; i++) {

                preview.append(Fakeit.gameOfThrones().character() + " " + Fakeit.lordOfTheRings().location());
                preview.append(" ");

            }


            emailAdapter.getEmails().add(0, Email.EmailBuilder.builder()
                    .setStared(false)
                    .setUnread(true)
                    .setUser(Fakeit.gameOfThrones().character())
                    .setSubject(Fakeit.lordOfTheRings().location())
                    .setDate(new SimpleDateFormat("d MMM", new Locale("pt", "BR")).format(sdf))
                    .setPreview(preview.toString())
                    .build());

        } catch (Exception e) {

        }

        emailAdapter.getEmails();

        emailAdapter.notifyItemInserted(0);


    }

}