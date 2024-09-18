package View.GUI;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class VehiculeTableColumnModel extends DefaultTableColumnModel
{
    public VehiculeTableColumnModel()
    {
        super();

        int[] columnsSize = {130, 130, 130};
        String[] columnsName = {"Pilote", "Kart","Pneu"};

        for (int i = 0; i < columnsSize.length; i++)
        {
            TableColumn column = new TableColumn(i, columnsSize[i]);
            column.setHeaderValue(columnsName[i]);
            addColumn(column);
        }
    }
}
