package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.AttractionModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Attraction extends AppCompatActivity {

    @BindView(R.id.txtAbout)
    TextView txtAbout;
    @BindView(R.id.txtBasic)
    TextView txtBasic;
    @BindView(R.id.txtForeign)
    TextView txtForeign;
    @BindView(R.id.txtTourism)
    TextView txtTourism;
    @BindView(R.id.btnPointofInterest)
    Button btnPointofInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        ButterKnife.bind(this);
        loadAttraction();
    }

    @OnClick(R.id.btnPointofInterest)
    public void poi() {
        startActivity(new Intent(getApplicationContext(), Pointofinterest.class));
    }

    public void loadAttraction() {
        Constants.refAttraction.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AttractionModel model = dataSnapshot.getValue(AttractionModel.class);
                txtAbout.setText(model.getAbout());
                txtBasic.setText(model.getBasic());
                txtForeign.setText(model.getForeign());
                txtTourism.setText(model.getTourism());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
