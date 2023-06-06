
package controllers;

import javax.swing.JScrollPane;
import services.ThongKeService;
import services.ThongKeServiceImpl;
import utility.JCustomTable;
import utility.JCustomTableBuilder;

/**
 *
 * @author Admin
 */
public class ThongKeController {
    JScrollPane jScrollPane_DoanhThuHangThang;
    public ThongKeController(JScrollPane jScrollPane_DoanhThuHangThang) {
        this.jScrollPane_DoanhThuHangThang = jScrollPane_DoanhThuHangThang;
    }
    
    JCustomTable jCustomTable_DoanhThuHangThang;
    ThongKeServiceImpl thongKeServiceImpl = new ThongKeServiceImpl();
    
    public void initTable(){
        jCustomTable_DoanhThuHangThang = new JCustomTableBuilder(jScrollPane_DoanhThuHangThang)
                .addColumnName("Mã tháng")
                .addColumnName("Ngày đầu")
                .addColumnName("Ngày cuối")
                .addColumnName("Tổng nước tiêu thụ trong tháng")
                .addColumnName("Tổng tiền nước tiêu thụ trong tháng")
                .build();
        
        jCustomTable_DoanhThuHangThang.clear();
        jCustomTable_DoanhThuHangThang.addRows(thongKeServiceImpl.getRawData());
    }
}
