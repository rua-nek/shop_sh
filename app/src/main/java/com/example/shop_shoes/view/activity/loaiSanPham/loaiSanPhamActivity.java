package com.example.shop_shoes.view.activity.loaiSanPham;

import android.app.Activity;
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
import com.example.shop_shoes.database.Dao.loaiSanPhamDao;
import com.example.shop_shoes.model.loaiSanPham;
import com.example.shop_shoes.view.adapter.loaiSanPhamAdapter;

import java.util.ArrayList;

public class loaiSanPhamActivity extends AppCompatActivity implements loaiSanPhamAdapter.OnButtonClickListener {
    private static final int REQUEST_CODE_ADD_LOAI_SAN_PHAM = 1;
    private static final int REQUEST_CODE_UPDATE_LOAI_SAN_PHAM = 2;
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
        btnAdd = findViewById(R.id.btnUpdate);
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
        if (requestCode == REQUEST_CODE_UPDATE_LOAI_SAN_PHAM && resultCode == Activity.RESULT_OK) {
            loadData(); // Tải lại dữ liệu sau khi có thay đổi
        }
        if (requestCode == REQUEST_CODE_ADD_LOAI_SAN_PHAM && resultCode == Activity.RESULT_OK) {
            loadData(); // Tải lại dữ liệu sau khi có thay đổi
        }
    }


    @Override
    public void onDeleteClick(int id) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc chắn muốn xóa loại sản phẩm này không?")
                .setPositiveButton("Có", (dialog, which) -> {
                    dao.deleteLoaiSanPham(id);
                    loadData(); // Tải lại dữ liệu sau khi xóa
                })
                .setNegativeButton("Không", (dialog, which) -> {
                    dialog.dismiss(); // Đóng hộp thoại nếu người dùng nhấn "Không"
                })
                .show();
    }


    @Override
    public void onUpdateClick(int id) {
        Intent intent = new Intent(this, updateLoaiSanPhamActivity.class);
        intent.putExtra("id", id);
        startActivityForResult(intent, REQUEST_CODE_UPDATE_LOAI_SAN_PHAM); // Đảm bảo sử dụng startActivityForResult
    }

}
