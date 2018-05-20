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
import com.sandywinata.isg.model.InternationalModel;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntroductionOffice extends AppCompatActivity {

    @BindView(R.id.tvOffice)
    TextView tvOffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_office);
        ButterKnife.bind(this);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        loadInternational();
    }

    public void loadInternational() {
        Constants.refInternational.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                InternationalModel model = dataSnapshot.getValue(InternationalModel.class);
                tvOffice.setText(model.getOffice());
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
