
package dao;

import java.util.List;
import models.ChiSoNuoc;

/**
 *
 * @author duato
 */
public interface ChiSoNuocDAO {
    public List<ChiSoNuoc> getList();
    // Lấy danh sách chỉ số điện chưa lập hoá đơn
    public List<ChiSoNuoc> getListExcludedInHoaDon();
    public ChiSoNuoc getChiSoNuoc(int maKH, int thangID);
    public ChiSoNuoc getLastChiSoNuoc(int maKH);
    public ChiSoNuoc getFirstChiSoNuoc(int maKH);
    public int createORUpdate(ChiSoNuoc chiSoNuoc);
}
