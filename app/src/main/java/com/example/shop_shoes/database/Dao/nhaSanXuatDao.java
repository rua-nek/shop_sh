package com.example.shop_shoes.database.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.shop_shoes.database.DbHelper.dbHelper;
import com.example.shop_shoes.model.nhaSanXuat;

import java.util.ArrayList;

public class nhaSanXuatDao{
    private dbHelper nhaSanXuatdb;

    public nhaSanXuatDao(Context context) {
        nhaSanXuatdb = new dbHelper(context);
    }

    public nhaSanXuat getNhaSanXuatById(int nsx_ma) {
        nhaSanXuat nhaSanXuat = null;
        String sql = "SELECT * FROM nhaSanXuat WHERE nsx_ma = ?";
        android.database.Cursor cursor = nhaSanXuatdb.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(nsx_ma)});
        try {
            if (cursor.moveToFirst()) {
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String mota = cursor.getString(2);
                nhaSanXuat = new nhaSanXuat(id, ten, mota);
            }
        } finally {
            cursor.close();
        }
        return nhaSanXuat;
    }

    public void addNhaSanXuat(String nsx_ten, String nsx_mota) {
        nhaSanXuatdb.getWritableDatabase();
        String sql = "INSERT INTO nhaSanXuat (nsx_ten, nsx_mota) VALUES (?, ?)";
        Object[] args = {nsx_ten, nsx_mota};
        nhaSanXuatdb.getWritableDatabase().execSQL(sql, args);
    }

    public void deleteNhaSanXuat(int nsx_ma) {
        nhaSanXuatdb.getWritableDatabase();
        String sql = "DELETE FROM nhaSanXuat WHERE nsx_ma = ?";
        Object[] args = {nsx_ma};
        nhaSanXuatdb.getWritableDatabase().execSQL(sql, args);
    }

    public void updateNhaSanXuat(int nsx_ma, String nsx_ten, String nsx_mota) {
        nhaSanXuatdb.getWritableDatabase();
        String sql = "UPDATE nhaSanXuat SET nsx_ten = ?, nsx_mota = ? WHERE nsx_ma = ?";
        Object[] args = {nsx_ten, nsx_mota, nsx_ma};
        nhaSanXuatdb.getWritableDatabase().execSQL(sql, args);
    }

    public ArrayList<nhaSanXuat> getAllNhaSanXuat() {
        ArrayList<nhaSanXuat> nhaSanXuatList = new ArrayList<>();
        String sql = "SELECT * FROM nhaSanXuat";
        android.database.Cursor cursor = nhaSanXuatdb.getReadableDatabase().rawQuery(sql, null);
        try {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String mota = cursor.getString(2);
                nhaSanXuat nhaSanXuat = new nhaSanXuat(id, ten, mota);
                nhaSanXuatList.add(nhaSanXuat);
            }
        } finally {
            cursor.close();
        }
        return nhaSanXuatList;
    }
}
