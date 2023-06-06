
package services;

import java.util.List;
import models.ChiSoNuoc;
import models.Thang;

/**
 *
 * @author duato
 */
public interface ChiSoNuocService {
    public List<ChiSoNuoc> getList();
    // Lấy danh sách chỉ số điện chưa lập hoá đơn
    public List<ChiSoNuoc> getListExcludedInHoaDon();
    public ChiSoNuoc getChiSoNuoc(int maKH, int thangID);
    public ChiSoNuoc getLastChiSoNuoc(int maKH);
    public ChiSoNuoc getFirstChiSoNuoc(int maKH);
    public int createORUpdate(ChiSoNuoc chiSoNuoc);
    public List<ChiSoNuoc> getListOfThang(Thang thang);
}
