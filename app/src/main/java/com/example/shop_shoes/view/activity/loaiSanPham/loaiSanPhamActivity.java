package com.example.shop_shoes.view.activity.loaiSanPham;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.database.Dao.loaiSanPhamDao;
import com.example.shop_shoes.model.loaiSanPham;
import com.example.shop_shoes.view.adapter.loaiSanPhamAdapter;

import java.util.ArrayList;

public class loaiSanPhamActivity extends AppCompatActivity implements loaiSanPhamAdapter.OnButtonClickListener {
    private static final int REQUEST_CODE_ADD_LOAI_SAN_PHAM = 1;
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
        loadData(); // Tải dữ liệu từ cơ sở dữ liệu

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, addLoaiSanPhamActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_LOAI_SAN_PHAM);
        });
    }

    private void loadData() {
        data = dao.getAllLoaiSanPham();
        adapter = new loaiSanPhamAdapter(this, R.layout.layout_list_lsp, data, this);
        lvLsp.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_LOAI_SAN_PHAM && resultCode == Activity.RESULT_OK) {
            loadData(); // Tải lại dữ liệu sau khi thêm mới
        }
    }

    @Override
    public void onDeleteClick(int id) {
        dao.deleteLoaiSanPham(id);
        loadData(); // Tải lại dữ liệu sau khi xóa
    }

    @Override
    public void onUpdateClick(int id) {
        // Xử lý ID nhận được từ adapter cho nút Update
        Toast.makeText(this, "Cập nhật ID: " + id, Toast.LENGTH_SHORT).show();
        // Bạn có thể mở một Activity để thực hiện cập nhật
    }
}
