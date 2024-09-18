package View.GUI;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class PilotesTableColumnModel extends DefaultTableColumnModel
{
    public PilotesTableColumnModel()
    {
        super();

        int[] columnsSize = {130, 130};

        for (int i = 0; i < columnsSize.length; i++)
        {
            TableColumn column = new TableColumn(i, columnsSize[i]);
            addColumn(column);
        }
    }
}
