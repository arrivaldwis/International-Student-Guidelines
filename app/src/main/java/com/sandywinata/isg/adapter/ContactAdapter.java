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
import com.sandywinata.isg.model.ContactModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Leonardo on 4/21/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    //deklarasi context dari activity dan arraylist yang didapatkan
    Context context;
    List<ContactModel> commentList;
//    RoundedBitmapDrawable rounded;

    //konstruktor utk inisialisasi value pada context dan list dari activity
    public ContactAdapter(Context context, List<ContactModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    //view holder untuk deklarasi dan inisialisasi view pada layout comment
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView person_name;
        TextView occupation;
        TextView roomnumber;
        TextView mobile;
        TextView phone;
        TextView email;
        ImageView person_photo;

        public ViewHolder(View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.person_name);
            occupation = itemView.findViewById(R.id.occupation);
            roomnumber = itemView.findViewById(R.id.roomnumber);
            mobile = itemView.findViewById(R.id.mobile);
            phone = itemView.findViewById(R.id.phone);
            email = itemView.findViewById(R.id.email);
            person_photo = itemView.findViewById(R.id.person_photo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating/set layout comment ke adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ContactModel comment = commentList.get(position);
        holder.person_name.setText(comment.getName());
        holder.occupation.setText(comment.getJabatan());
        holder.roomnumber.setText(comment.getOffice());
        holder.mobile.setText(comment.getMobile());
        holder.phone.setText(comment.getPhone());
        holder.email.setText(comment.getEmail());
        Picasso.get().load(comment.getImgUrl()).into(holder.person_photo);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}