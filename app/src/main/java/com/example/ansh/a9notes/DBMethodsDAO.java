package com.example.ansh.a9notes;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ansh on 19/12/17.
 */

@Dao
public interface DBMethodsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DBEntryStructure e);


    @Query("DELETE FROM AllnotesTable")
    void removeAllNotes();

    @Query("DELETE FROM AllnotesTable  WHERE position = :i")
    void removeNote(int i);


    @Query("SELECT * FROM AllnotesTable ")
    List<DBEntryStructure> getAllnotes();

    @Query("SELECT * FROM AllnotesTable WHERE position = :i ")
    DBEntryStructure getNote(int i);

}
