package com.sandywinata.isg.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sandywinata.isg.R;
import com.sandywinata.isg.model.ContactModel;
import com.sandywinata.isg.model.ConversationModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

/**
 * Created by Leonardo on 4/21/2018.
 */

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {

    //deklarasi context dari activity dan arraylist yang didapatkan
    Context context;
    List<ConversationModel> commentList;
//    RoundedBitmapDrawable rounded;

    //konstruktor utk inisialisasi value pada context dan list dari activity
    public ConversationAdapter(Context context, List<ConversationModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    //view holder untuk deklarasi dan inisialisasi view pada layout comment
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEnglish;
        TextView tvHanzi;
        TextView tvPinyin;
        LinearLayout llConversation;
        CardView cv;
        ImageButton imgButton;

        public ViewHolder(View itemView) {
            super(itemView);
            tvEnglish = itemView.findViewById(R.id.tvEnglish);
            tvHanzi = itemView.findViewById(R.id.tvHanzi);
            tvPinyin = itemView.findViewById(R.id.tvPinyin);
            llConversation = itemView.findViewById(R.id.llConversation);
            cv = itemView.findViewById(R.id.cv);
            imgButton = itemView.findViewById(R.id.imgButton);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating/set layout comment ke adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_conversation, parent, false);
        return new ViewHolder(v);
    }

    boolean clicked = false;

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ConversationModel comment = commentList.get(position);
        holder.tvEnglish.setText(comment.getEnglish());
        holder.tvHanzi.setText(comment.getMandarin());
        holder.tvPinyin.setText(comment.getPinyin());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!clicked) {
                    clicked = true;
                    holder.llConversation.setVisibility(View.VISIBLE);
                    holder.cv.setBackgroundColor(context.getResources().getColor(R.color.default_indicator_color_selected));
                    mediaPlayer.start();
                    playMusic(comment.getMusic_url());
                } else {
                    clicked = false;
                    holder.llConversation.setVisibility(View.GONE);
                    holder.cv.setBackgroundColor(context.getResources().getColor(R.color.cardview_light_background));
                    mediaPlayer.stop();
                }
            }
        });
    }

    MediaPlayer mediaPlayer = new MediaPlayer();
    private void playMusic(String url) {

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mp, int what, int extra) {
                mp.reset();
                return false;
            }
        });

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IllegalArgumentException e) {
        } catch (IllegalStateException e) {
        } catch (IOException e) {
        }
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}