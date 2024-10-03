package com.example.shop_shoes.controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Intent;

import com.example.shop_shoes.view.activity.loaiSanPham.addLoaiSanPhamActivity;

public class loaiSanPhamCtrl {
    public void handleClick(String action, android.content.Context context) {
        switch (action) {
            case "add":
                // Xử lý khi nhấn nút "Thêm"
                Intent intent = new Intent(context, addLoaiSanPhamActivity.class);
                ((Activity) context).startActivityForResult(intent, 1);
                break;
            case "edit":
                // Xử lý khi nhấn nút "Sửa"
                break;
            case "delete":
                // Xử lý khi nhấn nút "Xóa"
                break;
            case "search":
                // Xử lý khi nhấn nút "Tìm kiếm"
                break;
            case "cancel":
                // Xử lý khi nhấn nút "Hủy"
                break;
            default:
                // Xử lý khi không có hành động nào được chọn
                break;
        }
    }
}
