package View.GUI;

import Model.Entities.Pilote;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PilotesTableModel extends AbstractTableModel
{
    public ArrayList<Pilote> myPilotes;
    public PilotesTableModel(ArrayList<Pilote> pilote)
    {
        myPilotes = pilote;
    }

    @Override
    public Class<?> getColumnClass(int column)
    {
        if(column == 0)
        {
            return ImageIcon.class;
        }

        if (column == 1)
        {
            return String.class;
        }

        return null;
    }

    @Override
    public int getRowCount()
    {
        return myPilotes.size();
    }

    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        Pilote p = myPilotes.get(rowIndex);

        if (columnIndex == 0)
        {
            Image img = p.getImageBuffered();

            Image scaledImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImg);
        }

        if (columnIndex == 1)
        {
            return p.getName();
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex,int columnIndex)
    {
        return false;
    }

    public Pilote getParameterAt(int index)
    {
        Pilote pilote = myPilotes.get(index);

        return pilote.clone(pilote.getIdentity(),pilote.getAcceleration(),pilote.getHandling(),pilote.getImage().toString(),pilote.getName(),pilote.getSpeed(),pilote.getTraction(),pilote.getWeight());
    }
}
