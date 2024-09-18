package View.GUI;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class ParametersTableColumnModel extends DefaultTableColumnModel
{
    public ParametersTableColumnModel()
    {
        super();

        int[] taillesColonnes = {130, 50};

        for (int i = 0; i < taillesColonnes.length; i++) {
            TableColumn c = new TableColumn(i, taillesColonnes[i]);
            addColumn(c);
        }
    }
}
