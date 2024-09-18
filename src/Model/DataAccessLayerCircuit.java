package Model;

import Model.Entities.Circuit;
import java.util.ArrayList;

public interface DataAccessLayerCircuit
{
    int addCircuit(Circuit c);
    ArrayList<Circuit> getCircuitList();

    Circuit getCircuit(int id);

    Circuit getCircuitByName(String name);
}