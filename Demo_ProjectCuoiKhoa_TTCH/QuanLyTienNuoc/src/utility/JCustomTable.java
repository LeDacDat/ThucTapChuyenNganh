
package utility;

import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class JCustomTable {
    private JTable _jTable;
    private DefaultTableModel _defaultTableModel;
    private TableRowSorter<TableModel> _tableRowSorter;
    private JScrollPane _jScrollPane = null;

    public JCustomTable() {}
    
    public JCustomTable(JTable _jTable, DefaultTableModel _defaultTableModel, TableRowSorter<TableModel> _tableRowSorter, JScrollPane _jScrollPane) {
        this._jTable = _jTable;
        this._defaultTableModel = _defaultTableModel;
        this._tableRowSorter = _tableRowSorter;
        this._jScrollPane = _jScrollPane;
    }
    
    public JTable getJTable(){
        return _jTable;
    }
    
    public JScrollPane getJScrollPane(){
        return _jScrollPane;
    }
    
    public void addRow(List<Object> rowData){
        _defaultTableModel.addRow(rowData.toArray());
    }
    
    public void addRows(List<List<Object>> rowDatas){
        int nRow = rowDatas.size();
        for (int i = 0; i < nRow; i++){
            List<Object> rowData = rowDatas.get(i);
            addRow(rowData);
        }
    }
    
    public void clear(){
        int nRow = _defaultTableModel.getRowCount();
        for (int i = nRow - 1; i >= 0; i--){
            _defaultTableModel.removeRow(i);
        }
    }
    
    public void filter(String filterString){
        if (filterString == null || filterString.isEmpty()){
            _tableRowSorter.setRowFilter(null);
        }
        else{
            _tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterString));
        }
    }
}