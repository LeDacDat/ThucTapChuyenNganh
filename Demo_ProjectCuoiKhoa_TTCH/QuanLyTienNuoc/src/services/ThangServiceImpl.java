
package services;

import dao.ThangDAO;
import dao.ThangDAOImpl;
import java.util.List;
import models.Thang;

/**
 *
 * @author duato
 */
public class ThangServiceImpl implements ThangService{
    
    private ThangDAO thangDAO = null;

    public ThangServiceImpl() {
        thangDAO = new ThangDAOImpl();
    }

    @Override
    public List<Thang> getList() {
        return thangDAO.getList();
    }

    @Override
    public int createORUpdate(Thang thang) {
        return thangDAO.createORUpdate(thang);
    }

    @Override
    public Thang getThang(int thangID) {
        return thangDAO.getThang(thangID);
    }

    @Override
    public Thang getLastThangOf(int maKH) {
        return thangDAO.getLastThangOf(maKH);
    }

    @Override
    public Thang getLastThang() {
        return thangDAO.getLastThang();
    }
    
}
