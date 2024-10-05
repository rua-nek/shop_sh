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
import com.example.shop_shoes.model.nhaSanXuat;

public class updateNhaSanXuatActivity extends AppCompatActivity {
    EditText edtNsx_ten, edtNsx_mota;
    nhaSanXuatDao nhaSanXuatDao;
    Button btnUpdateNsx, btnCancel;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_nha_san_xuat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nhaSanXuatDao = new nhaSanXuatDao(this);
        edtNsx_ten = findViewById(R.id.edtNsx_ten);
        edtNsx_mota = findViewById(R.id.edtNsx_mota);
        btnUpdateNsx = findViewById(R.id.btnUpdateNsx);
        btnCancel = findViewById(R.id.btnCancel);
        id = getIntent().getIntExtra("nsx_id", 0);
        nhaSanXuat nhaSanXuat = nhaSanXuatDao.getNhaSanXuatById(id);

        if (nhaSanXuat != null) {
            edtNsx_ten.setText(nhaSanXuat.getNsx_ten());
            edtNsx_mota.setText(nhaSanXuat.getNsx_mota());
        }

        btnUpdateNsx.setOnClickListener(v -> {
            updateNhaSanXuat();
            setResult(RESULT_OK);
            finish();
        });
        btnCancel.setOnClickListener(v -> {
            finish();
        });

    }


    public void cancel() {
        finish();
    }

    public void updateNhaSanXuat() {
        String ten = edtNsx_ten.getText().toString();
        String mota = edtNsx_mota.getText().toString();
        nhaSanXuatDao.updateNhaSanXuat(id, ten, mota);
    }
}