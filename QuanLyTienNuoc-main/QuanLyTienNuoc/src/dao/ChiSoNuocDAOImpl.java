
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.ChiSoNuoc;
import models.Thang;

/**
 *
 * @author duato
 */
public class ChiSoNuocDAOImpl implements ChiSoNuocDAO{
    
    @Override
    public List<ChiSoNuoc> getList() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `ChiSoNuoc`";
        List<ChiSoNuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("ID");
                int maKH = rs.getInt("MaKH");
                int thangID = rs.getInt("ThangID");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                Date ngayGhi = new Date(rs.getDate("NgayGhi").getTime());

                ChiSoNuoc chiSoNuoc = new ChiSoNuoc(id, maKH, thangID, chiSoCu, chiSoMoi, ngayGhi);
                list.add(chiSoNuoc);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return list;
    }

    // Lấy danh sách chỉ số điện chưa lập hoá đơn
    @Override
    public List<ChiSoNuoc> getListExcludedInHoaDon() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `ChiSoNuoc` WHERE "
                + "`ThangID` NOT IN (SELECT DISTINCT `ThangID` FROM `HoaDon` WHERE `MaKH` = `ChiSoNuoc`.`MaKH`) "
                + "AND `MaKH` NOT IN (SELECT DISTINCT `MaKH` FROM `HoaDon` WHERE `ThangID` = `ChiSoNuoc`.`ThangID`)";
        List<ChiSoNuoc> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("ID");
                int maKH = rs.getInt("MaKH");
                int thangID = rs.getInt("ThangID");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                Date ngayGhi = new Date(rs.getDate("NgayGhi").getTime());

                ChiSoNuoc chiSoNuoc = new ChiSoNuoc(id, maKH, thangID, chiSoCu, chiSoMoi, ngayGhi);
                list.add(chiSoNuoc);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return list;
    }
    
    @Override
    public ChiSoNuoc getChiSoNuoc(int maKH, int thangID) {
        ChiSoNuoc chiSoNuoc = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM `ChiSoNuoc` WHERE maKH = ? AND thangID = ?";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, maKH);
            ps.setInt(2, thangID);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                long id = rs.getLong("ID");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                Date ngayGhi = rs.getDate("NgayGhi");
                
                chiSoNuoc = new ChiSoNuoc(id, maKH, thangID, chiSoCu, chiSoMoi, ngayGhi);
            }
            
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
            
            
        }
        catch (SQLException e){
            System.err.println("Bug lòi ra: " + e.getMessage());
        }
        return chiSoNuoc;
    }

    @Override
    public ChiSoNuoc getFirstChiSoNuoc(int maKH) {
        ChiSoNuoc chiSoNuoc = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM ChiSoNuoc WHERE MaKH = ? " + 
                    "AND NgayGhi = (SELECT MIN(NgayGhi) FROM ChiSoNuoc WHERE MaKH = ?);";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, maKH);
            ps.setInt(2, maKH);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                long id = rs.getLong("ID");
                int thangID = rs.getInt("ThangID");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                Date ngayGhi = rs.getDate("NgayGhi");
                
                chiSoNuoc = new ChiSoNuoc(id, maKH, thangID, chiSoCu, chiSoMoi, ngayGhi);
            }
            
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        }
        catch (SQLException e){
            System.err.println("Bug lòi ra: " + e.getMessage());
        }
        return chiSoNuoc;
    }
    
    @Override
    public ChiSoNuoc getLastChiSoNuoc(int maKH) {
        ChiSoNuoc chiSoNuoc = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM ChiSoNuoc WHERE MaKH = ? " + 
                    "AND NgayGhi = (SELECT MAX(NgayGhi) FROM ChiSoNuoc WHERE MaKH = ?);";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, maKH);
            ps.setInt(2, maKH);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                long id = rs.getLong("ID");
                int thangID = rs.getInt("ThangID");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                Date ngayGhi = rs.getDate("NgayGhi");
                
                chiSoNuoc = new ChiSoNuoc(id, maKH, thangID, chiSoCu, chiSoMoi, ngayGhi);
            }
            
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        }
        catch (SQLException e){
            System.err.println("Bug lòi ra: " + e.getMessage());
        }
        return chiSoNuoc;
    }
    
    @Override
    public int createORUpdate(ChiSoNuoc chiSoNuoc) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "INSERT INTO ChiSoNuoc(ID, MaKH, ThangID, ChiSoCu, ChiSoMoi, NgayGhi) VALUES(?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE ChiSoCu = VALUES(ChiSoCu), ChiSoMoi = VALUES(ChiSoMoi), NgayGhi = VALUES(NgayGhi);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setLong(1, chiSoNuoc.getId());
            ps.setInt(2, chiSoNuoc.getMaKH());
            ps.setInt(3, chiSoNuoc.getThangID());
            ps.setInt(4, chiSoNuoc.getChiSoCu());
            ps.setInt(5, chiSoNuoc.getChiSoMoi());
            ps.setDate(6, chiSoNuoc.utilDateToSQLDate(chiSoNuoc.getNgayGhi()));
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
            System.err.println(ex.getMessage());
        }
        return 0;
    }

    public List<ChiSoNuoc> getListOfThang(Thang thang) {
        List<ChiSoNuoc> list = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM `ChiSoNuoc` WHERE ThangID = ?";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, thang.getThangID());
            
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            
            while (rs.next()) {
                ChiSoNuoc chiSoNuoc = new ChiSoNuoc();
                long id = rs.getLong("ID");
                int maKH = rs.getInt("MaKH");
                int chiSoCu = rs.getInt("ChiSoCu");
                int chiSoMoi = rs.getInt("ChiSoMoi");
                java.util.Date ngayGhi =  chiSoNuoc.sqlDateToUtilDate(rs.getDate("NgayGhi"));
                
                chiSoNuoc = new ChiSoNuoc(id, maKH, thang.getThangID(), chiSoCu, chiSoMoi, ngayGhi);
                list.add(chiSoNuoc);
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
