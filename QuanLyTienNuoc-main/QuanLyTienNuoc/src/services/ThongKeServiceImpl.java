
package services;

import dao.ThongKeDAOImpl;
import java.util.List;


public class ThongKeServiceImpl implements ThongKeService {

    ThongKeDAOImpl thongKeDAOImpl = new ThongKeDAOImpl();
    @Override
    public List<List<Object>> getRawData() {
        return thongKeDAOImpl.getRawData();
    }
    
}
