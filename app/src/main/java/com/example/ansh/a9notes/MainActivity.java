package com.example.ansh.a9notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ansh.a9notes.Rvfiles.RvAdapter;
import com.example.ansh.a9notes.Rvfiles.RvData;
import com.example.ansh.a9notes.Rvfiles.RvFeeder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    FloatingActionButton fab;
    ArrayList<RvData> feeder;
    RvAdapter adp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.mainRVlayoutID);

        feeder =new RvFeeder().getDefaultDataSourceFeed();
        adp=new RvAdapter(feeder);
        rv.setAdapter(adp);
        rv.setLayoutManager(new GridLayoutManager(this,3));

        fab= (FloatingActionButton) findViewById(R.id.fablayoutid);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                feeder.add(new RvData("",""));
                adp.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==37 && data.hasExtra("podition")){
           RvData d= feeder.get(data.getIntExtra("podition",0));
            d.setTitle(data.getStringExtra("editedtitle"));
            adp.notifyDataSetChanged();

        }
    }
}

//CHECKOUT THE EXAMPLES(vvvvv) FIRST:
        /* here is What  what i Intend To do:
                in RvAdapter, code for eachItem Onclick() is written. when user clicks on any of the notes(items of the recycler view)
                A new Activity("Details.java") opens.I want the title of the note(present in Details.java) to be returned back so here
                I can set it as title too.
        --------->eg: user opens the app>sees the RVlayout  with one empty note.clicks it and a new Activity opens.In this Activity
                User Sets Title as "Todo" and sets the data as "Eat potatoes \n Code bananas. \n" and presses back button, and comes
                back to home screen. he sees that the empty note's title now read as "Todo".
            here is what I also Intend to do:
                I want to save user's ALL DATA(both title and data) from second Activity Details.java to be available for future use
                using shred preferences.In Details.java,I am using shared preferences in oncreate() onpause() and onResume() for the
                same. it is weirdly working some what fine.It is saving data  of the item for the perticular arrylist position, but
                next time the app launches, it again starts with a single item recycler view.however ,if the user somehow increases the
                Recycler-View's note count to that position and clicks, it shows the last saved data easily.
        --------->eg: User opens the appp for first time, creates 8 notes  and presses 6th note. nre Activity opens , he writes "todo"
                    in title and "Eat potatoes \n Code bananas. \n"  in data and presses the back button. he finds himself looking at
                    the main activity's Recycler View with 8 notes. He then closes the app and opens it again.>>He find himself looking
                    himself at the main activity's recycler view with JUST 1 NOTE! however, he presses fb for 6 times and then opens
                    6th note. And he finds his  data "Todo","Eat potatoes \n Code bananas. \n" present there
        */