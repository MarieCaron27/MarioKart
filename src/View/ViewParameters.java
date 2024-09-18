package View;

import Controller.ControllerParameters;
import Model.Entities.Parameters;

import java.util.ArrayList;

public interface ViewParameters
{
    void addANewParameter(Parameters param);
    void displayParameters(ArrayList<Parameters> parameters);
    void setControllerParameters(ControllerParameters c);
    void runParameters();
    void showMessage(String message);
    void showErrorMessage(String message);
}
