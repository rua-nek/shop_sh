package com.example.shop_shoes.view.activity.nhaSanXuat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.database.Dao.nhaSanXuatDao;

public class addNhaSanXuatActivity extends AppCompatActivity {
    Button btnAdd, btnCancel;
    nhaSanXuatDao nhaSanXuatDao;
    EditText edtNsx_ten, edtNsx_mota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_nha_san_xuat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nhaSanXuatDao = new nhaSanXuatDao(this);
        edtNsx_ten = findViewById(R.id.edtNsx_ten);
        edtNsx_mota = findViewById(R.id.edtNsx_mota);
        btnAdd = findViewById(R.id.btnAddNsx);
        btnAdd.setOnClickListener(v -> {
            addNhaSanXuat();
            setResult(RESULT_OK);
            finish();
        });
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(v -> {
            finish();
        });
    }

    private void addNhaSanXuat() {
        String ten = edtNsx_ten.getText().toString();
        String mota = edtNsx_mota.getText().toString();
        nhaSanXuatDao.addNhaSanXuat(ten, mota);

    }
}