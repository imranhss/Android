package com.example.attendenceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton  flotingBtnAdd;
    RecyclerView recyclerView;
    ClassAdapter classAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClassItem> classItems=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flotingBtnAdd=findViewById(R.id.flotingBtnAdd);

        flotingBtnAdd.setOnClickListener(View-> showDialog());

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        classAdapter=new ClassAdapter( classItems, this);
        recyclerView.setAdapter(classAdapter);


    }

    private void showDialog(){
        MyDialog dialog=new MyDialog();
        dialog.show(getSupportFragmentManager(), MyDialog.CLASS_ADD_DIALOG);
        dialog.setListener((className, subjectName)->addClass(className, subjectName));


//        AlertDialog.Builder builder=new AlertDialog.Builder(this);
//        View view= LayoutInflater.from(this).inflate(R.layout.dialog, null);
//        builder.setView(view);
//        AlertDialog dialog= builder.create();
//        dialog.show();
//
//        class_edit=view.findViewById(R.id.edt01);
//        subject_edit=view.findViewById(R.id.edt02);
//        Button cancel=view.findViewById(R.id.cancel_btn);
//        Button add=view.findViewById(R.id.add_btn);
//
//        cancel.setOnClickListener(v-> dialog.dismiss());
//        add.setOnClickListener(v-> {
//            addClass();
//            dialog.dismiss();
//        });

//        builder.create().show();
    }


    private void addClass(String className, String subjectName) {
        classItems.add(new ClassItem(className,subjectName));
        classAdapter.notifyDataSetChanged();

    }
}