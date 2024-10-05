package com.example.shop_shoes.view.activity.danhCho;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.database.Dao.danhChoDao;
import com.example.shop_shoes.model.danhCho;

public class addDanhChoActivity extends AppCompatActivity {
    Button btnAddDch, btnCancel;
    EditText edtTenDch, edtDchMota;
    danhChoDao dao = new danhChoDao(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_danh_cho);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAddDch = findViewById(R.id.btnAddDch);
        btnCancel = findViewById(R.id.btnCancel);
        edtTenDch = findViewById(R.id.edtDchten);
        edtDchMota = findViewById(R.id.edtDchmota);
        btnAddDch.setOnClickListener(v -> {
            addDanhCho();
            setResult(RESULT_OK);
            finish();

        });
        btnCancel.setOnClickListener(v -> {
            finish();
        });


    }
    public void addDanhCho() {
        String ten = edtTenDch.getText().toString();
        String mota = edtDchMota.getText().toString();
        dao.addDanhCho(ten, mota);
    }
}