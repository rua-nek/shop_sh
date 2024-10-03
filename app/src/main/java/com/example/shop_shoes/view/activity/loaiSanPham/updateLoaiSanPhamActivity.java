package com.example.shop_shoes.view.activity.loaiSanPham;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.database.Dao.loaiSanPhamDao;
import com.example.shop_shoes.model.loaiSanPham;

import java.util.ArrayList;

public class updateLoaiSanPhamActivity extends AppCompatActivity {
    EditText edtlsp_ten, edtlsp_mota;
    Button btnUpdate, btnCancel;
    loaiSanPhamDao dao;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_loai_san_pham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dao = new loaiSanPhamDao(this);
        edtlsp_ten = findViewById(R.id.edtlsp_ten);
        edtlsp_mota = findViewById(R.id.edtlsp_mota);
        btnUpdate = findViewById(R.id.btnUpdatelsp);
        btnCancel = findViewById(R.id.btnCancel);
        id = getIntent().getIntExtra("id", 0);

        // Gọi phương thức để lấy loại sản phẩm dựa trên ID
        loaiSanPhamDao dao = new loaiSanPhamDao(this);
        loaiSanPham loaiSanPham = dao.getLoaiSanPhamById(id);

        if (loaiSanPham != null) {
            // Thiết lập văn bản cho EditText
            edtlsp_ten.setText(loaiSanPham.getLsp_ten());
            edtlsp_mota.setText(loaiSanPham.getLsp_mota());
        }
        btnCancel.setOnClickListener(v -> {
            finish();
        });
        btnUpdate.setOnClickListener(v -> {
            updateLoaiSanPham();
            setResult(RESULT_OK);
            finish();
        });
    }
    public void updateLoaiSanPham() {
        String ten = edtlsp_ten.getText().toString();
        String mota = edtlsp_mota.getText().toString();
        dao.updateLoaiSanPham(id, ten, mota);
    }


}