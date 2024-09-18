package Controller;

import Model.DataAccessLayerParameters;
import Model.Entities.Parameters;
import View.ViewParameters;

import java.util.ArrayList;

public class ControllerParameters
{
    private final DataAccessLayerParameters daoParameters;
    private final ViewParameters viewParameters;

    public ControllerParameters(DataAccessLayerParameters daoParameters,ViewParameters viewParameters)
    {
        this.daoParameters = daoParameters;
        this.viewParameters = viewParameters;
        this.viewParameters.setControllerParameters(this);
    }

    public void runParameters()
    {
        ArrayList<Parameters> parameters = daoParameters.getParametersList();
        viewParameters.displayParameters(parameters);
        viewParameters.runParameters();
    }
}
