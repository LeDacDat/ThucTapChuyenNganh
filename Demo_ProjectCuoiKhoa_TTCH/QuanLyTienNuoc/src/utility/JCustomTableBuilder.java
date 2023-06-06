
package utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Admin
 */
public class JCustomTableBuilder{
    private JTable _jTable;
    private final DefaultTableModel _defaultTableModel;
    private TableRowSorter<TableModel> _tableRowSorter;
    private final JScrollPane _jScrollPane;

    public JCustomTableBuilder(JScrollPane jScrollPane){
        _defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this._jScrollPane = jScrollPane;
        
        _jTable = new JTable(this._defaultTableModel){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
                Component comp = super.prepareRenderer(renderer, row, column);
                Color alternateColor = new Color(200, 201, 210);
                if(!comp.getBackground().equals(getSelectionBackground())) {
                Color c = (row % 2 == 0 ? alternateColor : Color.WHITE);
                    comp.setBackground(c);
                }
                return comp;
            }

            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };


        this._tableRowSorter = new TableRowSorter<>(this._defaultTableModel);

        _jTable.setFocusable(false);

        _jTable.setRowSorter(this._tableRowSorter);
        _jTable.setRowHeight(30);

        _jTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
        _jTable.getTableHeader().setBackground(new Color(96, 156, 59));
        _jTable.getTableHeader().setForeground(Color.WHITE);
        _jTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

        _jTable.setSelectionBackground(new Color(169, 201, 255));
        _jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        _jTable.validate();
        _jTable.repaint();

        //_jScrollPane.getViewport().add(jTable);
        _jScrollPane.setViewportView(_jTable);
    }

    public JCustomTableBuilder addColumnName(String columnName){
        this._defaultTableModel.addColumn(columnName);
        return this;
    }
    
    public JCustomTableBuilder hideColumn(int index){
        _jTable.getColumnModel().getColumn(index).setMinWidth(0);
        _jTable.getColumnModel().getColumn(index).setMaxWidth(0);
        _jTable.getColumnModel().getColumn(index).setPreferredWidth(0);
        return this;
    } 

    public JCustomTable build(){
        JCustomTable jCustomTable = new JCustomTable(_jTable, _defaultTableModel, _tableRowSorter, _jScrollPane);
        
        return jCustomTable;
    }
}
