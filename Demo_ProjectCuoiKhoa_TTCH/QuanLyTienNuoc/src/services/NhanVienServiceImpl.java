
package services;

import dao.NhanVienDAO;
import dao.NhanVienDAOImpl;
import java.util.List;
import models.NhanVien;

/**
 *
 * @author duato
 */
public class NhanVienServiceImpl implements NhanVienService{
    
    private NhanVienDAO nhanVienDAO = null;

    public NhanVienServiceImpl() {
        nhanVienDAO = new NhanVienDAOImpl();
    }
    
    @Override
    public NhanVien getLogin(String taiKhoan, String matKhau) {
        return nhanVienDAO.getLogin(taiKhoan, matKhau);
    }

    @Override
    public List<NhanVien> getList() {
        return nhanVienDAO.getList();
    }

    @Override
    public int create(NhanVien nhanVien) {
        return nhanVienDAO.create(nhanVien);
    }
    
    @Override
    public int update(NhanVien nhanVien) {
        return nhanVienDAO.update(nhanVien);
    }

    @Override
    public boolean deleteData(int maNV) {
        return nhanVienDAO.deleteData(maNV);
    }

    @Override
    public int changePassword(int maNV, String oldPass, String newPass) {
        return nhanVienDAO.changePassword(maNV, oldPass, newPass);
    }
    
}
