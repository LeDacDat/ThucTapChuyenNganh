
package services;

import java.util.List;
import models.KhachHang;

/**
 *
 * @author duato
 */
public interface KhachHangService {
    public List<KhachHang> getList();
    
    public int createORUpdate(KhachHang khachHang);
    
    public boolean deleteData(KhachHang khachHang);
    
    public KhachHang getKhachHang(int maKH);
}
