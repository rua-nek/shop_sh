package com.example.shop_shoes.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.shop_shoes.R;
import com.example.shop_shoes.model.danhCho;

import java.util.ArrayList;

public class danhChoAdapter extends ArrayAdapter<danhCho> {
    private Context context;
    private int resource;
    private ArrayList<danhCho> data;
    private OnButtonClickListener buttonClickListener;

    public interface OnButtonClickListener {
        void onDeleteClickDch(int id);
        void onUpdateClickDch(int id);
    }

    public danhChoAdapter(Context context, int resource, ArrayList<danhCho> data, OnButtonClickListener buttonClickListener) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
        this.buttonClickListener = buttonClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        // Ánh xạ các thành phần giao diện
        TextView txtTenDch = convertView.findViewById(R.id.txtDch_Ten);
        TextView txtMotaDch = convertView.findViewById(R.id.txtDch_Mota);
        Button btnDelete = convertView.findViewById(R.id.btnDeleteDch);
        Button btnUpdate = convertView.findViewById(R.id.btnUpdateDch);

        // Lấy dữ liệu từ danh sách
        danhCho danhChoItem = data.get(position);
        txtTenDch.setText(danhChoItem.getDch_ten());
        txtMotaDch.setText(danhChoItem.getDch_mota());

        // Xử lý sự kiện click nút Delete
        btnDelete.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onDeleteClickDch(danhChoItem.getDch_ma());
            }
        });

        // Xử lý sự kiện click nút Update
        btnUpdate.setOnClickListener(v -> {
            if (buttonClickListener != null) {
                buttonClickListener.onUpdateClickDch(danhChoItem.getDch_ma());
            }
        });

        return convertView;
    }
}
