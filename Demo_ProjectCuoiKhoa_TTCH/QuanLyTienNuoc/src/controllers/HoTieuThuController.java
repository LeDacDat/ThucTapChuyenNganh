
package controllers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import main.Main;
import models.KhachHang;
import services.KhachHangServiceImpl;
import utility.ClassTableModel;
import views.KhachHangJDialog;

/**
 *
 * @author duato
 */
public class HoTieuThuController {
    
    private static JPanel jpnView;
    private static JButton btnAdd;
    private static JTextField jtfSearch;
    
    private static KhachHangServiceImpl khachHangServiceImpl = null;
    private static ClassTableModel classTableModel = null;


    private static TableRowSorter<TableModel> rowSorter = null;

    public HoTieuThuController() {
    }
    
    public HoTieuThuController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.khachHangServiceImpl = new KhachHangServiceImpl();
        this.classTableModel = new ClassTableModel();
    }
    
    public static void setDataToTable() {
        List<KhachHang> listItem = khachHangServiceImpl.getList();
        
        String[] listColumn = {"Mã KH", "Họ tên", "Địa chỉ", "CCCD", "Ngày sinh", "Điện thoại"};
        DefaultTableModel model = classTableModel.setTableKhachHang(listItem, listColumn);
        JTable table = new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        //Chage with to Hide MaKH
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        //Su kien chon 1 dong trong bang
        
        table.addMouseListener(new MouseAdapter() {
            //Sự kiện click đúp vào thì sẽ mở jdialog để chỉnh sửa
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                    //selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);
                    
                    // Lay thong tin tren bang
                    int maKH = model.getValueAt(selectedRowIndex, 0).toString() != null?
                            (int) model.getValueAt(selectedRowIndex, 0) : 0;
                    String hoTen = model.getValueAt(selectedRowIndex, 1).toString() != null?
                            model.getValueAt(selectedRowIndex, 1).toString() : "";
                    String diaChi = model.getValueAt(selectedRowIndex, 2).toString() != null?
                            model.getValueAt(selectedRowIndex, 2).toString() : "";
                    String CCCD = model.getValueAt(selectedRowIndex, 3).toString();
                    Date ngaySinh = null;
                    try {
                        ngaySinh = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex, 4).toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String soDienThoai = model.getValueAt(selectedRowIndex, 5).toString() != null?
                            model.getValueAt(selectedRowIndex, 5).toString() : "";
                    
                    KhachHang khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
                    
                    KhachHangJDialog frame = new KhachHangJDialog(Main.mainFrame, true, khachHang);
                    frame.setLocationRelativeTo(null);
                    frame.setResizable(false);
                    frame.setTitle("Thông tin khách hàng");
                    frame.setVisible(true);
                }
            }
            
            //Hiển thị Jpopupmenu khi chọn để sửa hoặc xoá

            @Override
            public void mouseReleased(MouseEvent e) {
                int r = table.rowAtPoint(e.getPoint());
                if (r >= 0 && r < table.getRowCount()) {
                    table.setRowSelectionInterval(r, r);
                } else {
                    table.clearSelection();
                }

                //row index is found...
                int rowindex = table.getSelectedRow();
                if (rowindex < 0) {
                    return;
                }
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    JPopupMenu popup = createEditAndDeletePopUp(rowindex, table);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
            
        });
                
                
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1350, 400));
        
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public static void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KhachHangJDialog frame = null;
                frame = new KhachHangJDialog(Main.mainFrame, true);
                frame.setTitle("Thêm khách hàng mới");
                
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });
    }
    
    public static JPopupMenu createEditAndDeletePopUp(int rowindex, JTable table) {
        JPopupMenu popup = new JPopupMenu();
        JMenuItem edit = new JMenuItem("Chỉnh sửa");
        edit.setIcon(new javax.swing.ImageIcon(HoTieuThuController.class.getResource("/images/edit.png"))); // NOI18N
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                //selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                // Lay thong tin tren bang
                int maKH = model.getValueAt(selectedRowIndex, 0).toString() != null
                        ? (int) model.getValueAt(selectedRowIndex, 0) : 0;
                String hoTen = model.getValueAt(selectedRowIndex, 1).toString() != null
                        ? model.getValueAt(selectedRowIndex, 1).toString() : "";
                String diaChi = model.getValueAt(selectedRowIndex, 2).toString() != null
                        ? model.getValueAt(selectedRowIndex, 2).toString() : "";
                String CCCD = model.getValueAt(selectedRowIndex, 3).toString();
                Date ngaySinh = null;
                try {
                    ngaySinh = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex, 4).toString());
                } catch (ParseException ex) {
                    Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                String soDienThoai = model.getValueAt(selectedRowIndex, 5).toString() != null
                        ? model.getValueAt(selectedRowIndex, 5).toString() : "";

                KhachHang khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);

                KhachHangJDialog frame = new KhachHangJDialog(Main.mainFrame, true, khachHang);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setTitle("Thông tin khách hàng");
                frame.setVisible(true);
                
                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                    // Cửa sổ đã được đóng
                    @Override
                    public void windowClosed(WindowEvent e) {
                        setDataToTable();
                        setEvent();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        });
        JMenuItem delete = new JMenuItem("Xoá");
        delete.setIcon(new javax.swing.ImageIcon(HoTieuThuController.class.getResource("/images/delete.png"))); // NOI18N
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(Main.mainFrame,
                        "Bạn muốn xoá dữ liệu này không?", "Xác nhận xoá", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                    //selectedRowIndex = table.convertColumnIndexToModel(selectedRowIndex);

                    // Lay thong tin tren bang
                    int maKH = model.getValueAt(selectedRowIndex, 0).toString() != null
                            ? (int) model.getValueAt(selectedRowIndex, 0) : 0;
                    String hoTen = model.getValueAt(selectedRowIndex, 1).toString() != null
                            ? model.getValueAt(selectedRowIndex, 1).toString() : "";
                    String diaChi = model.getValueAt(selectedRowIndex, 2).toString() != null
                            ? model.getValueAt(selectedRowIndex, 2).toString() : "";
                    String CCCD = model.getValueAt(selectedRowIndex, 3).toString();
                    Date ngaySinh = null;
                    try {
                        ngaySinh = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(selectedRowIndex, 4).toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(HoTieuThuController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String soDienThoai = model.getValueAt(selectedRowIndex, 5).toString() != null
                            ? model.getValueAt(selectedRowIndex, 5).toString() : "";

                    KhachHang khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
                    
                    boolean check = new KhachHangServiceImpl().deleteData(khachHang);
                    if (check) {
                        setDataToTable();
                        setEvent();
                        JOptionPane.showMessageDialog(Main.mainFrame, "Delete scucessfuly");
                    } else {
                        JOptionPane.showMessageDialog(Main.mainFrame, "Delete failed");
                        
                    }
                }
            }
        });
        popup.add(edit);
        popup.add(delete);
        return popup;
    }
}
