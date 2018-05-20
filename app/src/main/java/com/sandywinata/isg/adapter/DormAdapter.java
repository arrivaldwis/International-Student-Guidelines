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
import com.sandywinata.isg.model.DormModel;
import com.sandywinata.isg.model.POIModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Leonardo on 4/21/2018.
 */

public class DormAdapter extends RecyclerView.Adapter<DormAdapter.ViewHolder> {

    //deklarasi context dari activity dan arraylist yang didapatkan
    Context context;
    List<DormModel> commentList;
//    RoundedBitmapDrawable rounded;

    //konstruktor utk inisialisasi value pada context dan list dari activity
    public DormAdapter(Context context, List<DormModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    //view holder untuk deklarasi dan inisialisasi view pada layout comment
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView ticket;
        TextView desc;
        ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            ticket = itemView.findViewById(R.id.tvTicket);
            desc = itemView.findViewById(R.id.tvDesc);
            photo = itemView.findViewById(R.id.imgPoi);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating/set layout comment ke adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_dorm, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final DormModel comment = commentList.get(position);
        holder.name.setText(comment.getDorm());
        holder.ticket.setText("Type:"+comment.getRoom_type()+"\n"+comment.getDesc()+"\n\nAddress: "+comment.getAddress());
        holder.desc.setText("Facilities:\n"+comment.getFacilities());
        Picasso.get().load(comment.getImg()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}