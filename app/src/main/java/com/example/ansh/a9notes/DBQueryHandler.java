package com.example.ansh.a9notes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by ansh on 22/12/17.
 */

public class DBQueryHandler {
    private DBMethodsDAO dbAllactions;


    //create
    public DBQueryHandler(Application applicationContext) {
        AppDB dbobject = AppDB.getDatabaseInstance(applicationContext);//infact this is also not needed only db actions is needed
        dbAllactions = dbobject.allActions();
    }


    public void insertAtend(DBEntryStructure... entry) {
        new taskInsert().execute(entry);

    }
    public void removeAll() {
        new taskRemove().execute();
    }
    public LiveData<List<DBEntryStructure>> getAllentries() {
//        new taskget().execute();
//        return null;
        return dbAllactions.getAllnotes();
    }
    public DBEntryStructure getEntrybyPositon(int pos){
        return  dbAllactions.getNoteByPosition(pos);
    }


    private class taskInsert extends AsyncTask<DBEntryStructure, Void, Void> {
        @Override
        protected Void doInBackground(DBEntryStructure... entry) {
            dbAllactions.insertAllAtEnd(entry);

            return null;
        }
    }
    private class taskRemove extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void...Voids) {
            dbAllactions.removeAllNotes();
            return null;
        }
    }

//    WARNING:DONOT DO GETALLENTRIES OPERATION IN ASYNCTASK. this is because everytime the activity
// starts,the recycle view will call the getall entries method which should return something and not null
// and look at the code we are doing: calling an asynctask on one side and returning null on the next
// what actually will happen is the moment getallentries() is called , null will get returned while
// asynctask is gone out in the woods collecting list<entries> from the database.Asynctask is cool
// for statements like insert or remove which are like "bah...dude i don't give much shit about this,
// just do this addition or removal in the background and remind me when its done"
    private class taskget extends AsyncTask<Void,Void,LiveData<List<DBEntryStructure>>> {
        @Override
        protected LiveData<List<DBEntryStructure>> doInBackground(Void... voids) {
            //although getting is a fast operation,therefore no need for async task

            return dbAllactions.getAllnotes();
        }


    }

}

