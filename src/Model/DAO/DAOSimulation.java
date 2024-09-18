package Model.DAO;

import Model.DataAccessLayerCircuit;
import Model.DataAccessLayerSimulation;
import Model.Entities.*;

import Model.DataAccessLayerVehicule;
import Model.DataAccessLayerParameters;

import java.util.ArrayList;

public class DAOSimulation implements DataAccessLayerSimulation
{
    private final ArrayList<Simulation> mySimulations;
    private static Vehicule vehicule;
    private static Circuit circuit;
    private static double rainIndex;
    private static int idCourant = 1;

    public DAOSimulation()
    {
        mySimulations = new ArrayList<>();
    }

    @Override
    public void initializeComponents(Vehicule v,Circuit c,double rI)
    {
        vehicule = v;
        circuit = c;
        rainIndex = rI;
    }

    @Override
    public int addSimulation(Simulation simulation)
    {
        if (simulation == null)
        {
            return -1;
        }

        simulation.setId(idCourant);
        idCourant++;
        mySimulations.add(simulation);

        return simulation.getId();
    }

    @Override
    public String toString()
    {
        return "DAOSimulation{" +
                "Simulation = " + mySimulations +
                '}';
    }

    @Override
    public Simulation getSimulation(int id)
    {
        for (Simulation s:mySimulations)
        {
            if (s.getId() == id)
            {
                return s.clone(id,s.getCircuit(),s.getVehicle(),s.getRainIndex());
            }
        }
        return null;
    }

    @Override
    public ArrayList<Simulation> getSimulationList()
    {
        ArrayList<Simulation> copy = new ArrayList<>();

        for (Simulation s : mySimulations)
        {
            copy.add(s.clone(s.getId(),s.getCircuit(),s.getVehicle(),s.getRainIndex()));
        }

        return copy;
    }

    public static void main(String[] args)
    {
        DataAccessLayerSimulation dao = new DAOSimulation();
        DataAccessLayerVehicule daoVehicule = new DAOVehicule();
        DataAccessLayerCircuit daoCircuit = new DAOCircuit();

        // Initialize the components
        Vehicule myVehicule = daoVehicule.getVehicule(1);
        Circuit myCircuit = daoCircuit.getCircuit(1);

        double rainIndex = 0.5;

        try
        {
            dao.addSimulation(new Simulation(myCircuit, myVehicule, rainIndex));
            System.out.println(dao);
        }
        catch (Exception e)
        {
            System.out.println("Erreur lors de l'ajout du véhicule : " + e.getMessage());
        }
    }
}
