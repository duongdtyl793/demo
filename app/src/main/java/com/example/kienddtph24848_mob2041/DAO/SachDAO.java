package com.example.kienddtph24848_mob2041.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kienddtph24848_mob2041.MODEL.Sach;
import com.example.kienddtph24848_mob2041.database.Dbheper;

import java.util.ArrayList;

public class SachDAO {
    Dbheper dbheper;
    public SachDAO(Context context){
        dbheper = new Dbheper(context);

    }
    public ArrayList<Sach> getDSdausach(){
      ArrayList<Sach> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbheper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT* FROM SACH",null);
        if(cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new Sach(cursor.getInt(0),cursor.getString(1),cursor.getInt(3)));
            }while (cursor.moveToNext());

        }

      return list;
    }
}
