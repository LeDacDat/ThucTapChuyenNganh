
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.ChiSoNuoc;
import models.KhachHang;
import models.Thang;
import services.ChiSoNuocServiceImpl;
import services.KhachHangServiceImpl;
import services.ThangServiceImpl;
import utility.JCustomTable;
import utility.JCustomTableBuilder;
import views.JDialog_SuaChiSoNuoc;
import views.JDialog_ThemChiSoNuoc;
import views.JDialog_ThemThang;

/**
 *
 * @author Admin
 */
public class ChiSoNuocController {
    JTextField jTextField_MaKH;
    JTextField jTextField_TenKH;
    JTextArea jTextArea_DiaChi;
    JTextField jTextField_SoNuocThoai;
    JTextField jTextField_TimKiem;
    JScrollPane jScrollPane_ChiSoNuoc;
    JButton jButton_GhiNuoc;
    JButton jButton_ThemThang;
    JScrollPane jScrollPane_KhachHang;

    public ChiSoNuocController(JTextField jTextField_MaKH, JTextField jTextField_TenKH, JTextArea jTextArea_DiaChi, JTextField jTextField_soNuocThoai, JTextField jTextField_TimKiem, JScrollPane jScrollPane_ChiSoNuoc, JButton jButton_GhiNuoc, JButton jButton_ThemThang, JScrollPane jScrollPane_KhachHang) {
        this.jTextField_MaKH = jTextField_MaKH;
        this.jTextField_TenKH = jTextField_TenKH;
        this.jTextArea_DiaChi = jTextArea_DiaChi;
        this.jTextField_SoNuocThoai = jTextField_soNuocThoai;
        this.jTextField_TimKiem = jTextField_TimKiem;
        this.jScrollPane_ChiSoNuoc = jScrollPane_ChiSoNuoc;
        this.jButton_GhiNuoc = jButton_GhiNuoc;
        this.jButton_ThemThang = jButton_ThemThang;
        this.jScrollPane_KhachHang = jScrollPane_KhachHang;
    }
    
    private final KhachHangServiceImpl khachHangServiceImpl = new KhachHangServiceImpl();
    private final ChiSoNuocServiceImpl chiSoNuocServiceImpl = new ChiSoNuocServiceImpl();
    private final ThangServiceImpl thangServiceImpl = new ThangServiceImpl();
    
    private JCustomTable jCustomTable_KhachHang;
    private JCustomTable jCustomTable_ChiSoNuoc;
    
    private KhachHang khachHang;
    
    public void initTables(){
         jCustomTable_KhachHang = new JCustomTableBuilder(jScrollPane_KhachHang)
                .addColumnName("Mã khách hàng")
                .addColumnName("Họ tên")
                .addColumnName("Địa chỉ")
                .addColumnName("CCCD")
                .addColumnName("Ngày sinh")
                .addColumnName("Số điện thoại")
                .hideColumn(3)
                .hideColumn(4)
                .build();
        
        refreshjTable_KhachHang();
        
        jCustomTable_ChiSoNuoc = new JCustomTableBuilder(jScrollPane_ChiSoNuoc)
                .addColumnName("Mã chỉ số")
                .addColumnName("Mã khách hàng")
                .addColumnName("Mã tháng")
                .addColumnName("Ngày đầu")
                .addColumnName("Ngày cuối")
                .addColumnName("Chỉ số cũ")
                .addColumnName("Chỉ số mới")
                .addColumnName("Ngày ghi")
                .hideColumn(0)
                .hideColumn(1)
                .build();
        
        refreshjTable_ChiSoNuoc(0);
    }
    
    private void refreshjTable_KhachHang(){
        jCustomTable_KhachHang.clear();
        List<List<Object>> obj = new ArrayList<>();
        List<KhachHang> list = khachHangServiceImpl.getList();
        list.forEach(kh -> { obj.add(kh.getAsList()); });
        
        jCustomTable_KhachHang.addRows(obj);
    }
    
    private void refreshjTable_ChiSoNuoc(int maKH){
        jCustomTable_ChiSoNuoc.clear();
        
        List<List<Object>> obj = new ArrayList<>();
        List<ChiSoNuoc> list = chiSoNuocServiceImpl.getList();
        list.forEach(csd -> {
            if (csd.getMaKH() == maKH){
                Thang thang = thangServiceImpl.getThang(csd.getThangID());
                obj.add(csd.getAsList(thang));
            }
        });
        
        jCustomTable_ChiSoNuoc.addRows(obj);
    }
    
