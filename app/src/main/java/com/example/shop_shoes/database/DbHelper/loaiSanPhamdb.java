package com.example.shop_shoes.database.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class loaiSanPhamdb extends SQLiteOpenHelper {
    public loaiSanPhamdb(Context context) {
        super(context, "shop_shoes.db", null, 1);

    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        db.execSQL("CREATE TABLE loaiSanPham(lsp_ma INTEGER PRIMARY KEY AUTOINCREMENT, lsp_ten TEXT,lsp_mota TEXT, lsp_danhcho TEXT)");
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS loaiSanPham");
        onCreate(db);
    }
}
