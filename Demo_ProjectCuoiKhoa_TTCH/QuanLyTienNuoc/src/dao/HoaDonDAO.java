/*
 * Project Name:       Phan Mem Quan Ly Tien Nuoc Java
 * Project URI:        https://github.com/zadajtjeu/QuanLyTienNuoc
 * Description:       Bai tap lon Java Quan Ly Tien Nuoc JDBC + Swing
 * Version:           1.0
 * Author:            Nhom 18: Nam, Hao, Trung
 * Author URI:        https://nam.name.vn
 * 
 * Copyright (C) 2021-2022 Pham Thanh Nam - HAUI.
 * 
 */
package dao;

import java.util.List;
import models.HoaDon;
import models.Thang;

/**
 *
 * @author duato
 */
public interface HoaDonDAO {
    public List<HoaDon> getList();
    public boolean deleteData(long maHoaDon);
    public int createHoaDon(HoaDon hoaDon);
    public int updateBillStatus(int maHD);
    public List<HoaDon> getListOfThang(Thang thang);
}
