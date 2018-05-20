package com.sandywinata.isg.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.adapter.StartingAdapter;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.StartingModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartingSemester extends AppCompatActivity {

    @BindView(R.id.rvData)
    RecyclerView rvData;
    @BindView(R.id.tvSemester)
    TextView tvSemester;

    private ArrayList<StartingModel> startingList;
    private StartingAdapter mAdapter;
    private String starting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_semester);
        ButterKnife.bind(this);
        startingList = new ArrayList<>();
        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(llManager);
        mAdapter = new StartingAdapter(this , startingList);
        rvData.setAdapter(mAdapter);

        if(getIntent().getExtras()!=null) {
            starting  = getIntent().getStringExtra("starting");
            loadStarting();
        }
    }

    public void loadStarting() {
        tvSemester.setText(starting.toUpperCase()+" SEMESTER");
        Constants.refStarting.child(starting).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                startingList.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    StartingModel model = ds.getValue(StartingModel.class);
                    startingList.add(model);
                    mAdapter.notifyDataSetChanged();
                }
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
