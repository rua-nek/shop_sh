package com.example.shop_shoes.database.Dao;

import android.content.Context;

import com.example.shop_shoes.database.DbHelper.loaiSanPhamdb;
import com.example.shop_shoes.model.loaiSanPham;

import java.util.ArrayList;

public class loaiSanPhamDao {
    private loaiSanPhamdb loaiSanPhamdb;

    public loaiSanPhamDao(Context context) {
        loaiSanPhamdb = new loaiSanPhamdb(context);
    }

    public void addLoaiSanPham(String lsp_ten, String lsp_mota, String lsp_danhcho) {
        loaiSanPhamdb.getWritableDatabase();
        String sql = "INSERT INTO loaiSanPham (lsp_ten, lsp_mota, lsp_danhcho) VALUES (?, ?, ?)";
        Object[] args = {lsp_ten, lsp_mota, lsp_danhcho};
        loaiSanPhamdb.getWritableDatabase().execSQL(sql, args);
    }
    public void deleteLoaiSanPham(int lsp_ma) {
        loaiSanPhamdb.getWritableDatabase();
        String sql = "DELETE FROM loaiSanPham WHERE lsp_ma = ?";
        Object[] args = {lsp_ma};
        loaiSanPhamdb.getWritableDatabase().execSQL(sql, args);
    }
    public void updateLoaiSanPham(int lsp_ma, String lsp_ten, String lsp_mota, String lsp_danhcho) {
        loaiSanPhamdb.getWritableDatabase();
        String sql = "UPDATE loaiSanPham SET lsp_ten = ?, lsp_mota = ?, lsp_danhcho = ? WHERE lsp_ma = ?";
        Object[] args = {lsp_ten, lsp_mota, lsp_danhcho, lsp_ma};
        loaiSanPhamdb.getWritableDatabase().execSQL(sql, args);
    }

    public ArrayList<loaiSanPham> getAllLoaiSanPham() {
        ArrayList<loaiSanPham> data = new ArrayList<>();
        String sql = "SELECT * FROM loaiSanPham";
        android.database.Cursor cursor = loaiSanPhamdb.getReadableDatabase().rawQuery(sql, null);
        try {
            while (cursor.moveToNext()) {
                loaiSanPham loaiSanPham = new loaiSanPham();
                loaiSanPham.setLsp_ma(cursor.getInt(0));
                loaiSanPham.setLsp_ten(cursor.getString(1));
                loaiSanPham.setLsp_mota(cursor.getString(2));
                loaiSanPham.setLsp_danhcho(cursor.getString(3));
                data.add(loaiSanPham);
            }
        } finally {
            cursor.close();
        }
        return data;
    }}
