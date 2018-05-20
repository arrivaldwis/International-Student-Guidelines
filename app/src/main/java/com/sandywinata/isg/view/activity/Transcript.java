package com.sandywinata.isg.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.sandywinata.isg.adapter.FaqAdapter;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.FAQModel;
import com.sandywinata.isg.model.RegistrationModel;
import com.sandywinata.isg.model.TranscriptModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Transcript extends AppCompatActivity {

    @BindView(R.id.transpict)
    ImageView transpict;
    @BindView(R.id.tvDesc)
    TextView tvDesc;
    @BindView(R.id.rvQA)
    RecyclerView rvQA;

    private ArrayList<FAQModel> faqList;
    private FaqAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcript);
        faqList = new ArrayList<>();
        ButterKnife.bind(this);

        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvQA.setLayoutManager(llManager);
        mAdapter = new FaqAdapter(this, faqList);
        rvQA.setAdapter(mAdapter);
        loadTranscript();
    }

    private void loadTranscript() {
        Constants.refTodo.child("transcript").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                TranscriptModel model = dataSnapshot.getValue(TranscriptModel.class);
                tvDesc.setText(model.getDesc());
                Picasso.get().load(model.getImg()).into(transpict);

                Constants.refTodo.child("transcript").child("faq").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds:dataSnapshot.getChildren()) {
                            FAQModel m = ds.getValue(FAQModel.class);
                            faqList.add(m);
                            mAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
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
