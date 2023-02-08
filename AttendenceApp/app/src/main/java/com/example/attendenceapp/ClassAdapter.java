package com.example.attendenceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {
    ArrayList<ClassItem> classItems;
    Context context;
    private  OnItemClickedListener onItemClickedListener;

    public OnItemClickedListener getOnItemClickedListener() {
        return onItemClickedListener;
    }

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }

//    When Click one item it will go to another Activity by this interface
    public interface OnItemClickedListener{
        void onClick(int possition);
    }



    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView className, subjectName;

        public ClassViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener) {
            super(itemView);

            className = itemView.findViewById(R.id.class_tv);
            subjectName = itemView.findViewById(R.id.subject_tv);
            // aDD OnClick listener and get the itemposition
            itemView.setOnClickListener(v->onItemClickedListener.onClick(getAdapterPosition()));


        }
    }

    public ClassAdapter(ArrayList<ClassItem> classItems, Context context) {
        this.classItems = classItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item, parent, false);

        //Return onItemClick Listener
        return new ClassViewHolder(itemView,onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
        holder.className.setText(classItems.get(position).getClassName());
        holder.subjectName.setText(classItems.get(position).getSubjectName());

    }

    @Override
    public int getItemCount() {

        return classItems.size();
    }



}
