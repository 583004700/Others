package views.pages.common;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
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
}
