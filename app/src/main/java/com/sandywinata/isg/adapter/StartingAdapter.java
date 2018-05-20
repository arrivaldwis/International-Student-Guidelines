package com.sandywinata.isg.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sandywinata.isg.R;
import com.sandywinata.isg.model.POIModel;
import com.sandywinata.isg.model.StartingModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StartingAdapter extends RecyclerView.Adapter<StartingAdapter.ViewHolder> {

    //deklarasi context dari activity dan arraylist yang didapatkan
    Context context;
    List<StartingModel> commentList;
//    RoundedBitmapDrawable rounded;

    //konstruktor utk inisialisasi value pada context dan list dari activity
    public StartingAdapter(Context context, List<StartingModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    //view holder untuk deklarasi dan inisialisasi view pada layout comment
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView desc;
        TextView month;
        TextView name;
        ImageView imgPic;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            month = itemView.findViewById(R.id.tvMonth);
            desc = itemView.findViewById(R.id.tvDesc);
            imgPic = itemView.findViewById(R.id.imgPic);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating/set layout comment ke adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_starting, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final StartingModel comment = commentList.get(position);
        holder.name.setText(comment.getName());
        holder.month.setText(comment.getMonth());
        holder.desc.setText(comment.getDesc());
        Picasso.get().load(comment.getUrl()).into(holder.imgPic);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}