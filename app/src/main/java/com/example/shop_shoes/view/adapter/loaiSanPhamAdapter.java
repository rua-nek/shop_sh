package com.example.shop_shoes.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shop_shoes.R;
import com.example.shop_shoes.model.loaiSanPham;

import java.util.ArrayList;

public class loaiSanPhamAdapter extends ArrayAdapter<loaiSanPham> {
    private Context context;
    private int resource;
    private ArrayList<loaiSanPham> data;
    private OnButtonClickListener buttonClickListener;

    // Tạo interface
    public interface OnButtonClickListener {
        void onDeleteClickLsp(int id);
        void onUpdateClickLsp(int id);
    }

    public loaiSanPhamAdapter(Context context, int resource, ArrayList<loaiSanPham> data, OnButtonClickListener buttonClickListener) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.buttonClickListener = buttonClickListener; // Lưu listener
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TextView txtTen = convertView.findViewById(R.id.txtlsp_Ten);
        TextView txtMoTa = convertView.findViewById(R.id.txtlsp_Mota);
        Button btnDelete = convertView.findViewById(R.id.btnDeleteLsp);
        Button btnUpdate = convertView.findViewById(R.id.btnUpdateLsp); // Giả sử bạn đã thêm nút Update vào layout

        loaiSanPham loaiSanPham = data.get(position);
        txtTen.setText(loaiSanPham.getLsp_ten());
        txtMoTa.setText(loaiSanPham.getLsp_mota());

        // Xử lý sự kiện click nút Delete
        btnDelete.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onDeleteClickLsp(loaiSanPham.getLsp_ma());
            }
        });

        // Xử lý sự kiện click nút Update
        btnUpdate.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onUpdateClickLsp(loaiSanPham.getLsp_ma());
            }
        });

        return convertView;
    }
}
