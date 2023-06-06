
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.Thang;

/**
 *
 * @author Admin
 */
public class ThongKeDAOImpl implements ThongKeDAO{

    @Override
    public List<List<Object>> getRawData() {
        Connection cons = MySQLConnect.getConnection();
        String sql = "select thang.thangid, ngaydau, ngaycuoi, sum(LuongNuocTieuThu) as tongnuoctieuthutrongthang, sum(tongtien) as tongtientrongthang\n" +
                    "from `thang` inner join `hoadon` on `thang`.ThangID = `hoadon`.ThangID\n" +
                    "where tinhtrang = true\n" +
                    "group by thangid";
        List<List<Object>> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int thangID = rs.getInt("thangid");
                Date ngayDau = new Date(rs.getDate("ngaydau").getTime());
                Date ngayCuoi = new Date(rs.getDate("ngaycuoi").getTime());
                long tongLuongNuocTieuThu = rs.getLong("tongnuoctieuthutrongthang");
                long tongTien = rs.getLong("tongtientrongthang");

                List<Object> lis = Arrays.asList(thangID, ngayDau, ngayCuoi, tongLuongNuocTieuThu, tongTien);
                list.add(lis);
            }
            ps.close();
            MySQLConnect.disconnect();
        } catch (SQLException e) {
            MySQLConnect.disconnect();
            System.err.println(e.getMessage());
        }
        return list;
    }
    
}
