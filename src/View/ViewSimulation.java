package View;

import Model.Entities.Simulation;

public interface ViewSimulation
{
    void runSimulation();
    Simulation addSimulation();
    void showErrorMessage(String message);
}
