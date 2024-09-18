package View.GUI;

import Model.Entities.Body;
import Model.Entities.Parameters;
import Model.Entities.Tire;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class OtherTableModel<T extends Parameters> extends AbstractTableModel
{
    public ArrayList<T> myParameters;
    public OtherTableModel(ArrayList<T> param)
    {
        myParameters = param;
    }

    @Override
    public Class<?> getColumnClass(int column)
    {
        if(column == 0)
        {
            return ImageIcon.class;
        }

        return null;
    }

    @Override
    public int getRowCount()
    {
        return myParameters.size();
    }

    @Override
    public int getColumnCount()
    {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        Parameters p = myParameters.get(rowIndex);

        if (columnIndex == 0)
        {
            Image img = p.getImageBuffered();

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

    public Parameters getParameterAt(int index)
    {
        Parameters p = myParameters.get(index);

        if (p instanceof Body body)
        {
            return body.clone(body.getIdentity(),body.getAcceleration(),body.getHandling(),body.getImage().toString(),body.getName(),body.getSpeed(),body.getTraction(),body.getWeight());
        }
        else if (p instanceof Tire t)
        {
            return t.clone(t.getIdentity(),t.getAcceleration(),t.getHandling(),t.getImage().toString(),t.getName(),t.getSpeed(),t.getTraction(),t.getWeight());
        }

        return null;
    }
}
