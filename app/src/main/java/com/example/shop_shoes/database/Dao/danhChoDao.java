package com.example.shop_shoes.database.Dao;

import android.content.Context;

import com.example.shop_shoes.database.DbHelper.dbHelper;
import com.example.shop_shoes.model.danhCho;

import java.util.ArrayList;

public class danhChoDao {
    private dbHelper danhChodb;

    public danhChoDao(Context context) {
        danhChodb = new dbHelper(context);
    }

    public danhCho getDanhChoById(int dch_ma) {
        danhCho danhCho = null;
        String sql = "SELECT * FROM danhCho WHERE dch_ma = ?";
        android.database.Cursor cursor = danhChodb.getReadableDatabase().rawQuery(sql, new String[]{String.valueOf(dch_ma)});
        try {
            if (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String dch_ten = cursor.getString(1);
                String dch_mota = cursor.getString(2);
                danhCho = new danhCho(id, dch_ten, dch_mota);
            }
        } finally {
            cursor.close();
        }
        return danhCho;
    }


    public void addDanhCho(String dch_ten, String dch_mota) {
        danhChodb.getWritableDatabase();
        String sql = "INSERT INTO danhCho (dch_ten, dch_mota) VALUES (?, ?)";
        Object[] args = {dch_ten, dch_mota};
        danhChodb.getWritableDatabase().execSQL(sql, args);
    }

    public void deleteDanhCho(int dch_ma) {
        danhChodb.getWritableDatabase();
        String sql = "DELETE FROM danhCho WHERE dch_ma = ?";
        Object[] args = {dch_ma};
        danhChodb.getWritableDatabase().execSQL(sql, args);
    }

    public void updateDanhCho(int dch_ma, String dch_ten, String dch_mota) {
        danhChodb.getWritableDatabase();
        String sql = "UPDATE danhCho SET dch_ten = ?, dch_mota = ? WHERE dch_ma = ?";
        Object[] args = {dch_ten, dch_mota, dch_ma};
        danhChodb.getWritableDatabase().execSQL(sql, args);
    }

    public ArrayList<danhCho> getAllDanhCho() {
        ArrayList<danhCho> danhChoList = new ArrayList<>();
        String sql = "SELECT * FROM danhCho";
        android.database.Cursor cursor = danhChodb.getReadableDatabase().rawQuery(sql, null);
        try {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String ten = cursor.getString(1);
                String mota = cursor.getString(2);
                danhCho danhCho = new danhCho(id, ten, mota);
                danhChoList.add(danhCho);
            }
        } finally {
            cursor.close();
        }
        return danhChoList;
    }
}