    public void initEvent(){
         jTextField_TimKiem.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                jCustomTable_KhachHang.filter(jTextField_TimKiem.getText());
            }
            @Override
            public void keyReleased(KeyEvent e) {
                jCustomTable_KhachHang.filter(jTextField_TimKiem.getText());
            }
        });
         
        JTable jTable_KhachHang = jCustomTable_KhachHang.getJTable();
        jTable_KhachHang.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jTable_KhachHang.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) jTable_KhachHang.getModel();
                    int selectedRowIndex = jTable_KhachHang.convertRowIndexToModel(jTable_KhachHang.getSelectedRow());
                   // selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    // Lay thong tin tren bang
                    int maKH = model.getValueAt(selectedRowIndex, 0) != null ?
                           (int) model.getValueAt(selectedRowIndex, 0) : 0;
                    String tenKH = model.getValueAt(selectedRowIndex, 1) != null ?
                            model.getValueAt(selectedRowIndex, 1).toString() : "";
                    String diaChi = model.getValueAt(selectedRowIndex, 2) != null ?
                            model.getValueAt(selectedRowIndex, 2).toString() : "";
                    String soNuocThoai = model.getValueAt(selectedRowIndex, 5) != null ?
                            model.getValueAt(selectedRowIndex, 5).toString() : "";
                    
                    jTextField_MaKH.setText(maKH + "");
                    jTextField_TenKH.setText(tenKH);
                    jTextArea_DiaChi.setText(diaChi);
                    jTextField_SoNuocThoai.setText(soNuocThoai);
                    khachHang = khachHangServiceImpl.getKhachHang(maKH);
                    jButton_GhiNuoc.setEnabled(true);
                    refreshjTable_ChiSoNuoc(khachHang.getMaKH());
               }
            }
        });
        
        JTable jTable_ChiSoNuoc = jCustomTable_ChiSoNuoc.getJTable();
        jTable_ChiSoNuoc.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && jTable_ChiSoNuoc.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) jTable_ChiSoNuoc.getModel();
                    int selectedRowIndex = jTable_ChiSoNuoc.convertRowIndexToModel(jTable_ChiSoNuoc.getSelectedRow());
                   // selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    // Lay thong tin tren bang
                    int maKH = model.getValueAt(selectedRowIndex, 1) != null ?
                           (int) model.getValueAt(selectedRowIndex, 1) : 0;
                    int thangID = model.getValueAt(selectedRowIndex, 2) != null ?
                           (int) model.getValueAt(selectedRowIndex, 2) : 0;

                    KhachHang khachHang = khachHangServiceImpl.getKhachHang(maKH);
                    ChiSoNuoc chiSoNuoc = chiSoNuocServiceImpl.getChiSoNuoc(maKH, thangID);
                    
                    JDialog_SuaChiSoNuoc jDialog = new JDialog_SuaChiSoNuoc(khachHang, chiSoNuoc);

                    jDialog.addWindowListener(new WindowAdapter(){
                        @Override
                        public void windowClosing(WindowEvent e) {
                            refreshjTable_ChiSoNuoc(khachHang.getMaKH());
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                            refreshjTable_ChiSoNuoc(khachHang.getMaKH());
                        }
                    });
                    
                    jDialog.setLocationRelativeTo(null);
                    jDialog.setResizable(false);
                    jDialog.setVisible(true);
                    
               }
            }
        });
        
        jButton_GhiNuoc.addActionListener((ActionEvent e) -> {
            // hien bang tao thang
            JDialog_ThemChiSoNuoc jDialog = new JDialog_ThemChiSoNuoc(khachHang);
            
            jDialog.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    refreshjTable_ChiSoNuoc(khachHang.getMaKH());
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    refreshjTable_ChiSoNuoc(khachHang.getMaKH());
                }
            });
                    
            
            jDialog.setLocationRelativeTo(null);
            jDialog.setResizable(false);
            jDialog.setVisible(true);
        });
        
        jButton_ThemThang.addActionListener((ActionEvent e) -> {
            JDialog_ThemThang jDialog = new JDialog_ThemThang();
            
            jDialog.setLocationRelativeTo(null);
            jDialog.setResizable(false);
            jDialog.setVisible(true);
        });
    }
}
