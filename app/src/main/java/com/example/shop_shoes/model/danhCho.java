package com.example.shop_shoes.model;

public class danhCho {
    private int dch_ma;
    private String dch_ten;
    private String dch_mota;


    public danhCho(int dch_ma, String dch_ten, String dch_mota) {
        this.dch_ma = dch_ma;
        this.dch_ten = dch_ten;
        this.dch_mota = dch_mota;
    }

    public int getDch_ma() {
        return dch_ma;
    }

    public void setDch_ma(int dch_ma) {
        this.dch_ma = dch_ma;
    }

    public String getDch_ten() {
        return dch_ten;
    }

    public void setDch_ten(String dch_ten) {
        this.dch_ten = dch_ten;
    }

    public String getDch_mota() {
        return dch_mota;
    }

    public void setDch_mota(String dch_mota) {
        this.dch_mota = dch_mota;
    }
}
