package com.example.ansh.a9notes.Rvfiles;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ansh.a9notes.DBEntryStructure;
import com.example.ansh.a9notes.NoteActivity;
import com.example.ansh.a9notes.R;
import com.example.ansh.a9notes.entryViewmodel;

import java.util.List;

/**
 * Created by ansh on 16/10/17.
 */


public class RvAdapter extends RecyclerView.Adapter<RvHolder> {
    private List<DBEntryStructure> rvDataArr;

    public RvAdapter(List<DBEntryStructure> rvDataArr) {
        this.rvDataArr = rvDataArr;
    }

    //constructor

    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv_eachitemlayout,
                null, false);
        return new RvHolder(v);
    }

    @Override
    public void onBindViewHolder(RvHolder holder, final int position) {
        final TextView titlenote = holder.mainrvnotetitle;

        if (rvDataArr.get(position) == null) {
            titlenote.setText("loading...");
        } else {
            titlenote.setText(rvDataArr.get(position).getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //runintent openOldNote
                Intent openOldNote = new Intent(v.getContext(), NoteActivity.class);
                openOldNote.putExtra("NOTETYPE",-1);
                openOldNote.putExtra("TITLE",rvDataArr.get(position).getTitle());
                openOldNote.putExtra("DATA",rvDataArr.get(position).getData());

                v.getContext().startActivity(openOldNote);


            }
        });
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
        return rvDataArr.size();

    }

    public List<DBEntryStructure> getRvDataArr() {
        return rvDataArr;
    }

    public void setRvDataArr(List<DBEntryStructure> rvDataArr) {
        this.rvDataArr = rvDataArr;
        notifyDataSetChanged();
    }
}


