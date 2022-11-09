package com.example.kienddtph24848_mob2041.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.kienddtph24848_mob2041.database.Dbheper;

public class ThuThuDAO {
    Dbheper dbheper;
    public ThuThuDAO(Context context){
        dbheper = new Dbheper(context);
    }
    public boolean checkLogin(String matt,String pass){
        SQLiteDatabase sqLiteDatabase = dbheper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM THUTHU WHERE MATHUTHU = ? AND PASS = ?",new String[]{matt,pass});
        if(cursor.getCount() !=0){
            return true;
        }else{
            return false;
        }
    }

}
