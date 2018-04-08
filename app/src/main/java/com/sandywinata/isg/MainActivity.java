package com.sandywinata.isg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cvHome, cvTodolist, cvAttraction, cvBITMaps, cvConversation, cvLifestyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHome = (CardView) findViewById(R.id.cvHome);
        cvTodolist = (CardView) findViewById(R.id.cvTodolist);
        cvAttraction = (CardView) findViewById(R.id.cvAttraction);
        cvBITMaps = (CardView) findViewById(R.id.cvBITMaps);
        cvConversation = (CardView) findViewById(R.id.cvConversation);
        cvLifestyle = (CardView) findViewById(R.id.cvLifestyle);

        cvHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });

        cvTodolist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TodoList.class);
                startActivity(intent);
            }
        });

        cvAttraction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Attraction.class);
                startActivity(intent);
            }
        });

        cvBITMaps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BITMaps.class);
                startActivity(intent);
            }
        });

        cvConversation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Conversation.class);
                startActivity(intent);
            }
        });

        cvLifestyle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LifeStyle.class);
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
