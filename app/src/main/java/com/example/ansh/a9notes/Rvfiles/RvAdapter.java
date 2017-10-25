package com.example.ansh.a9notes.Rvfiles;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ansh.a9notes.Details;
import com.example.ansh.a9notes.R;

import java.util.ArrayList;

/**
 * Created by ansh on 16/10/17.
 */


public class RvAdapter extends RecyclerView.Adapter<RvHolder>{
    private ArrayList<RvData> rvDataArrayList;
    public RvAdapter(ArrayList<RvData> rvDataArrayList) {
        this.rvDataArrayList = rvDataArrayList;
    }//constructor

    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv_eachitemlayout,null,false);
        return new RvHolder(v);
    }

    @Override
    public void onBindViewHolder(RvHolder holder, final int position) {
        TextView titlenote=holder.mainrvnotetitle;

        titlenote.setText(rvDataArrayList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {



            //FIXME:PUT THIS IN HOLDER
            @Override
            public void onClick(View v) {


               //runintent opendetails
                Intent opendetails=new Intent(v.getContext(),Details.class);
                opendetails.putExtra("TITLE",rvDataArrayList.get(position).getTitle());
                opendetails.putExtra("NOTE",rvDataArrayList.get(position).getNote());
                opendetails.putExtra("POSITION",position);



                ((Activity) v.getContext()).startActivityForResult(opendetails,37);



            }
        });
        //FIXME======================================================================
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //option to delete
                return false;
            }
        });
        //FIXME-========-======-=========-======-=======-=======-=======-========-===||


    }

    @Override
    public int getItemCount() {
        return rvDataArrayList.size();
        //
        //
        //
        //
    }
}


