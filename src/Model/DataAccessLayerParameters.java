package Model;

import Model.Entities.Parameters;

import java.util.ArrayList;

public interface DataAccessLayerParameters
{
    int addParameter(Parameters param);
    Parameters getParameterById(int id);
    String ToString();
    ArrayList<Parameters> getParametersList();
}
