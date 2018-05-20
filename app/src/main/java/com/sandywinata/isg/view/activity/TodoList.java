package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sandywinata.isg.R;

public class TodoList extends AppCompatActivity {

    CardView cvRegistration, cvVisa, cvTranscript, cvAcademicCal, cvAccomodation, cvAskforLeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        cvRegistration = (CardView) findViewById(R.id.cvRegistration);
        cvVisa = (CardView) findViewById(R.id.cvVisa);
        cvTranscript = (CardView) findViewById(R.id.cvTranscript);
        cvAcademicCal = (CardView) findViewById(R.id.cvAcademicCal);
        cvAccomodation = (CardView) findViewById(R.id.cvAccomodation);
        cvAskforLeave = (CardView) findViewById(R.id.cvAskforleave);

        cvRegistration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Registration.class);
                startActivity(intent);
            }
        });

        cvVisa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Visa.class);
                startActivity(intent);
            }
        });

        cvTranscript.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Transcript.class);
                startActivity(intent);
            }
        });

        cvAcademicCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Academic.class);
                startActivity(intent);
            }
        });

        cvAccomodation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Accomodation.class);
                startActivity(intent);
            }
        });

        cvAskforLeave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Askforleave.class);
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
