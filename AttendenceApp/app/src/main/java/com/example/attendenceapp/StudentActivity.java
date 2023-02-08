package com.example.attendenceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class StudentActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView title, subTitle;
    ImageButton back, save;
    private  String className,subjectName;
    private int position;

    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<StudentItem> studentItems = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent=getIntent();
        className=intent.getStringExtra("className");
        subjectName=intent.getStringExtra("subjectName");
        position=intent.getIntExtra("position", -1);
        recyclerView = findViewById(R.id.student_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        studentAdapter = new StudentAdapter(studentItems, this);
        recyclerView.setAdapter(studentAdapter);

        setToolbar();

    }


    private void setToolbar() {

        toolbar = findViewById(R.id.toolbar);
        title = toolbar.findViewById(R.id.title_toolbar);
        subTitle = toolbar.findViewById(R.id.subtitle_toolbar);

        back=toolbar.findViewById(R.id.back);
        save=toolbar.findViewById(R.id.save);

        title.setText(className);
        subTitle.setText(subjectName);
        back.setOnClickListener(v->onBackPressed());
        toolbar.inflateMenu(R.menu.student_menu);
        toolbar.setOnMenuItemClickListener(menuItem ->onMenuItemClick(menuItem));


    }

    private boolean onMenuItemClick(MenuItem menuItem) {

        if(menuItem.getItemId() == R.id.add_student){

            showAddStudentDialog();
        }
        return  true;
    }

    private void showAddStudentDialog() {
        MyDialog dialog=new MyDialog();
        dialog.show(getSupportFragmentManager(), MyDialog.STUDENT_ADD_DIALOG);

        dialog.setListener((roll, name)->addtudent(roll, name));
    }

    private void addtudent(String roll, String name) {
        studentItems.add(new StudentItem(roll, name));
        studentAdapter.notifyItemChanged(studentItems.size()-1);
    }

}