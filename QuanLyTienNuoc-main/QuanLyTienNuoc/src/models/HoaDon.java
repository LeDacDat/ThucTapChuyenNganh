/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author duato
 */
public class HoaDon {
    private int maHD;
    private int maKH;
    private int thangID;
    private int luongNuocTieuThu;
    private long tongTien;
    private Date ngayLapPhieu;
    private boolean tinhTrang;
    private int maNV;

    public HoaDon() {
    }  

    public HoaDon(int maHD, int maKH, int thangID, int luongNuocTieuThu, long tongTien, Date ngayLapPhieu, boolean tinhTrang, int maNV) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.thangID = thangID;
        this.luongNuocTieuThu = luongNuocTieuThu;
        this.tongTien = tongTien;
        this.ngayLapPhieu = ngayLapPhieu;
        this.tinhTrang = tinhTrang;
        this.maNV = maNV;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getThangID() {
        return thangID;
    }

    public void setThangID(int thangID) {
        this.thangID = thangID;
    }

    public int getLuongNuocTieuThu() {
        return luongNuocTieuThu;
    }

    public void setLuongNuocTieuThu(int luongNuocTieuThu) {
        this.luongNuocTieuThu = luongNuocTieuThu;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Date ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public java.sql.Date utilDateToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public Date sqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }
    
    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maKH=" + maKH + ", thangID=" + thangID + ", luongNuocTieuThu=" + luongNuocTieuThu + ", tongTien=" + tongTien + ", ngayLapPhieu=" + ngayLapPhieu + ", tinhTrang=" + tinhTrang + ", maNV=" + maNV + '}';
    }
    
}
