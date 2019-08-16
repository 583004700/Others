package views.pages.common;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.util.Enumeration;

/**
 * 设置每个table的公共样式
 */
public class CommonTable extends JTable {
    public CommonTable(TableModel tableModel){
        super(tableModel);
        this.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.setRowHeight(25);
        this.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * 设置列宽
     * @param index
     * @param preferredWidth
     */
    public void setPreferredWidth(int index,int preferredWidth){
        getColumnModel().getColumn(index).setPreferredWidth(preferredWidth);
    }

    /**
     * 获取所有列
     * @return
     */
    public Enumeration<TableColumn> getColumns(){
        return getColumnModel().getColumns();
    }

    /**
     * 移除某列
     * @param index
     */
    public void removeColumn(int index){
        getColumnModel().removeColumn(getColumnModel().getColumn(index));
    }

    /**
     * 隐藏列
     * @param index
     */
    public void hideColumn(int index){
        TableColumn tc= getColumnModel().getColumn(index);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        tc.setMinWidth(0);
        tc.setWidth(0);
        getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0);
        getTableHeader().getColumnModel().getColumn(index).setMinWidth(0);
    }

    public void clearData(){
        DefaultTableModel model = ((DefaultTableModel)getModel());
        while(model.getRowCount()>0){
            model.removeRow(model.getRowCount()-1);
        }
    }
}
