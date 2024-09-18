package View;

import Controller.ControllerCircuit;
import Model.Entities.Circuit;

import java.util.ArrayList;

public interface ViewCircuit
{
    void displayCircuits(ArrayList<Circuit> circuits);
    void runCircuit();
    void setControllerCircuit(ControllerCircuit controllerCircuit);
}
