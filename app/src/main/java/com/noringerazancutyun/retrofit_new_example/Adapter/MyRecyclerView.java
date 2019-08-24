package com.noringerazancutyun.retrofit_new_example.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noringerazancutyun.retrofit_new_example.Model.Model;
import com.noringerazancutyun.retrofit_new_example.R;

import java.util.List;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyViewHolder> {

    private Context context;
    private List<Model> models;

    public MyRecyclerView(Context context, List<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.title.setText(models.get(i).getTitle());
        myViewHolder.id.setText(String.valueOf(models.get(i).getId()));
        myViewHolder.userId.setText(String.valueOf(models.get(i).getUserId()));
        myViewHolder.body.setText(models.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        TextView userId;
        TextView body;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            id = itemView.findViewById(R.id.item_id);
            userId = itemView.findViewById(R.id.item_userId);
            body = itemView.findViewById(R.id.item_body);
        }
    }
}
