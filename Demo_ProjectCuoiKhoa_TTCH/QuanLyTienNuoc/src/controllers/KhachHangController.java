
package controllers;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.KhachHang;
import services.KhachHangServiceImpl;

/**
 *
 * @author duato
 */
public class KhachHangController {
    private JDialog khachHangJDialog;
    private JButton btnSubmit;
    private JTextField jtfMaKH;
    private JTextField jtfHoTen;
    private JTextArea jtaDiaChi;
    private JTextField jtfCCCD;
    private JTextField jtfSoDienThoai;
    private JDateChooser jdateNgaySinh;
    private JLabel jlbMsg;

    private KhachHang khachHang = null;
    private KhachHangServiceImpl khachHangServiceImpl = null;
    public KhachHangController() {
    }

    public KhachHangController(JDialog khachHangJDialog, JButton btnSubmit, JTextField jtfMaKH, JTextField jtfHoTen, JTextArea jtaDiaChi, JTextField jtfCCCD, JTextField jtfSoDienThoai, JDateChooser jdateNgaySinh, JLabel jlbMsg) {
        this.khachHangJDialog = khachHangJDialog;
        this.btnSubmit = btnSubmit;
        this.jtfMaKH = jtfMaKH;
        this.jtfHoTen = jtfHoTen;
        this.jtaDiaChi = jtaDiaChi;
        this.jtfCCCD = jtfCCCD;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jdateNgaySinh = jdateNgaySinh;
        this.jlbMsg = jlbMsg;
        
        this.khachHangServiceImpl = new KhachHangServiceImpl();
    }
    
    public void setView(KhachHang khachHang) {
        this.khachHang = khachHang;
        // insert data to field
        jtfMaKH.setText(""+khachHang.getMaKH());
        jtfHoTen.setText(khachHang.getHoTen());
        jtaDiaChi.setText(khachHang.getDiaChi());
        jtfCCCD.setText(khachHang.getCCCD());
        jdateNgaySinh.setDate(khachHang.getNgaySinh());
        jtfSoDienThoai.setText(khachHang.getSoDienThoai());
        
        jlbMsg.setText("");
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                try {
                    if (checkNull()) {
                        jlbMsg.setForeground(Color.red);
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    } else if (!checkPhoneNumber(jtfSoDienThoai.getText())){
                        jlbMsg.setForeground(Color.red);
                        jlbMsg.setText("Số điện thoại không hợp lệ!");
                        java.awt.Toolkit.getDefaultToolkit().beep();
                    } else if(!checkCCCD(jtfCCCD.getText().trim())) {
                        jlbMsg.setForeground(Color.red);
                        jlbMsg.setText("Số CMND/CCCD không hợp lệ!");
                        java.awt.Toolkit.getDefaultToolkit().beep();
                        
                    } else {
                        int maKH = Integer.parseInt(jtfMaKH.getText().trim().length() != 0? jtfMaKH.getText().trim() : "0");
                        String hoTen = jtfHoTen.getText().trim();
                        String diaChi = jtaDiaChi.getText().trim();
                        String CCCD = jtfCCCD.getText().trim();
                        Date ngaySinh = jdateNgaySinh.getDate();
                        String soDienThoai = jtfSoDienThoai.getText().trim();
                        khachHang = new KhachHang(maKH, hoTen, diaChi, CCCD, ngaySinh, soDienThoai);
                        if (showDialog()) {
                            int lastId = khachHangServiceImpl.createORUpdate(khachHang);
                            if (lastId != 0) {
                                khachHang.setMaKH(lastId);
                                jtfMaKH.setText("" + khachHang.getMaKH());
                                jlbMsg.setForeground(Color.GREEN);
                                jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                                JOptionPane.showMessageDialog(khachHangJDialog, "Xử lý cập nhật dữ liệu thành công!");

                            } else {
                                jlbMsg.setForeground(Color.red);
                                jlbMsg.setText("Có lỗi xảy ra, vui lòng thử lại!");
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                    jlbMsg.setText(ex.toString());
                } 
            }
            
        });
    }
    
    private boolean checkNull() {
        boolean check = jtfHoTen.getText().length() == 0 || jtfHoTen.getText().equalsIgnoreCase("") ||
                jtaDiaChi.getText().length() == 0 || jtaDiaChi.getText().equalsIgnoreCase("") ||
                jtfCCCD.getText().length() == 0 || jtfCCCD.getText().equalsIgnoreCase("") ||
                //jdateNgaySinh.getDate() == null ||
                jtfSoDienThoai.getText().length() == 0 || jtfSoDienThoai.getText().equalsIgnoreCase("");
        return check;
    }
    
    private boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(?:[0-9]??).{5,14}[0-9]$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    private boolean checkCCCD(String CCCD) {
        Pattern pattern = Pattern.compile("(^\\w{3}[0-9]{6}$)|(^\\w{1,2}[0-9]{7}$)|(^\\d{9}$)|(^\\d{12}$)");
        Matcher matcher = pattern.matcher(CCCD);
        return matcher.matches();
    }
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(khachHangJDialog,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
