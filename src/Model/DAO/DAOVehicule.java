package Model.DAO;

import Model.Entities.Body;
import Model.Entities.Pilote;
import Model.Entities.Tire;
import Model.Entities.Vehicule;

import Model.DataAccessLayerVehicule;
import Model.DataAccessLayerParameters;

import java.util.ArrayList;

public class DAOVehicule implements DataAccessLayerVehicule
{
    private final ArrayList<Vehicule> myVehicules;
    private static Pilote myPilote;
    private static Body myBody;
    private static Tire myTire;
    private static int idCourant = 1;

    public DAOVehicule()
    {
        myVehicules = new ArrayList<>();
    }

    public void initializeComponents(Body b, Pilote p, Tire t)
    {
        myBody = b;
        myPilote = p;
        myTire = t;
    }

    @Override
    public int addVehicule(Vehicule v)
    {
        if (v == null)
        {
            return -1;
        }
        v.setId(idCourant);
        idCourant++;
        myVehicules.add(v);
        return v.getId();
    }

    @Override
    public String toString()
    {
        return "DAOVehicule{" +
                "vehicule = " + myVehicules +
                '}';
    }

    @Override
    public Vehicule getVehicule(int id)
    {
        for (Vehicule vehicule:myVehicules)
        {
            if (vehicule.getId() == id)
            {
                return vehicule.clone(id,vehicule.getBody(),vehicule.getPilot(),vehicule.getTire());
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vehicule> getVehiculeList()
    {
        ArrayList<Vehicule> copy = new ArrayList<>();

        for (Vehicule v : myVehicules)
        {
            copy.add(v.clone(v.getId(), myBody, myPilote, myTire));
        }

        return copy;
    }

    public static void main(String[] args)
    {
        DataAccessLayerVehicule dao = new DAOVehicule();
        DataAccessLayerParameters daoParameters = new DAOParameters();

        // Initialize the components from DAOParameters
        Body myBody = (Body) daoParameters.getParameterById(1);  // Assuming ID 1 exists
        Pilote myPilote = (Pilote) daoParameters.getParameterById(2);  // Assuming ID 2 exists
        Tire myTire = (Tire) daoParameters.getParameterById(3);  // Assuming ID 3 exists

        ((DAOVehicule) dao).initializeComponents(myBody, myPilote, myTire);

        try
        {
            dao.addVehicule(new Vehicule(myBody, myPilote, myTire));
            System.out.println(dao);
        }
        catch (Exception e)
        {
            System.out.println("Erreur lors de l'ajout du véhicule : " + e.getMessage());
        }
    }
}
