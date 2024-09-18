package View;

import Model.Entities.Vehicule;

public interface ViewVehicule
{
    Vehicule getVehicule();
    Vehicule addANewVehicule(Vehicule vehicule);
    void displayVehicule(Vehicule v);
    void showMessage(String message);
    void showErrorMessage(String message);
}
