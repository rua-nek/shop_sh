package com.example.shop_shoes.database.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context) {
        super(context, "shop_shoes.db", null, 1);

    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        String sql = "CREATE TABLE loaiSanPham(lsp_ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                " lsp_ten TEXT," +
                "lsp_mota TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE hinhsanpham(hsp_ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                " hsp_ten TEXT," +
                " hsp_mota TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE nhasanxuat(nsx_ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nsx_ten TEXT," +
                " nsx_mota TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE danhcho(dch_ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                " dch_ten TEXT," +
                " dch_mota TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE sanpham(sp_ma INTEGER PRIMARY KEY AUTOINCREMENT," +
                " sp_ten TEXT," +
                " sp_mota TEXT," +
                " sp_giaban REAL," +
                " sp_gianhap REAL," +
                " sp_soluong INTEGER," +
                " lsp_ma INTEGER," +
                " nsx_ma INTEGER," +
                " dch_ma INTEGER," +
                " FOREIGN KEY(lsp_ma) REFERENCES loaiSanPham(lsp_ma)," +
                " FOREIGN KEY(nsx_ma) REFERENCES nhasanxuat(nsx_ma)," +
                " FOREIGN KEY(dch_ma) REFERENCES danhcho(dch_ma))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS loaiSanPham");
        onCreate(db);
    }
}
