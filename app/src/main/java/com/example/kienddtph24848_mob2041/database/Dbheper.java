package com.example.kienddtph24848_mob2041.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbheper extends SQLiteOpenHelper {
    public Dbheper( Context context) {
        super(context, "DANGKIMUONSACH", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String dbThuThu = "CREATE TABLE THUTHU(MATHUTHU TEXT PRIMARY KEY, NAME TEXT,PASS TEXT)";
        db.execSQL(dbThuThu);
        String dbThanhVien = "CREATE TABLE THANHVIEN(MATHANHVIEN INTEGER PRIMARY KEY AUTOINCREMENT ,NAME TEXT, NAMSINH TEXT)";
        db.execSQL(dbThanhVien);
        String dbLoaiSach = "CREATE TABLE LOAISACH(MALOAI INTEGER PRIMARY KEY AUTOINCREMENT , TENLOAI TEXT )";
        db.execSQL(dbLoaiSach);
        String dbSach = "CREATE TABLE SACH(MASACH INTEGER PRIMARY KEY AUTOINCREMENT ,TENSACH TEXT,GIATHUE INTEGER,MALOAI INTEGER REFERENCES LOAISACH(MALOAI))";
        db.execSQL(dbSach);
        String dbPhieuMuon = "CREATE TABLE PHIEUMUON(MAPHIEUMUON INTEGER PRIMARY KEY AUTOINCREMENT, MATHANHVIEN INTEGER REFERENCES THANHVIEN(MATHANHVIEN),MATHUTHU TEXT REFERENCES THUTHU(MATHUTHU),MASACH INTEGER REFERENCES SACH(MASACH),NGAY TEXT, TRASACH INTEGER,TIENTHUE INTEGER)";
        db.execSQL(dbPhieuMuon);

        //insert
        db.execSQL("INSERT INTO LOAISACH VALUES (1, 'Truyện Tranh'),(2,'Nấu Ăn'),(3, 'Giáo khoa')");
        db.execSQL("INSERT INTO SACH VALUES (1, 'Doraemon', 2500, 1), (2, 'Dế Mèn Phưu Lưa Kí', 1000, 1), (3, 'Lập trình Android', 2000, 3)");
        db.execSQL("INSERT INTO THUTHU VALUES ('admin','Dương Trung Kiên','1234')");
        db.execSQL("INSERT INTO THANHVIEN VALUES (1,'Hà Minh Chiến','2003'),(2,'Trần Trung Quân','2001')");
        db.execSQL("INSERT INTO PHIEUMUON VALUES (1,1,'admin', 1, '19/10/2022', 1, 2500),(2,1,'admin', 3, '19/09/2022', 0, 2000),(3,2,'admin', 1, '16/10/2022', 1, 2000)");

        //nối bảng
        db.execSQL("SELECT pm.maphieumuon , pm.mathanhvien, tv.name, pm.mathuthu, tt.name, pm.masach ,sc.tensach,pm.ngay,pm.trasach,pm.ti\n" +
                "from PHIEUMUON pm,THANHVIEN tv,THUTHU tt,SACH sc \n" +
                "WHERE pm.mathanhvien = tv.mathanhvien AND pm.mathuthu = tt.mathuthu AND pm.masach = sc.masach");
        db.execSQL("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS THUTHU");
            db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            db.execSQL("DROP TABLE IF EXISTS LOAISACH");
            db.execSQL("DROP TABLE IF EXISTS SACH");
            db.execSQL("DROP TABLE IF EXISTS PHIEUMUON");
            onCreate(db);
        }
    }
}
