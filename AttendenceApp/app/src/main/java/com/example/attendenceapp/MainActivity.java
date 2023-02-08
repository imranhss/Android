package com.example.attendenceapp;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton flotingBtnAdd;
    RecyclerView recyclerView;
    ClassAdapter classAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClassItem> classItems = new ArrayList<>();

    // for new toolbar
    Toolbar toolbar;
    TextView title, subTitle;
    ImageButton back, save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flotingBtnAdd = findViewById(R.id.flotingBtnAdd);

        flotingBtnAdd.setOnClickListener(View -> showDialog());

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        classAdapter = new ClassAdapter(classItems, this);
        recyclerView.setAdapter(classAdapter);

        setToolbar();


        //when we click on item it will go to another activity by this method
        classAdapter.setOnItemClickedListener(position -> goToItemActivity(position));


    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        title = toolbar.findViewById(R.id.title_toolbar);
        subTitle = toolbar.findViewById(R.id.subtitle_toolbar);

        back=toolbar.findViewById(R.id.back);
        save=toolbar.findViewById(R.id.save);

        title.setText("Attendence App");
        subTitle.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        save.setVisibility(View.GONE);
    }

    private void goToItemActivity(int position) {
        Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
        // want to show Class name and subject name to new activity
        intent.putExtra("className", classItems.get(position).getClassName());
        intent.putExtra("subjectName", classItems.get(position).getSubjectName());
        intent.putExtra("position", position);
        startActivity(intent);


    }

    private void showDialog() {
        MyDialog dialog = new MyDialog();
        dialog.show(getSupportFragmentManager(), MyDialog.CLASS_ADD_DIALOG);
        dialog.setListener((className, subjectName) -> addClass(className, subjectName));

    }


    private void addClass(String className, String subjectName) {
        classItems.add(new ClassItem(className, subjectName));
        classAdapter.notifyDataSetChanged();

    }
}