package Model;

import Model.Entities.Vehicule;

import java.util.ArrayList;

public interface DataAccessLayerVehicule
{
    int addVehicule(Vehicule v);
    String toString();
    ArrayList<Vehicule> getVehiculeList();
    Vehicule getVehicule(int id);
}
