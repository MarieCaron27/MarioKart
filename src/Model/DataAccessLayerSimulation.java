package Model;

import Model.Entities.Circuit;
import Model.Entities.Simulation;
import Model.Entities.Vehicule;

import java.util.ArrayList;

public interface DataAccessLayerSimulation
{
    void initializeComponents(Vehicule v, Circuit c, double rI);
    int addSimulation(Simulation simulation);
    Simulation getSimulation(int id);
    ArrayList<Simulation> getSimulationList();

}
