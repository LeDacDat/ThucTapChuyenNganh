/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.LoginJFrame;

/**
 *
 * @author turborvip
 */
public class Main {
    public static javax.swing.JFrame mainFrame = null;
    public static models.NhanVien nhanVien = null;
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If you face with ERROR : "cannot access class sun.swing.DefaultLookup (in module java.desktop)"
         * Use --illegal-access=warn to enable warnings of further illegal reflective access operations
         * BECAUSE: All illegal access operations will be denied in a future release
         */
        try {
            UIManager.setLookAndFeel(new de.javasoft.synthetica.simple2d.SyntheticaSimple2DLookAndFeel());
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessError ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //mainFrame = new MainJFrame();
        //mainFrame.setVisible(true);
        
        /* Create and display the login form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginJFrame().setVisible(true);
        });
    }
}
