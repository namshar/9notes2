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
