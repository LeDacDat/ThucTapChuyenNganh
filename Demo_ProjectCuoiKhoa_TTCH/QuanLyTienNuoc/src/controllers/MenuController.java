
package controllers;

import javax.swing.JOptionPane;
import main.Main;
import views.NhanVienDialog;

/**
 *
 * @author duato
 */
public class MenuController {

    public MenuController() {
    }
    
    public static void setMenuBar(javax.swing.JMenuBar jMenuBar) {
        
        /* jMenuHeThong (jMenuItemUser, Separator, jMenuItemLogout, jMenuItemExit) */
        javax.swing.JMenu jMenuHeThong = new javax.swing.JMenu();
        jMenuHeThong.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/system.png"))); // NOI18N
        jMenuHeThong.setMnemonic('H');
        jMenuHeThong.setText("Hệ Thống");
        
        // Chỉ thêm nếu là admin 
        if (main.Main.nhanVien.getChucVu().equalsIgnoreCase("QuanLy")) {
            
    
            javax.swing.JMenuItem jMenuItemUser = new javax.swing.JMenuItem();
            jMenuItemUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
            jMenuItemUser.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/user.png"))); // NOI18N
            jMenuItemUser.setText("Người dùng");
            jMenuItemUser.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    new NhanVienDialog(Main.mainFrame, true).setVisible(true);
                }
            });
            jMenuHeThong.add(new javax.swing.JPopupMenu.Separator());
            // Add  menu
            jMenuHeThong.add(jMenuItemUser);
        }

        javax.swing.JMenuItem jMenuItemLogout = new javax.swing.JMenuItem();
        jMenuItemLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemLogout.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/logout.png"))); // NOI18N
        jMenuItemLogout.setText("Đăng xuất");
        jMenuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int dialogResult = JOptionPane.showConfirmDialog(main.Main.mainFrame,
                                "Bạn muốn đăng xuất khỏi hệ thống?", "Thoát khỏi phiên" , JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION) {
                    //destroy session data
                    main.Main.nhanVien = null;
                    new views.LoginJFrame().setVisible(true);
                    main.Main.mainFrame.dispose();
                }
            }
        });

        javax.swing.JMenuItem jMenuItemExit = new javax.swing.JMenuItem();
        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemExit.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/power-button.png"))); // NOI18N
        jMenuItemExit.setText("Thoát");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int dialogResult = JOptionPane.showConfirmDialog(main.Main.mainFrame,
                        "Bạn muốn thoát khỏi hệ thống?", "Đóng chương trình", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    //destroy session data
                    main.Main.nhanVien = null;
                    System.exit(0);
                }
            }
        });
        // Thêm 
        jMenuHeThong.add(jMenuItemLogout);
        jMenuHeThong.add(jMenuItemExit);


        /* jMenuHelp(jMenuItemOnDoc, jMenuItemShortCut, jMenuItemInfo) */
        javax.swing.JMenu jMenuHelp = new javax.swing.JMenu();
        jMenuHelp.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/help.png"))); // NOI18N
        jMenuHelp.setMnemonic('T');
        jMenuHelp.setText("Trợ giúp");

        javax.swing.JMenuItem jMenuItemOnDoc = new javax.swing.JMenuItem();
        jMenuItemOnDoc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemOnDoc.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/online-help.png"))); // NOI18N
        jMenuItemOnDoc.setText("Tài liệu");
        jMenuItemOnDoc.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String url = "";
                String myOS = System.getProperty("os.name").toLowerCase();
                try {
                    if (java.awt.Desktop.isDesktopSupported()) { // Probably Windows
                        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                        desktop.browse(new java.net.URI(url));
                    } else { // Definitely Non-windows
                        Runtime runtime = Runtime.getRuntime();
                        if (myOS.contains("mac")) { // Apples
                            runtime.exec("open " + url);
                        } else if (myOS.contains("nix") || myOS.contains("nux")) { // Linux flavours 
                            runtime.exec("xdg-open " + url);
                        } else {
                            JOptionPane.showMessageDialog(main.Main.mainFrame, "I was unable/unwilling to launch a browser in your OS :(\n" 
                                    + "Please open it in your browser: ");
                        }
                    }
                } catch (java.io.IOException | java.net.URISyntaxException eek) {
                }
            }
        });

        javax.swing.JMenuItem jMenuItemShortCut = new javax.swing.JMenuItem();
        jMenuItemShortCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemShortCut.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/shortcut.png"))); // NOI18N
        jMenuItemShortCut.setText("Phím tắt");
        jMenuItemShortCut.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String textBlock = "- Ph\u00edm t\u1eaft\n" + "Alt+H : Menu h\u1ec7 th\u1ed1ng\n" + "Alt+T : Menu Tr\u1ee3 gi\u00fap\n" + "- Ph\u00edm t\u0103ng t\u1ed1c\n" + "Ctrl + U: Qu\u1ea3n l\u00fd ng\u01b0\u1eddi d\u00f9ng (admin only)\n" + "Ctrl + E: \u0110\u0103ng xu\u1ea5t h\u1ec7 th\u1ed1ng\n" + "Ctrl + ESC: Tho\u00e1t\n" + "Ctrl + P: T\u00e0i li\u1ec7u s\u1eed d\u1ee5ng\n" + "Ctrl + T: M\u1edf menu ph\u00edm t\u1eaft\n" + "Ctrl + I: Th\u00f4ng tin ph\u1ea7n m\u1ec1m\n";
                JOptionPane.showMessageDialog(main.Main.mainFrame, textBlock, "DANH SÁCH PHÍM TẮT", JOptionPane.INFORMATION_MESSAGE);
                
            }
        });

        javax.swing.JMenuItem jMenuItemInfo = new javax.swing.JMenuItem();
        jMenuItemInfo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemInfo.setIcon(new javax.swing.ImageIcon(MenuController.class.getResource("/images/information.png"))); // NOI18N
        jMenuItemInfo.setText("Thông tin");
        jMenuItemInfo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String textBlock =  "B\u00e0i t\u1eadp l\u1edbn: L\u1eadp tr\u00ecnh Java\n" + "Ph\u1ea7n m\u1ec1m qu\u1ea3n l\u00fd ho\u00e1 \u0111\u01a1n ti\u1ec1n \u0111i\u1ec7n Java Swing\n" + "\n" + "Nh\u00f3m 18: H\u1ea3o, Nam, Trung\n" + "\n" + "\u00a92020-2021\n";
                JOptionPane.showMessageDialog(main.Main.mainFrame, textBlock, "TH\u00d4NG TIN PH\u1ea6N M\u1ec0M\n", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jMenuHelp.add(jMenuItemOnDoc);
        jMenuHelp.add(jMenuItemShortCut);
        jMenuHelp.add(jMenuItemInfo);
        
        
        
        // THÊM VÀO JMENUBAR
        jMenuBar.add(jMenuHeThong);
        jMenuBar.add(jMenuHelp);

    }

}
