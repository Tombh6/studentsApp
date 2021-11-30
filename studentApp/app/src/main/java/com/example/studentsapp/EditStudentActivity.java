package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class EditStudentActivity extends AppCompatActivity {
    List<Student> data;
    EditText nameEdit;
    EditText idEdit;
    CheckBox checkBox;
    Button deleteButton;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        nameEdit = findViewById(R.id.edit_name_et);
        idEdit = findViewById(R.id.edit_id_et);
        checkBox = findViewById(R.id.edit_cb);
        data = Model.instance.getAllStudents();
        cancelButton = findViewById(R.id.edit_cancel_btn);
        deleteButton = findViewById(R.id.edit_delete_btn);
        saveButton = findViewById(R.id.edit_save_btn);

        String pos = getIntent().getStringExtra("EXTRA_POSITION");
        Log.d("Edit","row was clicked " + pos);

        Student curr = data.get(Integer.parseInt(pos));
        Log.d("Edit","Got student");
        checkBox.setChecked(curr.isFlag());
        nameEdit.setText(curr.getName());
        idEdit.setText(curr.getId());

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit","Cancel button");
                Intent sendIntent = new Intent(EditStudentActivity.this, StudentListRowAcivity.class);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit","Save button");
                String newName = nameEdit.getText().toString();
                String newID = idEdit.getText().toString();
                Boolean newCB = checkBox.isChecked();

                data.remove(Integer.parseInt(pos));
                data.add(new Student(newName, newID, newCB));

                Intent sendIntent = new Intent(EditStudentActivity.this, StudentListRowAcivity.class);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra("EXTRA_POSITION", String.valueOf(data.size() - 1));
                // Start the activity
                startActivity(sendIntent);

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Edit","Delete button");
                data.remove(Integer.parseInt(pos));

                Intent sendIntent = new Intent(EditStudentActivity.this, StudentListRowAcivity.class);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                // Start the activity
                startActivity(sendIntent);

            }
        });
    }
}