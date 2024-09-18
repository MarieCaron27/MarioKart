import Controller.ControllerParameters;
import Model.DAO.DAOParameters;
import View.GUI.JFrameParameters;

public class Main
{
    public static void main(String[] args)
    {
        ControllerParameters controller = new ControllerParameters(new DAOParameters(),new JFrameParameters());
        controller.runParameters();

        /*  Commandes pour execution du .jar :

            C:\Users\Utilisateur\IdeaProjects\Laboratoire_conception_voitures\out\artifacts\Laboratoire_conception_de_voitures_jar

            dir

            java -jar Laboratoire_conception_de_voitures.jar
        */

    }
}
