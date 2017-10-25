package com.example.ansh.a9notes.Rvfiles;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ansh.a9notes.R;

/**
 * Created by ansh on 16/10/17.
 */

public class RvHolder extends RecyclerView.ViewHolder{
    public TextView mainrvnotetitle;

    public RvHolder(View itemView) {
        super(itemView);
        mainrvnotetitle=itemView.findViewById(R.id.mainrveachitemDefualttextview);


    }
}
