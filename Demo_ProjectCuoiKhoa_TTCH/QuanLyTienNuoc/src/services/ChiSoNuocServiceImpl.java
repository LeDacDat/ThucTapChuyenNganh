
package services;

import dao.ChiSoNuocDAOImpl;
import java.util.List;
import models.ChiSoNuoc;
import models.Thang;

/**
 *
 * @author duato
 */
public class ChiSoNuocServiceImpl implements ChiSoNuocService{

    private ChiSoNuocDAOImpl chiSoNuocDAOImpl = null;

    public ChiSoNuocServiceImpl() {
        chiSoNuocDAOImpl = new ChiSoNuocDAOImpl();
    }
    
    @Override
    public List<ChiSoNuoc> getList() {
        return chiSoNuocDAOImpl.getList();
    }

    @Override
    public List<ChiSoNuoc> getListExcludedInHoaDon() {
        return chiSoNuocDAOImpl.getListExcludedInHoaDon();
    }

    @Override
    public ChiSoNuoc getChiSoNuoc(int maKH, int thangID) {
        return chiSoNuocDAOImpl.getChiSoNuoc(maKH, thangID);
    }

    @Override
    public ChiSoNuoc getLastChiSoNuoc(int maKH) {
        return chiSoNuocDAOImpl.getLastChiSoNuoc(maKH);
    }

    @Override
    public ChiSoNuoc getFirstChiSoNuoc(int maKH) {
        return chiSoNuocDAOImpl.getFirstChiSoNuoc(maKH);
    }

    @Override
    public int createORUpdate(ChiSoNuoc chiSoNuoc) {
        return chiSoNuocDAOImpl.createORUpdate(chiSoNuoc);
    }

    @Override
    public List<ChiSoNuoc> getListOfThang(Thang thang) {
        return chiSoNuocDAOImpl.getListOfThang(thang);
    }
    
}
