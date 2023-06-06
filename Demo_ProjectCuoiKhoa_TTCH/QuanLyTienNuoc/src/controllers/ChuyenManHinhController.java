/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import views.ChiSoNuocJPanel;
import views.HoTieuThuJPanel;
import views.HoaDonJPanel;
import views.HomeJPanel;
import views.ThanhToanJPanel;
import views.ThongKeJPanel;

/**
 *
 * @author duato
 */
public class ChuyenManHinhController {
    private final JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;
    public ChuyenManHinhController(JPanel root) {
        this.root = root;
    }

    //JPanelView được set là HomeJPanel
    public void setDashboard(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "Home";
        //jpnItem.setBackground(new Color(96, 100, 191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomeJPanel());
        root.validate();
        root.repaint();
    }
    
    //Sự kiện đổi màu Menu và chuyển JPanelView
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        listItem.forEach(item -> {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        });
    }
    
    //Lớp sự kiện
    class LabelEvent implements MouseListener {
        
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) { //Khi click chọn Item
            node = switch (kind) {
                case "Home" -> new HomeJPanel();
                case "HoTieuThu" -> new HoTieuThuJPanel();
                case "ChiSoNuoc" -> new ChiSoNuocJPanel();
                case "ThanhToan" -> new ThanhToanJPanel();
                case "HoaDon" -> new HoaDonJPanel();
                case "ThongKe" -> new ThongKeJPanel();
                default -> new HomeJPanel();
            };
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) { //Khi di chuột vào Item
            kindSelected = kind;
            if (!kind.equalsIgnoreCase("Home"))
                jpnItem.setBackground(new Color(96, 100, 191));            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) { //Được triệu hồi khi một nút chuột ĐÃ được nhấn trên một thành phần.
            if(!kind.equalsIgnoreCase("Home")){
                jpnItem.setBackground(new Color(96, 100, 191));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) { //Được triệu hồi khi chuột thoát ra khỏi một thành phần
            if (!kindSelected.equalsIgnoreCase(kind) && !kind.equalsIgnoreCase("Home")) {
                jpnItem.setBackground(new Color(0, 153, 153));
            }
        }
        
    }
    
    private void setChangeBackground(String kind) { //đổi màu các Item khác khi một Item trong menu được chọn
        listItem.stream().filter(item -> (!item.getKind().equalsIgnoreCase("Home"))).forEachOrdered(item -> {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(0, 153, 153));
            }
        });
    }
}

