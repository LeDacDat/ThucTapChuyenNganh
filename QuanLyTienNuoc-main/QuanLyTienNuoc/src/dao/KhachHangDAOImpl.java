
package dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import models.KhachHang;

/**
 *
 * @author duato
 */
public class KhachHangDAOImpl implements KhachHangDAO{

    @Override
    public List<KhachHang> getList() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `KhachHang`";
        List<KhachHang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maKH = rs.getInt("MaKH");
                String hoTen = rs.getString("HoTen");
                String diaChi = rs.getString("DiaChi");
                String CCCD = rs.getString("CCCD");
                Date ngaySinh = new Date(rs.getDate("NgaySinh").getTime());
                String soDienThoai = rs.getString("SoDienThoai");
                
                KhachHang khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
                list.add(khachHang);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
        
    }

    @Override
    public int createORUpdate(KhachHang khachHang) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "INSERT INTO KhachHang(MaKH, HoTen, DiaChi, CCCD, NgaySinh, SoDienThoai) VALUES(?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE HoTen = VALUES(HoTen), DiaChi = VALUES(DiaChi), CCCD = VALUES(CCCD), "
                    + "NgaySinh = VALUES(NgaySinh), SoDienThoai = VALUES(SoDienThoai);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khachHang.getMaKH());
            ps.setString(2, khachHang.getHoTen());
            ps.setString(3, khachHang.getDiaChi());
            ps.setString(4, khachHang.getCCCD());
            ps.setDate(5, khachHang.utilDateToSQLDate(khachHang.getNgaySinh()));
            ps.setString(6, khachHang.getSoDienThoai());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            MySQLConnect.disconnect();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deleteData(KhachHang khachHang) {
        
        try {
            Connection cons = MySQLConnect.getConnection();
            String sqlKhachHang = "DELETE FROM KhachHang WHERE MaKH=?";
            String sqlHoaDon = "DELETE FROM HoaDon WHERE MaKH=?";
            String sqlChiSoDien = "DELETE FROM ChiSoDien Where MaKH=?";
            PreparedStatement preparedStatement = cons.prepareStatement(sqlKhachHang);
            preparedStatement.setInt(1, khachHang.getMaKH());
            int result = preparedStatement.executeUpdate();

            if (result != 0) {

                PreparedStatement preparedStatement2 = cons.prepareStatement(sqlHoaDon);
                preparedStatement2.setInt(1, khachHang.getMaKH());
                preparedStatement2.executeUpdate();

                PreparedStatement preparedStatement3 = cons.prepareStatement(sqlChiSoDien);
                preparedStatement3.setInt(1, khachHang.getMaKH());
                preparedStatement3.executeUpdate();

                System.out.println("KhachHang deleted with id = " + khachHang.getMaKH());
                MySQLConnect.disconnect();
                return true;

            } else {
                System.out.println("No KhachHang was deleted with id = " + khachHang.getMaKH());
                MySQLConnect.disconnect();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public KhachHang getKhachHang(int maKH) {
        KhachHang khachHang = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM `KhachHang` WHERE MaKH = ?";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, maKH);
            
            ResultSet rs = ps.executeQuery();
            
            // lay hang dau tien
            if (rs.next()) {
                String hoTen = rs.getString("HoTen");
                String diaChi = rs.getString("DiaChi");
                String CCCD = rs.getString("CCCD");
                Date ngaySinh = new Date(rs.getDate("NgaySinh").getTime());
                String soDienThoai = rs.getString("SoDienThoai");
                
                khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
            }
            
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            System.err.println("getKhachHang() QuanLyKhachHang_DAL mysql request error: ");
            System.err.println(e.getMessage());
        }
        
        return khachHang;
    }
}
