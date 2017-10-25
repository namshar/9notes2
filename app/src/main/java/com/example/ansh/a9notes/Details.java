package com.example.ansh.a9notes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    private static final String TAG ="Details..." ;
    EditText titleI;
    EditText noteI;
    int position;
    SharedPreferences sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        titleI=(EditText)findViewById(R.id.titleIDactivity2);
        noteI=(EditText)findViewById(R.id.editnotelayoutIDactivity2);

        Intent recievedIntent=getIntent();
        titleI.setText(recievedIntent.getStringExtra("TITLE"));
        noteI.setText(recievedIntent.getStringExtra("NOTE"));

        position=recievedIntent.getIntExtra("POSITION",-1);
        sf=getSharedPreferences("db"+position,MODE_APPEND);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
        Toast.makeText(this,"note Saved!",Toast.LENGTH_SHORT).show();
        sf.edit()
                .putString("TITLESAVE",titleI.getText().toString())
                .putString("NOTESAVE",noteI.getText().toString())
                .commit();
        Intent I=new Intent();
        I.putExtra("podition",position);
        I.putExtra("editedtitle",titleI.getText().toString());
        setResult(37,I);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: " );
        if(sf.contains("TITLESAVE")) {
            titleI.setText(sf.getString("TITLESAVE", "null found"));
            noteI.setText(sf.getString("NOTESAVE", "null found"));
        }

    }

}
