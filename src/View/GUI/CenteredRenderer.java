package View.GUI;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JLabel;

public class CenteredRenderer extends DefaultTableCellRenderer
{
    public CenteredRenderer()
    {
        setHorizontalAlignment(JLabel.CENTER);
    }
}