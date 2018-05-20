package com.sandywinata.isg.view.activity;

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
import com.sandywinata.isg.model.ProgramListModel;
import com.sandywinata.isg.model.ProgramModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Undergraduate extends AppCompatActivity {

    @BindView(R.id.txtdetailUndergraduate)
    TextView txtdetailUndergraduate;
    @BindView(R.id.txtHeaderUndergraduate)
    TextView txtHeaderUndergraduate;
    @BindView(R.id.txtDesc)
    TextView txtDesc;
    @BindView(R.id.txtDescEnglish)
    TextView txtDescEng;
    @BindView(R.id.txtdetailUndergraduateEnglish)
    TextView txtdetailUndergraduateEng;

    private String program;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_undergraduate);
        ButterKnife.bind(this);

        if(getIntent().getExtras()!=null) {
            program = getIntent().getStringExtra("program");
            txtHeaderUndergraduate.setText(program.toUpperCase()+" PROGRAM");
            loadProgram();
        }
    }

    String list = "";
    String listEng = "";
    private void loadProgram() {
        Constants.refProgram.child(program).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ProgramModel model = dataSnapshot.getValue(ProgramModel.class);
                txtDesc.setText(model.getDesc());

                Constants.refProgram.child(program).child("list").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds:dataSnapshot.getChildren()) {
                            ProgramListModel m = ds.getValue(ProgramListModel.class);
                            list += m.getName()+"\n";
                        }
                        txtdetailUndergraduate.setText(list);
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

        Constants.refProgram.child(program+"-english").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ProgramModel model = dataSnapshot.getValue(ProgramModel.class);
                txtDescEng.setText(model.getDesc());

                Constants.refProgram.child(program+"-english").child("list").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds:dataSnapshot.getChildren()) {
                            ProgramListModel m = ds.getValue(ProgramListModel.class);
                            listEng += m.getName()+"\n";
                        }
                        txtdetailUndergraduateEng.setText(listEng);
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
