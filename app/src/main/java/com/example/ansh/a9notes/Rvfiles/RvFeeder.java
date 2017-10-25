package com.example.ansh.a9notes.Rvfiles;

import java.util.ArrayList;

/**
 * Created by ansh on 16/10/17.
 */

public class RvFeeder{
    public RvFeeder() {//<constructor
    }//constructor>


    public ArrayList<RvData> getDefaultDataSourceFeed(){
        ArrayList<RvData> DefaultDataSourceFeed=new ArrayList<>();
        DefaultDataSourceFeed.add(new RvData("Welcome",""));


        return DefaultDataSourceFeed;
    }

}
