package com.example.shop_shoes.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.shop_shoes.R;
import com.example.shop_shoes.model.loaiSanPham;

import java.util.ArrayList;

public class loaiSanPhamAdapter extends ArrayAdapter<loaiSanPham> {
    private Context context;
    private int resource;
    private ArrayList<loaiSanPham> data;
    public loaiSanPhamAdapter(Context context, int resource, ArrayList<loaiSanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        TextView txtTen = view.findViewById(R.id.txtlsp_Ten);
        TextView txtMoTa = view.findViewById(R.id.txtlsp_Mota);
        TextView txtDanhCho = view.findViewById(R.id.txtlsp_Danhcho);
        loaiSanPham loaiSanPham = data.get(position);
        txtTen.setText(loaiSanPham.getLsp_ten());
        txtMoTa.setText(loaiSanPham.getLsp_mota());
        txtDanhCho.setText(loaiSanPham.getLsp_danhcho());
        return view;
    }


}
