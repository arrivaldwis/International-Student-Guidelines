package com.sandywinata.isg.view.activity;

import android.service.autofill.Dataset;
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
import com.sandywinata.isg.adapter.DormAdapter;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.AccommodationModel;
import com.sandywinata.isg.model.DormModel;
import com.sandywinata.isg.model.RegistrationModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Accomodation extends AppCompatActivity {

    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.rvZGC)
    RecyclerView rvZGC;
    @BindView(R.id.rvLX)
    RecyclerView rvLX;
    @BindView(R.id.rvSZQ)
    RecyclerView rvSZQ;

    private ArrayList<DormModel> dormList;
    private ArrayList<DormModel> dormList2;
    private ArrayList<DormModel> dormList3;
    private DormAdapter mAdapter;
    private DormAdapter mAdapter2;
    private DormAdapter mAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);
        ButterKnife.bind(this);
        loadRv();
        loadAccommdation();
    }

    private void loadRv(){
        dormList = new ArrayList<>();
        dormList2 = new ArrayList<>();
        dormList3 = new ArrayList<>();
        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager llManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager llManager3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvLX.setLayoutManager(llManager);
        rvSZQ.setLayoutManager(llManager2);
        rvZGC.setLayoutManager(llManager3);

        mAdapter = new DormAdapter(this, dormList);
        mAdapter2 = new DormAdapter(this, dormList2);
        mAdapter3 = new DormAdapter(this, dormList3);
        rvZGC.setAdapter(mAdapter);
        rvLX.setAdapter(mAdapter2);
        rvSZQ.setAdapter(mAdapter3);

    }

    private void loadAccommdation() {
        Constants.refTodo.child("accommodation").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                AccommodationModel model = dataSnapshot.getValue(AccommodationModel.class);
                tvDesc.setText(model.getDesc());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Constants.refTodo.child("accommodation").child("zgc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    DormModel m = ds.getValue(DormModel.class);
                    dormList.add(m);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Constants.refTodo.child("accommodation").child("lx").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    DormModel m = ds.getValue(DormModel.class);
                    dormList2.add(m);
                    mAdapter2.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Constants.refTodo.child("accommodation").child("suzhouqiao").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    DormModel m = ds.getValue(DormModel.class);
                    dormList3.add(m);
                    mAdapter3.notifyDataSetChanged();
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
