package Model.DAO;

import Model.DataAccessLayerCircuit;
import Model.Entities.*;

import java.util.ArrayList;

public class DAOCircuit implements DataAccessLayerCircuit
{
    private final ArrayList<Circuit> myCircuits;
    private static int idCourant = 1;

    public DAOCircuit()
    {
        myCircuits = new ArrayList<>();
        initializeComponents();
    }

    @Override
    public int addCircuit(Circuit c)
    {
        if (c == null)
        {
            return -1;
        }

        c.setId(idCourant);
        idCourant++;
        myCircuits.add(c);
        return c.getId();
    }

    @Override
    public Circuit getCircuit(int id)
    {
        for (Circuit c:myCircuits)
        {
            if (c.getId() == id)
            {
                return c.clone(c.getId());
            }
        }
        return null;
    }

    @Override
    public Circuit getCircuitByName(String name)
    {
        for (Circuit c : myCircuits)
        {
            if (c.getName().equals(name))
            {
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Circuit> getCircuitList()
    {
        ArrayList<Circuit> copy = new ArrayList<>();

        for (Circuit c : myCircuits)
        {
            copy.add(c.clone(c.getId()));
        }

        return copy;
    }

    public void initializeComponents()
    {
        try
        {
            Circuit circuit1 = new Circuit();
            circuit1.addSection(new Straight(50));
            circuit1.addSection(new Curve(20, 60));
            circuit1.addSection(new Straight(30));
            circuit1.addSection(new Curve(10, 30));
            circuit1.addSection(new Straight(40));
            circuit1.addSection(new Curve(20, 30));
            circuit1.setName("Circuit 1");
            addCircuit(circuit1);

            Circuit circuit2 = new Circuit();
            circuit2.addSection(new Straight(50));
            circuit2.addSection(new Curve(20, 60));
            circuit2.addSection(new Straight(30));
            circuit2.addSection(new Curve(10, 30));
            circuit2.addSection(new Straight(40));
            circuit2.addSection(new Curve(20, 30));
            circuit2.addSection(new Straight(20));
            circuit2.addSection(new Curve(30, 90));
            circuit2.setName("Circuit 2");
            addCircuit(circuit2);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
