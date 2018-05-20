package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.AttractionModel;
import com.sandywinata.isg.model.WelcomeModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeToBit extends AppCompatActivity {

    @BindView(R.id.tvAbout)
    TextView tvAbout;
    @BindView(R.id.tvCampuses)
    TextView tvCampuses;
    @BindView(R.id.tvColleges)
    TextView tvColleges;
    @BindView(R.id.tvDemographics)
    TextView tvDemographics;
    @BindView(R.id.tvInternational)
    TextView tvInternational;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_bit);
        ButterKnife.bind(this);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        loadWelcome();
    }

    public void loadWelcome() {
        Constants.refWelcome.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WelcomeModel model = dataSnapshot.getValue(WelcomeModel.class);
                tvAbout.setText(model.getAbout());
                tvCampuses.setText(model.getCampuses());
                tvColleges.setText(model.getColleges());
                tvDemographics.setText(model.getDemographics());
                tvInternational.setText(model.getInternational());
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
