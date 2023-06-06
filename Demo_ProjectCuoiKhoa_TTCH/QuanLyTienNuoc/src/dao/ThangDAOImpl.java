
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Thang;

/**
 *
 * @author duato
 */
public class ThangDAOImpl implements ThangDAO{

    @Override
    public List<Thang> getList() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "SELECT * FROM `Thang`";
        List<Thang> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thangID = rs.getInt("ThangID");
                Date ngayDau = new Date(rs.getDate("NgayDau").getTime());
                Date ngayCuoi = new Date(rs.getDate("NgayCuoi").getTime());

                Thang thang = new Thang(thangID, ngayDau, ngayCuoi);
                list.add(thang);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            MySQLConnect.disconnect();
        }
        return list;
    }

    @Override
    public int createORUpdate(Thang thang) {
        try {
            Connection cons = MySQLConnect.getConnection();
            String sql = "INSERT INTO Thang(ThangID, NgayDau, NgayCuoi) VALUES(?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE NgayDau = VALUES(NgayDau), NgayCuoi = VALUES(NgayCuoi);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, thang.getThangID());
            ps.setDate(2, thang.getNgayDauSQL());
            ps.setDate(3, thang.getNgayCuoiSQL());
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
    
    @Override
    public Thang getThang(int thangID){
        Thang thang = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM `Thang` WHERE ThangID = ?";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, thangID);
            
            ResultSet rs = ps.executeQuery();
            
            // lay hang dau tien
            if (rs.next()) {
                Date ngayDau = new Date(rs.getDate("NgayDau").getTime());
                Date ngayCuoi = new Date(rs.getDate("NgayCuoi").getTime());
                
                thang = new Thang(thangID, ngayDau, ngayCuoi);
            }
            
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
       
        return thang; 
    }

    @Override
    public Thang getLastThangOf(int maKH) {
        Thang thang = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM Thang WHERE ThangID = (SELECT MAX(ThangID) "
                    + "FROM (SELECT ThangID FROM ChiSoNuoc WHERE maKH = ?) as T);";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ps.setInt(1, maKH);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int thangID = rs.getInt("ThangID");
                Date ngayDau = new Date(rs.getDate("NgayDau").getTime());
                Date ngayCuoi = new Date(rs.getDate("NgayCuoi").getTime());
                
                thang = new Thang(thangID, ngayDau, ngayCuoi);
            }
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return thang;
    }

    @Override
    public Thang getLastThang() {
        Thang thang = null;
        try {
            Connection connection = MySQLConnect.getConnection();
            String query = "SELECT * FROM Thang WHERE ThangID = (SELECT MAX(ThangID) FROM Thang)";
            
            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int thangID = rs.getInt("ThangID");
                Date ngayDau = new Date(rs.getDate("NgayDau").getTime());
                Date ngayCuoi = new Date(rs.getDate("NgayCuoi").getTime());
                
                thang = new Thang(thangID, ngayDau, ngayCuoi);
            }
            ps.close();
            connection.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return thang;
    }
}
