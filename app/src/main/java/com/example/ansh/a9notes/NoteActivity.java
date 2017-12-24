package com.example.ansh.a9notes;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    private static final String TAG = "NoteActivity...";
    EditText titleET;
    EditText noteET;
    int noteType;

    entryViewmodel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        model = ViewModelProviders.of(this).get(entryViewmodel.class);


        titleET = (EditText) findViewById(R.id.titleIDactivity2);
        noteET = (EditText) findViewById(R.id.editnotelayoutIDactivity2);

        Intent recievedIntent = getIntent();

        noteType = recievedIntent.getIntExtra("NOTETYPE", -1);
        if (noteType == -1) {//oldnote has called


            titleET.setText(recievedIntent.getStringExtra("TITLE"));
            noteET.setText(recievedIntent.getStringExtra("DATA"));

        } else {
            //new note has called
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this, "saved!", Toast.LENGTH_SHORT).show();
        DBEntryStructure Entry = new DBEntryStructure(titleET.getText().toString(), noteET.getText().toString());
        model.insertAtend(Entry);
    }
}
