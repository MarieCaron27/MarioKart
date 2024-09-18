package View.GUI;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class OtherTableColumnModel extends DefaultTableColumnModel
{
    public OtherTableColumnModel()
    {
        super();

        int columnsSize = 130;

        TableColumn column = new TableColumn(0, columnsSize);
        addColumn(column);
    }
}
