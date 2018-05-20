package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.model.CampusModel;
import com.sandywinata.isg.model.PhotoModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhongguancunCampus extends AppCompatActivity {

    @BindView(R.id.txtHeader)
    TextView txtHeader;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.llPic)
    LinearLayout llPic;

    String campus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhongguancun_campus);
        ButterKnife.bind(this);

        if(getIntent().getExtras()!=null) {
            campus = getIntent().getStringExtra("campus");
        }
        loadCampus();
    }

    public void loadCampus() {
        String title = "LiangXiang Campus";
        if(campus.equals("zgc")) title = "Zhongguangcun Campus";

        txtHeader.setText(title);
        Constants.refCampus.child(campus).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                CampusModel model = dataSnapshot.getValue(CampusModel.class);
                txtDetail.setText(model.getDesc());

                Constants.refCampus.child(campus).child("photo").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds:dataSnapshot.getChildren()) {
                            PhotoModel photo = ds.getValue(PhotoModel.class);
                            ImageView img = new ImageView(ZhongguancunCampus.this);
                            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            lp.setMargins(0, 0, 0, 16);
                            img.setLayoutParams(lp);
                            Picasso.get().load(photo.getUrl()).into(img);
                            llPic.addView(img);
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
