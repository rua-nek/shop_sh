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

public class addLoaiSanPhamActivity extends AppCompatActivity {
    Button btnAdd, btnCancel;
    loaiSanPhamDao dao = new loaiSanPhamDao(this);
    EditText edtlsp_ten, edtlsp_mota, edtlsp_danhcho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_loai_san_pham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);
        edtlsp_ten = findViewById(R.id.edtlsp_ten);
        edtlsp_mota = findViewById(R.id.edtlsp_mota);
        edtlsp_danhcho = findViewById(R.id.edtlsp_danhcho);
        btnAdd.setOnClickListener(v -> {
            addLoaiSanPham();
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        });
        btnCancel.setOnClickListener(v -> {
            cancel();
        });
    }

    public void addLoaiSanPham() {
        String ten = edtlsp_ten.getText().toString();
        String mota = edtlsp_mota.getText().toString();
        String danhcho = edtlsp_danhcho.getText().toString();
        dao.addLoaiSanPham(ten, mota, danhcho);
    }

    public void cancel() {
        finish();
    }
}