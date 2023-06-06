
package controllers;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import models.ChiSoNuoc;
import models.HoaDon;
import models.KhachHang;
import models.Thang;
import services.ChiSoNuocServiceImpl;
import services.HoaDonServiceImpl;
import services.KhachHangServiceImpl;
import services.ThangServiceImpl;
import utility.JCustomTable;
import utility.JCustomTableBuilder;

/**
 *
 * @author Admin
 */
public class ThanhToanController {

    JComboBox jComboBox_Thang;
    JScrollPane jScrollPane_ChuaGhiSoNuoc;
    JScrollPane jScrollPane_DaThanhToan;

    public ThanhToanController(JComboBox jComboBox_Thang, JScrollPane jScrollPane_ChuaGhiSoNuoc, JScrollPane jScrollPane_DaThanhToan) {
        this.jComboBox_Thang = jComboBox_Thang;
        this.jScrollPane_ChuaGhiSoNuoc = jScrollPane_ChuaGhiSoNuoc;
        this.jScrollPane_DaThanhToan = jScrollPane_DaThanhToan;
    }

    private final ThangServiceImpl thangServiceImpl = new ThangServiceImpl();
    private final ChiSoNuocServiceImpl chiSoNuocServiceImpl = new ChiSoNuocServiceImpl();
    private final KhachHangServiceImpl khachHangServiceImpl = new KhachHangServiceImpl();
    private final HoaDonServiceImpl hoaDonServiceImpl = new HoaDonServiceImpl();
    
    private JCustomTable jCustomTable_ChuaNhapSoNuoc;
    private JCustomTable jCustomTable_DaThanhToan;
    
    public void initData(){
        List<Thang> list = thangServiceImpl.getList();
        
        DefaultComboBoxModel aModel = new DefaultComboBoxModel(list.toArray());
        jComboBox_Thang.setModel(aModel);
    }
    
    public void initTable(){
        jCustomTable_ChuaNhapSoNuoc = new JCustomTableBuilder(jScrollPane_ChuaGhiSoNuoc)
                .addColumnName("Mã khách hàng")
                .addColumnName("Họ tên")
                .addColumnName("Địa chỉ")
                .addColumnName("CCCD")
                .addColumnName("Ngày sinh")
                .addColumnName("Số điện thoại")
                .build();
        
        Thang selectedThang = (Thang)jComboBox_Thang.getSelectedItem();
        
        refreshjTable_ChuaNhapSoNuoc(selectedThang);
        
        jCustomTable_DaThanhToan = new JCustomTableBuilder(jScrollPane_DaThanhToan)
                .addColumnName("Mã khách hàng")
                .addColumnName("Họ tên")
                .addColumnName("Địa chỉ")
                .addColumnName("CCCD")
                .addColumnName("Ngày sinh")
                .addColumnName("Số điện thoại")
                .build();
        
        refreshjTable_DaThanhToan(selectedThang);
        
        
    }
    
    private void refreshjTable_ChuaNhapSoNuoc(Thang thang){
        jCustomTable_ChuaNhapSoNuoc.clear();
        
        List<KhachHang> listKhachHang = khachHangServiceImpl.getList();
        List<ChiSoNuoc> listChiSoNuoc = chiSoNuocServiceImpl.getListOfThang(thang);
        
        listChiSoNuoc.forEach(chiSoNuoc -> {
            listKhachHang.removeIf(khachHang -> (khachHang.getMaKH() == chiSoNuoc.getMaKH()));
        });
        
        List<List<Object>> obj = new ArrayList<>();
        listKhachHang.forEach(khachHang -> { obj.add(khachHang.getAsList()); });
        
        jCustomTable_ChuaNhapSoNuoc.addRows(obj);
    }
    
    private void refreshjTable_DaThanhToan(Thang thang){
        jCustomTable_DaThanhToan.clear();
        
        List<HoaDon> listHoaDonOfThang = hoaDonServiceImpl.getListOfThang(thang);
        
        List<List<Object>> obj = new ArrayList<>();
        listHoaDonOfThang.forEach(hoaDon -> { obj.add(khachHangServiceImpl.getKhachHang(hoaDon.getMaKH()).getAsList()); });
        
        jCustomTable_DaThanhToan.addRows(obj);
    }
    
    public void initEvent(){
        jComboBox_Thang.addActionListener((ActionEvent e) -> {
            Thang selectedThang = (Thang)jComboBox_Thang.getSelectedItem();
            refreshjTable_ChuaNhapSoNuoc(selectedThang);
            refreshjTable_DaThanhToan(selectedThang);
        });
    }
}
