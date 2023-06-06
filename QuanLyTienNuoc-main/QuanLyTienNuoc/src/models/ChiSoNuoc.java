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
public class ChiSoNuoc {
    private long id;
    private int maKH;
    private int thangID;
    private int chiSoCu;
    private int chiSoMoi;
    private Date ngayGhi;

    public ChiSoNuoc() {
    }

    public ChiSoNuoc(long id, int maKH, int thangID, int chiSoCu, int chiSoMoi, Date ngayGhi) {
        this.id = id;
        this.maKH = maKH;
        this.thangID = thangID;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
        this.ngayGhi = ngayGhi;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    public Date getNgayGhi() {
        return ngayGhi;
    }

    public void setNgayGhi(Date ngayGhi) {
        this.ngayGhi = ngayGhi;
    }
    
    public String dateToString(Date date)
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    public java.sql.Date utilDateToSQLDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public Date sqlDateToUtilDate(java.sql.Date date) {
        return new java.util.Date(date.getTime());
    }

    @Override
    public String toString() {
        return "ChiSoNuoc{" + "id=" + id + ", maKH=" + maKH + ", thangID=" + thangID + ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", ngayGhi=" + ngayGhi + '}';
    }

    public List<Object> getAsList(Thang thang) {
        return Arrays.asList(id, maKH, thangID, thang.getNgayDau(), thang.getNgayCuoi(), chiSoCu, chiSoMoi, ngayGhi);
    }

}
