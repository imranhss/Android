package com.example.testandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    private ImageView image_student;
    private TextView name_student, title_student, cell_student, about_title_student,about_student;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        image_student=findViewById(R.id.image_student);
        name_student=findViewById(R.id.name_student);
        title_student=findViewById(R.id.title_student);
        cell_student=findViewById(R.id.cell_student);
        about_title_student=findViewById(R.id.about_title_student);
        about_student=findViewById(R.id.about_student);


        Bundle bundle=getIntent().getExtras();
        String key=bundle.getString("key");
//
//        String zahid=getResources().getString(R.string.zahid);
//        String roman=getResources().getString(R.string.roman);
//        String salman=getResources().getString(R.string.salman);

        String zahid="Zahid Shikder";
        String salman="Salman Shah";
        String roman="Roman Ali";

        if(key.equalsIgnoreCase(zahid)){

            image_student.setImageResource(R.drawable.imran);
            name_student.setText(R.string.zahid);
            title_student.setText(R.string.zahid_title);
            cell_student.setText(R.string.zahid_cell);
            about_title_student.setText(R.string.zahid_about_title);
            about_student.setText(R.string.zahid_about);

        }
        if (key.equalsIgnoreCase(roman)) {

            image_student.setImageResource(R.drawable.imran);
            name_student.setText(R.string.roman);
            title_student.setText(R.string.roman_title);
            cell_student.setText(R.string.roman_cell);
            about_title_student.setText(R.string.roman_about_title);
            about_student.setText(R.string.roman_about);

        }
        if (key.equalsIgnoreCase(salman)) {

            image_student.setImageResource(R.drawable.imran);
            name_student.setText(R.string.salman);
            title_student.setText(R.string.salman_title);
            cell_student.setText(R.string.salman_cell);
            about_title_student.setText(R.string.salman_about_title);
            about_student.setText(R.string.salman_about);

        }



    }
}