package com.example.testandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class StudentList extends AppCompatActivity {

    private ListView studentList;
    private ArrayAdapter<String> arrayAdapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        studentList = findViewById(R.id.studentList);
        searchView=findViewById(R.id.search);

        String[] students = getResources().getStringArray(R.array.studeltListArray);

        // add all data into adapter
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.sample_data, R.id.sample_list, students);
        // add all adapter data to List
        studentList.setAdapter(arrayAdapter);

        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key=arrayAdapter.getItem(position);
                Intent intent=new Intent(getApplicationContext(), StudentDetails.class);
                intent.putExtra("key", key);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return true;
            }
        });



//
//
//        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return true;
//            }
//        });


    }


}