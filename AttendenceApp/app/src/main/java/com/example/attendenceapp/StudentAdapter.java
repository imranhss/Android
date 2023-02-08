package com.example.attendenceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    ArrayList<StudentItem> studentItems;
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



    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView roll, name, status;

        public StudentViewHolder(@NonNull View itemView, OnItemClickedListener onItemClickedListener) {
            super(itemView);

            roll = itemView.findViewById(R.id.roll);
            name = itemView.findViewById(R.id.name);
            status = itemView.findViewById(R.id.status);

            // aDD OnClick listener and get the itemposition
            itemView.setOnClickListener(v->onItemClickedListener.onClick(getAdapterPosition()));


        }
    }

    public StudentAdapter(ArrayList<StudentItem> studentItems, Context context) {
        this.studentItems = studentItems;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item, parent, false);

        //Return onItemClick Listener
        return new StudentViewHolder(itemView,onItemClickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.roll.setText(studentItems.get(position).getRoll());
        holder.name.setText(studentItems.get(position).getName());
        holder.status.setText(studentItems.get(position).getStatus());

    }

    @Override
    public int getItemCount() {

        return studentItems.size();
    }



}
