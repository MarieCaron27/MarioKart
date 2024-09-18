package View.GUI;

import Model.Entities.Body;
import Model.Entities.Parameters;
import Model.Entities.Pilote;
import Model.Entities.Tire;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ParametersTableModel<T extends Parameters> extends AbstractTableModel
{
    public ArrayList<T> myParameters;
    public ParametersTableModel(ArrayList<T> param)
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

        if(column==1)
        {
            return String.class;
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

        if(columnIndex == 1)
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

    public Parameters getParameterAt(int index)
    {
        Parameters param = myParameters.get(index);

        if (param instanceof Body body)
        {
            return body.clone(body.getIdentity(),body.getAcceleration(),body.getHandling(),body.getImage().toString(),body.getName(),body.getSpeed(),body.getTraction(),body.getWeight());
        }
        else if (param instanceof Tire t)
        {
            return t.clone(t.getIdentity(),t.getAcceleration(),t.getHandling(),t.getImage().toString(),t.getName(),t.getSpeed(),t.getTraction(),t.getWeight());
        }
        else if (param instanceof Pilote p)
        {
            return p.clone(p.getIdentity(),p.getAcceleration(),p.getHandling(),p.getImage().toString(),p.getName(),p.getSpeed(),p.getTraction(),p.getWeight());
        }

        return null;
    }
}
