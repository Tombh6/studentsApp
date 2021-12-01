package com.example.studentsapp;
//TomBenHamo
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity  {
    EditText nameEdit;
    EditText idEdit;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameEdit = findViewById(R.id.main_name_et);
        idEdit = findViewById(R.id.main_id_et);
        checkBox = findViewById(R.id.main_cb);
        Button saveButton = findViewById(R.id.main_save_btn);
        Button cancelButton = findViewById(R.id.main_cancel_btn);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit","Setting cancel button");
                Intent sendIntent = new Intent(AddStudentActivity.this, StudentListRowAcivity.class);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                // Start the activity
                startActivity(sendIntent);
            }
        });
    }

    private void save() {
        String name = nameEdit.getText().toString();
        String id = idEdit.getText().toString();
        boolean flag = checkBox.isChecked();
        Log.d("TAG","Saved name:" + name + " Id:" + id + " Flag:" + flag);
        List<Student> data = Model.instance.getAllStudents();

        data.add(new Student(name, id, flag));

        Intent sendIntent = new Intent(AddStudentActivity.this, StudentListRowAcivity.class);
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}