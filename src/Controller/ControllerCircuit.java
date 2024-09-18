package Controller;

import Model.DataAccessLayerCircuit;
import Model.Entities.Circuit;
import View.ViewCircuit;

import java.util.ArrayList;

public class ControllerCircuit
{
    private final DataAccessLayerCircuit daoCircuit;
    private final ViewCircuit viewCircuit;

    public ControllerCircuit(DataAccessLayerCircuit daoCircuit,ViewCircuit viewCircuit)
    {
        this.daoCircuit = daoCircuit;
        this.viewCircuit = viewCircuit;
        this.viewCircuit.setControllerCircuit(this);
    }

    public void runCircuit()
    {
        ArrayList<Circuit> circuits = daoCircuit.getCircuitList();
        viewCircuit.displayCircuits(circuits);
        viewCircuit.runCircuit();
    }
}
