/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author duato
 */
public class KhachHang {
    private int maKH;
    private String hoTen;
    private String diaChi;
    private String CCCD;
    private Date ngaySinh;
    private String soDienThoai;

    public KhachHang() {
    }

    public KhachHang(int maKH, String hoTen, String diaChi, String CCCD, Date ngaySinh, String soDienThoai) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.CCCD = CCCD;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    public String dateToString(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
    
    public java.sql.Date utilDateToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public Date sqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", CCCD=" + CCCD + ", ngaySinh=" + ngaySinh + ", soDienThoai=" + soDienThoai + '}';
    }
    
    public List<Object> getAsList() {
        return Arrays.asList(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
    }
}
