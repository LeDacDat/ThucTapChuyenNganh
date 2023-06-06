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
public class Thang {
    private int thangID;
    private Date ngayDau;
    private Date ngayCuoi;

    public Thang() {
    }

    public Thang(int thangID, Date ngayDau, Date ngayCuoi) {
        this.thangID = thangID;
        this.ngayDau = ngayDau;
        this.ngayCuoi = ngayCuoi;
    }

    public int getThangID() {
        return thangID;
    }

    public void setThangID(int thangID) {
        this.thangID = thangID;
    }

    public Date getNgayDau() {
        return ngayDau;
    }
    
    public java.sql.Date getNgayDauSQL() {
        return new java.sql.Date(ngayDau.getTime());
    }

    public void setNgayDau(Date ngayDau) {
        this.ngayDau = ngayDau;
    }

    public Date getNgayCuoi() {
        return ngayCuoi;
    }
    
    public java.sql.Date getNgayCuoiSQL() {
        return new java.sql.Date(ngayCuoi.getTime());
    }

    public void setNgayCuoi(Date ngayCuoi) {
        this.ngayCuoi = ngayCuoi;
    }
    
    public static String dateToString(Date date)
    {
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
        return thangID + ": (" + ngayDau + " / " + ngayCuoi + ")";
    }

    public List<Object> getAsList() {
        return Arrays.asList(thangID, ngayDau, ngayCuoi);
    }
    
    
}
