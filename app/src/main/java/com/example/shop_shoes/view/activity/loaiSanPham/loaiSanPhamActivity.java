package com.example.shop_shoes.view.activity.loaiSanPham;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.controller.loaiSanPhamCtrl;
import com.example.shop_shoes.database.Dao.loaiSanPhamDao;
import com.example.shop_shoes.model.loaiSanPham;
import com.example.shop_shoes.view.adapter.loaiSanPhamAdapter;

import java.util.ArrayList;

public class loaiSanPhamActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD_LOAI_SAN_PHAM = 1;
    loaiSanPhamCtrl ctrl = new loaiSanPhamCtrl();
    loaiSanPhamAdapter adapter;
    loaiSanPhamDao dao = new loaiSanPhamDao(this);
    Button btnAdd;
    ListView lvLsp;
    ArrayList<loaiSanPham> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loai_san_pham);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAdd = findViewById(R.id.btnAdd);
        lvLsp = findViewById(R.id.lvLoaiSanPham);
        data = dao.getAllLoaiSanPham();
        adapter = new loaiSanPhamAdapter(this, R.layout.layout_list_lsp, data);
        lvLsp.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            ctrl.handleClick("add", this);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Intent intent = new Intent(this, loaiSanPhamActivity.class);
            startActivity(intent);
            finish();
        }
    }
}