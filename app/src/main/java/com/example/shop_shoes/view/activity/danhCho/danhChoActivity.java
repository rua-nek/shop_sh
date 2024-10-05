package com.example.shop_shoes.view.activity.danhCho;

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
import com.example.shop_shoes.database.Dao.danhChoDao;
import com.example.shop_shoes.model.danhCho;
import com.example.shop_shoes.view.adapter.danhChoAdapter;

import java.util.ArrayList;

public class danhChoActivity extends AppCompatActivity implements danhChoAdapter.OnButtonClickListener {
    private static final int REQUEST_CODE_ADD_DCH = 1;
    private static final int REQUEST_CODE_UPDATE_DCH = 2;
    Button btnAddDch;
    danhChoAdapter adapter;
    ArrayList<danhCho> data;
    ListView lvDch;
    danhChoDao dao = new danhChoDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_cho);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lvDch = findViewById(R.id.lvDanhcho);
        btnAddDch = findViewById(R.id.btnAddDch);
        LoadData();
        btnAddDch.setOnClickListener(v -> {
            Intent intent = new Intent(this, addDanhChoActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_DCH);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_DCH || requestCode == REQUEST_CODE_UPDATE_DCH) {
            if (resultCode == RESULT_OK) {
                LoadData();
            }
        }
    }
    private void LoadData() {
        data = dao.getAllDanhCho();
        adapter = new danhChoAdapter(this, R.layout.layout_list_dch, data, this);
        lvDch.setAdapter(adapter);
    }
    @Override
    public void onDeleteClickDch(int id) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc muốn xóa đối tượng này?")
                .setPositiveButton("Có", (dialog, which) -> {
                    dao.deleteDanhCho(id);
                    LoadData();
                })
                .setNegativeButton("Không", null)
                .show();
    }

    @Override
    public void onUpdateClickDch(int id) {
        Intent intent = new Intent(this, updateDanhChoActivity.class);
        intent.putExtra("dch_id", id);
        startActivityForResult(intent, REQUEST_CODE_UPDATE_DCH);
    }

}