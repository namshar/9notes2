package com.example.ansh.a9notes;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {
    private static final String TAG ="NoteActivity..." ;
    EditText titleI;
    EditText noteI;
    String recievedTitle;
    String recievedMessage;
    int recievedPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        titleI=(EditText)findViewById(R.id.titleIDactivity2);
        noteI=(EditText)findViewById(R.id.editnotelayoutIDactivity2);

        Intent recievedIntent=getIntent();

        recievedTitle=recievedIntent.getStringExtra("TITLE");
        recievedMessage=recievedIntent.getStringExtra("NOTE");
        recievedPosition=recievedIntent.getIntExtra("POSITION",100);

        titleI.setText(recievedTitle);
        noteI.setText(recievedMessage);
        Log.e(TAG, "INTENT CALLED to start note activity!!: title,note,pos recieved="+ recievedTitle+","+recievedMessage +","+recievedPosition );


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
        new Thread(new Runnable() {
            @Override
            public void run() {
                        AppDB dbobject= Room.databaseBuilder(NoteActivity.this,AppDB.class,"AllNotes.db")
                                .build();

                        DBEntryStructure entry=new DBEntryStructure(recievedPosition,recievedTitle,recievedMessage);
                        dbobject.allActions().insert(entry);

            }
        }).start();
        Toast.makeText(NoteActivity.this,"note Saved!",Toast.LENGTH_SHORT).show();




    }

    @Override
    protected void onResume() {
        super.onResume();


    }

}
