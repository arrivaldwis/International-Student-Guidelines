package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.adapter.ContactAdapter;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.ContactModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Contacts extends AppCompatActivity {

    @BindView(R.id.rvData)
    RecyclerView rvData;

    private ArrayList<ContactModel> contactList;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ButterKnife.bind(this);
        setUI();
        loadContact();
    }

    private void setUI() {
        contactList = new ArrayList<>();
        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(llManager);
        mAdapter = new ContactAdapter(this, contactList);
        rvData.setAdapter(mAdapter);
    }

    private void loadContact() {
        Constants.refContact.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                contactList.clear();
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    ContactModel model = ds.getValue(ContactModel.class);
                    contactList.add(model);
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
