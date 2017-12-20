package com.example.ansh.a9notes;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ansh on 19/12/17.
 */

@Database(entities = DBEntryStructure.class , version = 1)
public abstract class AppDB extends RoomDatabase {
    //abstract mean this class will not have a constructor but this class can be extended to other classes
    // @entity: a class that gives info about the structure of data to be stored: the variables and their datatypes
    //          however its name is the same as table name(^^^)
    //@dao(data access objects): an *interface* that gives the info about the methods that can be used with the database
    //this database class extending RoomDatabase:it acts as a linker to table and database.
    //          it makes an abstract object of tabledao interface, thus linking database to tablefunctions which
    //          are itself linking to allnotes.table(SELECT * from Allnotes,etc),therby linking table to db.
    //          now this class is needed to be used by other classesto actually erform some task



    public  abstract DBMethodsDAO allActions();


}
/*  MISC:NAMING CONVENTIONS
* - data.java : works as a class 1)defining structure of data 2)defining column names 3) defining
*               table names . :. classname=DBEntryStructure.java BUT entity(tablename= "AllNotes"+"table"
*               i.e,
*                @Entity(tableName = "AllnotesTable")
*                public class DBEntryStructure {
*                    ...
*                    ...
*                    }
* - DAO(functions waala interface) : works as an interface providing functions for the class. :.
*                @Dao public interface "AllNotes"+TableFunctions {...}
* - Database : AppDB because this shows puri app ke liye ek hi db banega BUT iska object "ALLnotes.db
*              ke name se banaege
*
* */
