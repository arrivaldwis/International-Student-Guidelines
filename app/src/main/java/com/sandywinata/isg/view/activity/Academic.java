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
import com.sandywinata.isg.model.AcademicModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Academic extends AppCompatActivity {

    @BindView(R.id.imgTranscript)
    ImageView imgTranscript;
    @BindView(R.id.tvName)
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);

        if(getIntent().getExtras()!=null) {
            int id = getIntent().getIntExtra("Id",0);
            Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
        }

        ButterKnife.bind(this);
        loadAcademic();
    }

    private void loadAcademic() {
        Constants.refAcademicCal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AcademicModel model = dataSnapshot.getValue(AcademicModel.class);

                Picasso.get()
                        .load(model.imgUrl)
                        .into(imgTranscript);

                tvName.setText(model.getName());
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
