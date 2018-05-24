package com.sandywinata.isg.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.service.autofill.Dataset;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.sandywinata.isg.R;
import com.sandywinata.isg.config.Constants;
import com.sandywinata.isg.config.PicassoImageLoadingService;
import com.sandywinata.isg.model.BannerModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ss.com.bannerslider.Slider;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.event.OnSlideClickListener;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bannerSlider)
    Slider bannerSlider;

    CardView cvHome, cvTodolist, cvAttraction, cvBITMaps, cvConversation, cvLifestyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Slider.init(new PicassoImageLoadingService(this));

        cvHome = (CardView) findViewById(R.id.cvHome);
        cvTodolist = (CardView) findViewById(R.id.cvTodolist);
        cvAttraction = (CardView) findViewById(R.id.cvAttraction);
        cvBITMaps = (CardView) findViewById(R.id.cvBITMaps);
        cvConversation = (CardView) findViewById(R.id.cvConversation);
        cvLifestyle = (CardView) findViewById(R.id.cvLifestyle);

        loadImageBanner();

        cvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
            }
        });

        cvTodolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TodoList.class);
                startActivity(intent);
            }
        });

        cvAttraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Attraction.class);
                startActivity(intent);
            }
        });

        cvBITMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BITMaps.class);
                startActivity(intent);
            }
        });

        cvConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Conversation.class);
                startActivity(intent);
            }
        });

        cvLifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LifeStyle.class);
                startActivity(intent);
            }
        });

    }

    private void loadSlider() {
        bannerSlider.postDelayed(new Runnable() {
            @Override
            public void run() {
                bannerSlider.setAdapter(new MainSliderAdapter());
                bannerSlider.setSelectedSlide(0);
                bannerSlider.setOnSlideClickListener(new OnSlideClickListener() {
                    @Override
                    public void onSlideClick(int position) {
                        Intent browser = new Intent();
                        browser.setAction(Intent.ACTION_VIEW);
                        browser.setData(Uri.parse(imgUrl.get(position).getLink_url()));
                        startActivity(browser);
                    }
                });
            }
        }, 1500);
    }

    private ArrayList<BannerModel> imgUrl = new ArrayList<>();
    private void loadImageBanner() {
        Constants.refBanner.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    BannerModel model = ds.getValue(BannerModel.class);
                    imgUrl.add(model);
                }

                loadSlider();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public class MainSliderAdapter extends SliderAdapter {

        @Override
        public int getItemCount() {
            return imgUrl.size();
        }

        @Override
        public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
            viewHolder.bindImageSlide(imgUrl.get(position).getImg_url());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnLogout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
