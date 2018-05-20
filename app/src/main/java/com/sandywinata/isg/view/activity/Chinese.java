package com.sandywinata.isg.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.ChineseProgramModel;
import com.sandywinata.isg.model.ProgramListModel;
import com.sandywinata.isg.model.ProgramModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Chinese extends AppCompatActivity {

    @BindView(R.id.txtdetail)
    TextView txtdetail;
    @BindView(R.id.txtdetail2)
    TextView txtdetail2;
    @BindView(R.id.imgPic)
    ImageView imgPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        ButterKnife.bind(this);
        loadProgram();
    }

    private void loadProgram() {
        Constants.refProgram.child("chinese").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ChineseProgramModel model = dataSnapshot.getValue(ChineseProgramModel.class);
                txtdetail.setText(model.getDesc());
                Picasso.get().load(model.getPic()).into(imgPic);
                txtdetail2.setText(model.getDesc2());
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
