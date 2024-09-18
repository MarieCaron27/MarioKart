package View.GUI;

import Model.Entities.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class VehiculeTableModel extends AbstractTableModel
{
    public Vehicule myVehicule;
    public VehiculeTableModel(Vehicule vehicule)
    {
        myVehicule = vehicule;
    }

    @Override
    public Class<?> getColumnClass(int column)
    {
        if(column == 0 || column == 1 || column == 2)
        {
            return ImageIcon.class;
        }

        return null;
    }

    @Override
    public int getRowCount()
    {
        return 1;
    }

    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        Vehicule vehicule = myVehicule;

        if (columnIndex == 0)
        {
            Image img = vehicule.getPilot().getImageBuffered();

            Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImg);
        }

        if (columnIndex == 1)
        {
            Image img = vehicule.getBody().getImageBuffered();

            Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImg);
        }

        if (columnIndex == 2)
        {
            Image img = vehicule.getTire().getImageBuffered();

            Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImg);
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex)
    {
        return false;
    }

}
