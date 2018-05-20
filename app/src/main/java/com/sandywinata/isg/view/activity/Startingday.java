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

import butterknife.BindView;
import butterknife.ButterKnife;

public class Startingday extends AppCompatActivity {

    @BindView(R.id.cvSpringSemester)
    CardView cvSpringSemester;
    @BindView(R.id.cvAutumnSemester)
    CardView cvAutumnSemester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startingday);
        ButterKnife.bind(this);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        cvSpringSemester.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartingSemester.class);
                intent.putExtra("starting", "spring");
                startActivity(intent);
            }
        });

        cvAutumnSemester.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), StartingSemester.class);
                intent.putExtra("starting", "autumn");
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
