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
package services;

import java.util.List;
import models.Thang;

/**
 *
 * @author duato
 */
public interface ThangService {
    public List<Thang> getList();
    public int createORUpdate(Thang thang);
    public Thang getThang(int thangID);
    public Thang getLastThangOf(int maKH);
    public Thang getLastThang();
}
