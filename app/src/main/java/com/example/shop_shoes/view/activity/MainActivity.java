package com.example.shop_shoes.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.view.activity.danhCho.danhChoActivity;
import com.example.shop_shoes.view.activity.loaiSanPham.loaiSanPhamActivity;
import com.example.shop_shoes.view.activity.nhaSanXuat.nhaSanXuatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLsp, btnNsx, btnDch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnLsp = findViewById(R.id.btnLsp);
        btnNsx = findViewById(R.id.btnNsx);
        btnDch = findViewById(R.id.btnDch);
        btnLsp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, loaiSanPhamActivity.class);
            startActivity(intent);
        });
        btnNsx.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, nhaSanXuatActivity.class);
            startActivity(intent);
        });
        btnDch.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, danhChoActivity.class);
            startActivity(intent);
        });

    }
}