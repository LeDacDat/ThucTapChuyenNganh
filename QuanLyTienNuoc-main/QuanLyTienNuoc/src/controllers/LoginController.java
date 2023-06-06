
package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.NhanVien;
import services.NhanVienService;
import services.NhanVienServiceImpl;

/**
 *
 * @author duato
 */
public class LoginController {
    private JFrame login;
    private JButton btnLogin;
    private JTextField jtfUserName;
    private JPasswordField jpfPassword;
    private JLabel jlbMessage;
    
    private NhanVienService nvService = null;

    public LoginController(JFrame login, JButton btnLogin, JTextField jtfUserName, JPasswordField jpfPassword, JLabel jlbMessage) {
        this.login = login;
        this.btnLogin = btnLogin;
        this.jtfUserName = jtfUserName;
        this.jpfPassword = jpfPassword;
        this.jlbMessage = jlbMessage;
        
        nvService = new NhanVienServiceImpl();
    }
    
    public void setEvent() {
        // Sự kiện kích vào jbuttonLogin
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginTracking();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new java.awt.Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new java.awt.Color(100, 221, 23));
            }
        });
        
        // bắt sự kiện ấn enter ở jtextfieldUserName
        jtfUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
                {
                    loginTracking();
                }
            }
            //Giới hạn ký tự nhập
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (jtfUserName.getText().length() > 32) // limit to 32 characters
                {
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        // bắt sự kiện ấn enter ở jpasswordfieldPassword
        jpfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
                {
                    loginTracking();
                }
            }
            //Giới hạn ký tự nhập
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (jpfPassword.getPassword().length >= 32) // limit to 32 characters
                {
                    e.consume();
                    java.awt.Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        
        
        
    }
    
    private void loginTracking()
    {
        try {
            if (jtfUserName.getText().trim().length() == 0 || jtfUserName.getText().trim().equalsIgnoreCase("")
                    || String.valueOf(jpfPassword.getPassword()).trim().length() == 0 || String.valueOf(jpfPassword.getPassword()).trim().equalsIgnoreCase("")) {
                jlbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
                java.awt.Toolkit.getDefaultToolkit().beep();
            } else {
                String taiKhoan = jtfUserName.getText().trim();
                String matKhau = String.valueOf(jpfPassword.getPassword()).trim();
                String matKhauHash = models.Security.getMD5(matKhau);
                NhanVien nhanVien = nvService.getLogin(taiKhoan, matKhauHash);
                if (nhanVien == null) {
                    jlbMessage.setText("Tên đăng nhập hoặc mật khẩu không chính xác!");
                    java.awt.Toolkit.getDefaultToolkit().beep();
                } else {
                    login.dispose();
                    main.Main.nhanVien = nhanVien;
                    main.Main.mainFrame = new views.MainJFrame();
                    main.Main.mainFrame.setVisible(true);
                    JOptionPane.showMessageDialog(main.Main.mainFrame, "Xin chào, Nhóm 15!");
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            jlbMessage.setText(ex.toString());
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
}
