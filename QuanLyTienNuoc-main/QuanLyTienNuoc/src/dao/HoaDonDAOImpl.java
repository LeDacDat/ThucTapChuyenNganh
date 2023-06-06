
package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import models.HoaDon;
import models.Thang;

/**
 *
 * @author duato
 */
public class HoaDonDAOImpl implements HoaDonDAO{

    @Override
    public List<HoaDon> getList() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `HoaDon`";
        List<HoaDon> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maHD = rs.getInt("MaHD");
                int maKH = rs.getInt("MaKH");
                int thangID = rs.getInt("ThangID");
                int luongNuocTieuThu = rs.getInt("LuongNuocTieuThu");
                long tongTien = rs.getLong("TongTien");
                Date ngayLapPhieu = new Date(rs.getDate("NgayLapPhieu").getTime());
                boolean tinhTrang = rs.getBoolean("TinhTrang");
                int maNV = rs.getInt("MaNV");
                
                HoaDon hoaDon = new HoaDon(maHD, maKH, thangID, luongNuocTieuThu, tongTien, ngayLapPhieu, tinhTrang, maNV);
                list.add(hoaDon);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return list;
    }

    @Override
    public boolean deleteData(long maHoaDon) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "DELETE FROM `HoaDon` WHERE `MaHD`=?";
            PreparedStatement preparedStatement = cons.prepareStatement(sql);
            preparedStatement.setLong(1, maHoaDon);
            int result = preparedStatement.executeUpdate();

            if (result != 0) {
                System.out.println("HoaDon deleted with id = " + maHoaDon);
                MySQLConnect.disconnect();
                return true;
            } else {
                System.out.println("No HoaDon was deleted with id = " + maHoaDon);
                MySQLConnect.disconnect();
                return false;
            }

        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return false;
    }

    @Override
    public int createHoaDon(HoaDon hoaDon) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "INSERT INTO HoaDon(MaKH, ThangID, LuongNuocTieuThu, TongTien, NgayLapPhieu, TinhTrang, MaNV) VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hoaDon.getMaKH());
            ps.setInt(2, hoaDon.getThangID());
            ps.setInt(3, hoaDon.getLuongNuocTieuThu());
            ps.setLong(4, hoaDon.getTongTien());
            ps.setDate(5, hoaDon.utilDateToSQLDate(hoaDon.getNgayLapPhieu()));
            ps.setBoolean(6, hoaDon.isTinhTrang());
            ps.setInt(7, hoaDon.getMaNV());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            MySQLConnect.disconnect();
            return generatedKey;
        } catch (SQLException ex) {
            MySQLConnect.disconnect();
        }
        return 0;
    }

    @Override
    public int updateBillStatus(int maHD) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "UPDATE `HoaDon` SET `TinhTrang`=true WHERE `MaHD`=?;";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, maHD);
            int generatedKey = ps.executeUpdate();
            ps.close();
            MySQLConnect.disconnect();
            return generatedKey;
        } catch (SQLException ex) {
            MySQLConnect.disconnect();
        }
        return 0;
    }

    @Override
    public List<HoaDon> getListOfThang(Thang thang) {
        List<HoaDon> list = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM `HoaDon` WHERE ThangID = ?";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, thang.getThangID());
            
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            
            while (rs.next()) {
                int maHD = rs.getInt("MaHD");
                int maKH = rs.getInt("MaKH");
                int luongNuocTieuThu = rs.getInt("LuongNuocTieuThu");
                long tongTien = rs.getLong("TongTien");
                java.util.Date ngayLapPhieu = new java.util.Date(rs.getDate("NgayLapPhieu").getTime());
                boolean tinhTrang = rs.getBoolean("TinhTrang");
                int maNV = rs.getInt("MaNV");
                
                HoaDon hoaDon = new HoaDon(maHD, maKH, thang.getThangID(), luongNuocTieuThu, tongTien, ngayLapPhieu, tinhTrang, maNV);
                list.add(hoaDon);
            }
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return list;
    }
}
