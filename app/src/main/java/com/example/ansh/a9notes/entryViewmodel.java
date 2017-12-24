package com.example.ansh.a9notes;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by ansh on 22/12/17.
 */

public class entryViewmodel extends AndroidViewModel {
    private DBQueryHandler queryHandler;

    public entryViewmodel(@NonNull Application application) {
        super(application);
        queryHandler=new DBQueryHandler(application);
    }


    public void insertAtend(DBEntryStructure... entry) {
        queryHandler.insertAtend(entry);

    }

    public void removeAll() {
        queryHandler.removeAll();
    }

    public LiveData<List<DBEntryStructure>> getAllentries() {
        return queryHandler.getAllentries();
    }


    public DBEntryStructure getEntrybyPositon(int pos){
        return  queryHandler.getEntrybyPositon(pos);
    }


}
