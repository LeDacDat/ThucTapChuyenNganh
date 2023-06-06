
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.NhanVien;

/**
 *
 * @author duato
 */
public class NhanVienDAOImpl implements NhanVienDAO{

    @Override
    public NhanVien getLogin(String taiKhoan, String matKhau) {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `NhanVien` WHERE `TaiKhoan`=? AND `MatKhau`=?";
        NhanVien nhanVien = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int maNV = rs.getInt("MaNV");
                String tenNV = rs.getString("TenNV");
                String chucVu = rs.getString("ChucVu");
                String tKhoan = rs.getString("TaiKhoan");
                String mKhau = rs.getString("MatKhau");
                
                nhanVien = new NhanVien(maNV, tenNV, chucVu, tKhoan, mKhau);
            }
            ps.close();
            MySQLConnect.disconnect();
            return nhanVien;
        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return null;
    }

    @Override
    public List<NhanVien> getList() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `NhanVien`";
        List<NhanVien> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int maNV = rs.getInt("MaNV");
                String tenNV = rs.getString("TenNV");
                String chucVu = rs.getString("ChucVu");
                String taiKhoan = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, chucVu, taiKhoan, matKhau);
                list.add(nhanVien);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (Exception e) {
            MySQLConnect.disconnect();
        }
        return list;
    }

    @Override
    public int create(NhanVien nhanVien) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sqlcheck = "SELECT * FROM `NhanVien` WHERE TaiKhoan=?";
            PreparedStatement pscheck = (PreparedStatement) cons.prepareStatement(sqlcheck);
            pscheck.setString(1, nhanVien.getTaiKhoan());
            ResultSet rscheck = pscheck.executeQuery();
            if (rscheck.next()) {
                MySQLConnect.disconnect();
                return -1;
            } else {
                String sql = "INSERT INTO NhanVien(TenNV, ChucVu, TaiKhoan, MatKhau) VALUES(?, ?, ?, ?);";
                int generatedKey;
                try (PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                    ps.setString(1, nhanVien.getTenNV());
                    ps.setString(2, nhanVien.getChucVu());
                    ps.setString(3, nhanVien.getTaiKhoan());
                    ps.setString(4, nhanVien.getMatKhau());
                    ps.execute();
                    ResultSet rs = ps.getGeneratedKeys();
                    generatedKey = 0;
                    if (rs.next()) {
                        generatedKey = rs.getInt(1);
                    }
                }
                MySQLConnect.disconnect();
                return generatedKey;
            }
        } catch (Exception ex) {
            
            MySQLConnect.disconnect();
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean deleteData(int maNV) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sqlNhanVien = "DELETE FROM NhanVien WHERE MaNV=?";
            PreparedStatement preparedStatement = cons.prepareStatement(sqlNhanVien);
            preparedStatement.setInt(1, maNV);
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
             MySQLConnect.disconnect();

            if (result != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int changePassword(int maNV, String oldPass, String newPass) {
        try {
            Connection cons = MySQLConnect.getConnection();

            //Check username exsist
            String sqlcheck = "SELECT * FROM `NhanVien` WHERE MaNV=? AND MatKhau = ?";
            PreparedStatement pscheck = (PreparedStatement) cons.prepareStatement(sqlcheck);
            pscheck.setInt(1, maNV);
            pscheck.setString(2, oldPass);
            ResultSet rscheck = pscheck.executeQuery();
            if (rscheck.next() == false ) {
                System.out.println(rscheck.getString("MatKhau"));
                MySQLConnect.disconnect();
                return -10;
            } else {
                String sql = "UPDATE NhanVien SET MatKhau=? WHERE MaNV=?;";
                PreparedStatement ps = cons.prepareStatement(sql);
                ps.setString(1, newPass);
                ps.setInt(2, maNV);
                int checkUpdate = 0;
                checkUpdate = ps.executeUpdate();

                ps.close();
                MySQLConnect.disconnect();
                return checkUpdate;
            }
        } catch (Exception ex) {
            MySQLConnect.disconnect();
        }
        return 0;
    }

    @Override
    public int update(NhanVien nhanVien) {
        try {
            Connection cons = MySQLConnect.getConnection();
            
            //Check username exsist
            String sqlcheck = "SELECT * FROM `NhanVien` WHERE TaiKhoan=? AND MaNV!= ?";
            PreparedStatement pscheck = (PreparedStatement) cons.prepareStatement(sqlcheck);
            pscheck.setString(1, nhanVien.getTaiKhoan());
            pscheck.setInt(2, nhanVien.getMaNV());
            ResultSet rscheck = pscheck.executeQuery();
            if (rscheck.next()) {
                MySQLConnect.disconnect();
                return -1;
            } else {
                String sql = "UPDATE NhanVien SET TenNV =?, ChucVu = ?, TaiKhoan = ? WHERE MaNV=?;";
                PreparedStatement ps = cons.prepareStatement(sql);
                ps.setString(1, nhanVien.getTenNV());
                ps.setString(2, nhanVien.getChucVu());
                ps.setString(3, nhanVien.getTaiKhoan());
                ps.setInt(4, nhanVien.getMaNV());
                int checkUpdate = 0;
                checkUpdate = ps.executeUpdate();
                
                ps.close();
                MySQLConnect.disconnect();
                return checkUpdate;
            }
        } catch (Exception ex) {
            MySQLConnect.disconnect();
        }
        return 0;
    }
    
}
