package com.sandywinata.isg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Conversation extends AppCompatActivity {

    CardView cvGreetings, cvAddressingPeople, cvNumber, cvEatingOut, cvTimeExpression, cvPlace, cvCountryName, cvEverydayLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        cvGreetings = (CardView) findViewById(R.id.cvGreetings);
        cvAddressingPeople = (CardView) findViewById(R.id.cvAddressingPeople);
        cvNumber = (CardView) findViewById(R.id.cvNumber);
        cvEatingOut = (CardView) findViewById(R.id.cvEatingOut);
        cvTimeExpression = (CardView) findViewById(R.id.cvTimeExpression);
        cvPlace = (CardView) findViewById(R.id.cvPlace);
        cvCountryName = (CardView) findViewById(R.id.cvCountryName);
        cvEverydayLanguage = (CardView) findViewById(R.id.cvPlace);

        cvGreetings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvAddressingPeople.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvNumber.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvEatingOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvTimeExpression.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvPlace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvCountryName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });

        cvEverydayLanguage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Greetings.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnChat:
                Toast.makeText(this, "Menu Chat", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
