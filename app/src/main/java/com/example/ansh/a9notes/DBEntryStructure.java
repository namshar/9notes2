package com.example.ansh.a9notes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ansh on 19/12/17.
 */

@Entity(tableName = "AllnotesTable")
public class DBEntryStructure {

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "position")
    int pos;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "data")
    String data;

    public DBEntryStructure() {
    }

    public DBEntryStructure(int pos, String title, String data) {
        this.pos = pos;
        this.title = title;
        this.data = data;
    }

    public int getPos() {
        return pos;
    }
    public String getTitle() {
        return title;
    }
    public String getData() {
        return data;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DBEntryStructure{" +
                "pos=" + pos +
                ", title='" + title + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
