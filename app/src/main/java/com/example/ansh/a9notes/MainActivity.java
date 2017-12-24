package com.example.ansh.a9notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ansh.a9notes.Rvfiles.RvAdapter;
import com.example.ansh.a9notes.Rvfiles.RvData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main Activity";
    RecyclerView rv;
    FloatingActionButton fabnew;
    List<DBEntryStructure> feeder;
    RvAdapter adp;

    private  entryViewmodel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for feeder =getdataArr();
        //fixme: add an empty arr first,start a thread ,read db and update the adapter's feeder later


        model= ViewModelProviders.of(this).get(entryViewmodel.class);


        Log.e(TAG, "onCreate:on create called called,creating layouts on screent ");
        rv = (RecyclerView) findViewById(R.id.mainRVlayoutID);
        feeder = new ArrayList<>();


        adp = new RvAdapter(feeder);
        rv.setAdapter(adp);
        rv.setLayoutManager(new GridLayoutManager(this, 3));
        Log.e(TAG, "onCreate: setted up layouts now calling the database:");

        model.getAllentries().observe(this, new Observer<List<DBEntryStructure>>() {
            @Override
            public void onChanged(@Nullable List<DBEntryStructure> dbEntryStructures) {
                adp.setRvDataArr(dbEntryStructures);
            }
        });


        fabnew = (FloatingActionButton) findViewById(R.id.fablayoutid);
        fabnew.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "main activity";

            @Override
            public void onClick(View v) {

                Intent openNewNote = new Intent(v.getContext(), NoteActivity.class);
                openNewNote.putExtra("TITLE", "");
                openNewNote.putExtra("NOTE", "");
                startActivity(openNewNote);


               // UpdateDataArr();
                Log.e(TAG, "fabOnclick: new note opened ");

            }
        });

    }


//    public void UpdateDataArr() {
//
//
//        final ArrayList<RvData> dataArr = adp.getRvDataArrayList();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "<<UpdateDataArr>>:  calling databasein a new thread");
//
//                AppDB dbobject = Room.databaseBuilder(MainActivity.this, AppDB.class, "AllNotes.db")
//                        .build();
//
//
//                List<DBEntryStructure> allnotes = dbobject.allActions().getAllnotes();
//                Log.e(TAG, "UpdateDataArr: allnotes recieved are:");
//                for (DBEntryStructure i : allnotes) {
//                    dataArr.add(new RvData(i.getTitle(), i.getData()));
//                    Log.e(TAG, "note: " + i);
//                }
//
//
//            }
//        }).start();
//        adp.setRvDataArrayList(dataArr);
//        adp.notifyDataSetChanged();
//
//
//    }
}

