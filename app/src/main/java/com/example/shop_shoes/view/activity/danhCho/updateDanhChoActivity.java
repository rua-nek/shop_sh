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

public class updateDanhChoActivity extends AppCompatActivity {
    int id;
    EditText edtTenDch, edtDchMota;
    danhChoDao dao = new danhChoDao(this);
    Button btnUpdateDch, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_danh_cho);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        btnUpdateDch = findViewById(R.id.btnUpdateDch);
        btnCancel = findViewById(R.id.btnCancel);
        edtTenDch = findViewById(R.id.edtDch_ten);
        edtDchMota = findViewById(R.id.edtDch_mota);

        id = getIntent().getIntExtra("dch_id", 0);
        danhCho dch = dao.getDanhChoById(id);
        edtTenDch.setText(dch.getDch_ten());
        edtDchMota.setText(dch.getDch_mota());
        btnCancel.setOnClickListener(v -> {
            finish();
        });
        btnUpdateDch.setOnClickListener(v -> {
            updateDanhCho();
            setResult(RESULT_OK);
            finish();
        });
    }

    public void updateDanhCho() {
        String ten = edtTenDch.getText().toString();
        String mota = edtDchMota.getText().toString();
        dao.updateDanhCho(id, ten, mota);
    }
}