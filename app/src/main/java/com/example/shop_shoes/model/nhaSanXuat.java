package com.example.shop_shoes.model;

public class nhaSanXuat {
    private int nsx_ma;
    private String nsx_ten;
    private String nsx_mota;

    public nhaSanXuat(int nsx_ma, String nsx_ten, String nsx_mota) {
        this.nsx_ma = nsx_ma;
        this.nsx_ten = nsx_ten;
        this.nsx_mota = nsx_mota;
    }

    public int getNsx_ma() {
        return nsx_ma;
    }

    public void setNsx_ma(int nsx_ma) {
        this.nsx_ma = nsx_ma;
    }

    public String getNsx_ten() {
        return nsx_ten;
    }

    public void setNsx_ten(String nsx_ten) {
        this.nsx_ten = nsx_ten;
    }

    public String getNsx_mota() {
        return nsx_mota;
    }

    public void setNsx_mota(String nsx_mota) {
        this.nsx_mota = nsx_mota;
    }
}
