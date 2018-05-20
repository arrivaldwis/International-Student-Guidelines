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
import com.sandywinata.isg.model.FAQModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Leonardo on 4/21/2018.
 */

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    //deklarasi context dari activity dan arraylist yang didapatkan
    Context context;
    List<FAQModel> commentList;
//    RoundedBitmapDrawable rounded;

    //konstruktor utk inisialisasi value pada context dan list dari activity
    public FaqAdapter(Context context, List<FAQModel> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    //view holder untuk deklarasi dan inisialisasi view pada layout comment
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView q;
        TextView a;

        public ViewHolder(View itemView) {
            super(itemView);
            a = itemView.findViewById(R.id.a);
            q = itemView.findViewById(R.id.q);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating/set layout comment ke adapter
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_faq, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final FAQModel comment = commentList.get(position);
        holder.q.setText(comment.getQ());
        holder.a.setText(comment.getA());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}