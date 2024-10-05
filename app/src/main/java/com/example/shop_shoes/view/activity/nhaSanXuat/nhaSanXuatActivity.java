package com.example.shop_shoes.view.activity.nhaSanXuat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop_shoes.R;
import com.example.shop_shoes.model.nhaSanXuat;
import com.example.shop_shoes.view.adapter.nhaSanXuatAdapter;
import com.example.shop_shoes.database.Dao.nhaSanXuatDao;

import java.util.ArrayList;

public class nhaSanXuatActivity extends AppCompatActivity implements nhaSanXuatAdapter.OnButtonClickListener {
    public static final int REQUEST_CODE_ADD_NSX = 1;
    public static final int REQUEST_CODE_UPDATE_NSX = 2;
    Button btnAdd;
    nhaSanXuatAdapter adapter;
    nhaSanXuatDao nhaSanXuatDao;
    ListView lvNsx;
    ArrayList<nhaSanXuat> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nha_san_xuat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvNsx = findViewById(R.id.lvnhaSanXuat);
        nhaSanXuatDao = new nhaSanXuatDao(this);
        loadData();

        btnAdd = findViewById(R.id.btnAddNsx);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, addNhaSanXuatActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_NSX);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_NSX || requestCode == REQUEST_CODE_UPDATE_NSX) {
            if (resultCode == RESULT_OK) {
                loadData();
            }
        }
    }

    private void loadData() {
        data = nhaSanXuatDao.getAllNhaSanXuat();
        adapter = new nhaSanXuatAdapter(this, R.layout.layout_list_nsx, data, this);
        lvNsx.setAdapter(adapter);
    }

    @Override
    public void onDeleteClickNsx(int id) {
        // Xử lý sự kiện xóa
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc muốn xóa nhà sản xuất này?")
                .setPositiveButton("Có", (dialog, which) -> {
                    // Gọi phương thức xóa từ nhaSanXuatDao
                    nhaSanXuatDao.deleteNhaSanXuat(id);
                    // Tải lại dữ liệu
                    loadData();
                })
                .setNegativeButton("Không", null)
                .show();
    }

    @Override
    public void onUpdateClickNsx(int id) {
        // Xử lý sự kiện cập nhật
        Intent intent = new Intent(this, updateNhaSanXuatActivity.class);
        intent.putExtra("nsx_id", id); // Truyền ID để cập nhật
        startActivityForResult(intent, REQUEST_CODE_UPDATE_NSX);
    }
}
