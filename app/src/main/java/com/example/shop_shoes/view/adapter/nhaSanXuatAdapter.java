package com.example.shop_shoes.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.shop_shoes.R;
import com.example.shop_shoes.model.nhaSanXuat;

import java.util.ArrayList;

public class nhaSanXuatAdapter extends ArrayAdapter<nhaSanXuat> {
    private Context context;
    private int resource;
    private ArrayList<nhaSanXuat> data;
    private OnButtonClickListener buttonClickListener;

    public nhaSanXuatAdapter(Context context, int resource, ArrayList<nhaSanXuat> data, OnButtonClickListener buttonClickListener) {
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

        // Cập nhật nội dung của các phần tử trong danh sách
        TextView txtTen = convertView.findViewById(R.id.txtNsx_Ten);
        TextView txtMota = convertView.findViewById(R.id.txtNsx_mota);
        Button btnDelete = convertView.findViewById(R.id.btnDeleteNsx);
        Button btnUpdate = convertView.findViewById(R.id.btnUpdateNsx);

        nhaSanXuat nhaSanXuat = data.get(position);
        txtTen.setText(nhaSanXuat.getNsx_ten());
        txtMota.setText(nhaSanXuat.getNsx_mota());

        // Xử lý sự kiện click nút Delete
        btnDelete.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onDeleteClickNsx(nhaSanXuat.getNsx_ma());
            }
        });

        // Xử lý sự kiện click nút Update
        btnUpdate.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onUpdateClickNsx(nhaSanXuat.getNsx_ma());
            }
        });

        return convertView;
    }

    public interface OnButtonClickListener {
        void onDeleteClickNsx(int id);
        void onUpdateClickNsx(int id);
    }
}
