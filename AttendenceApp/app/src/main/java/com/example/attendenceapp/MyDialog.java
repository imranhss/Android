package com.example.attendenceapp;

import android.app.Dialog;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MyDialog extends DialogFragment {


    public static String CLASS_ADD_DIALOG="addClass";

    private OnClickListener listener;

    public OnClickListener getListener() {
        return listener;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public  interface  OnClickListener{
        void onClick(String text1, String text2);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog=null;
        if(getTag().equals(CLASS_ADD_DIALOG)){
            dialog=getAddDialog();
        }

        return dialog;
    }

    private Dialog getAddDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        builder.setView(view);
        TextView title=view.findViewById(R.id.titleDialog);
        title.setText("Add new Class");


        EditText class_edit=view.findViewById(R.id.edt01);
        EditText subject_edit=view.findViewById(R.id.edt02);
        class_edit.setHint("Class Name");
        subject_edit.setHint("Subject Name");

        Button cancel=view.findViewById(R.id.cancel_btn);
        Button add=view.findViewById(R.id.add_btn);

        cancel.setOnClickListener(v-> dismiss());
        add.setOnClickListener(v-> {
            String className=class_edit.getText().toString();
            String subjectName=subject_edit.getText().toString();
            listener.onClick(className, subjectName);
            dismiss();
        });

        return builder.create();
    }
}
