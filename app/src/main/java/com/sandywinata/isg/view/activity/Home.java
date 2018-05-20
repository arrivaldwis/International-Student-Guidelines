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

public class Home extends AppCompatActivity {

    CardView cvWelcome, cvIntroductionISC, cvBITCampuses, cvStartingDay, cvListProgram, cvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        cvWelcome = (CardView) findViewById(R.id.cvWelcome);
        cvIntroductionISC = (CardView) findViewById(R.id.cvIntroductionISC);
        cvBITCampuses = (CardView) findViewById(R.id.cvBITCampuses);
        cvStartingDay = (CardView) findViewById(R.id.cvStartingDay);
        cvListProgram = (CardView) findViewById(R.id.cvListProgram);
        cvContact = (CardView) findViewById(R.id.cvContact);

        cvWelcome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WelcomeToBit.class);
                startActivity(intent);
            }
        });

        cvIntroductionISC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), IntroductionOffice.class);
                startActivity(intent);
            }
        });

        cvBITCampuses.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BITCampuses.class);
                startActivity(intent);
            }
        });

        cvStartingDay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Startingday.class);
                startActivity(intent);
            }
        });

        cvListProgram.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListProgram.class);
                startActivity(intent);
            }
        });

        cvContact.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Contacts.class);
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
