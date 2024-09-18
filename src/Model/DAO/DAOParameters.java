package Model.DAO;

import Model.DataAccessLayerParameters;
import Model.Entities.Body;
import Model.Entities.Parameters;
import Model.Entities.Pilote;
import Model.Entities.Tire;

import java.util.ArrayList;

public class DAOParameters implements DataAccessLayerParameters
{
    private final ArrayList<Parameters> myParameters;
    private static int idCourant = 1;

    public DAOParameters()
    {
        myParameters = new ArrayList<>();
        initializeComponents();
    }

    @Override
    public int addParameter(Parameters param)
    {
        if(param == null)
        {
            return -1;
        }

        param.setId(idCourant);
        idCourant++;

        myParameters.add(param);
        return param.getIdentity();
    }

    @Override
    public Parameters getParameterById(int id)
    {
        for(Parameters param:myParameters)
        {
            if (param instanceof Body body)
            {
                return body.clone(body.getIdentity(),body.getAcceleration(),body.getHandling(),body.getImage().toString(),body.getName(),body.getSpeed(),body.getTraction(),body.getWeight());
            }
            else if (param instanceof Pilote driver)
            {
                return driver.clone(driver.getIdentity(),driver.getAcceleration(),driver.getHandling(),driver.getImage().toString(),driver.getName(),driver.getSpeed(),driver.getTraction(),driver.getWeight());
            }
            else if (param instanceof Tire tire)
            {
                return tire.clone(tire.getIdentity(),tire.getAcceleration(),tire.getHandling(),tire.getImage().toString(),tire.getName(),tire.getSpeed(),tire.getTraction(),tire.getWeight());
            }
        }

        return null;
    }

    @Override
    public String ToString()
    {
        return "DAO {" + "Paramètres :" + myParameters + "}";
    }

    @Override
    public ArrayList<Parameters> getParametersList()
    {
        ArrayList<Parameters> copy = new ArrayList<>();

        for(Parameters param : myParameters)
        {
            switch(param)
            {
                case Body body:
                {
                    copy.add(body.clone(body.getIdentity(),body.getAcceleration(),body.getHandling(),body.getImage().toString(),body.getName(),body.getSpeed(),body.getTraction(),body.getWeight()));
                }
                break;

                case Pilote driver:
                {
                    copy.add(driver.clone(driver.getIdentity(),driver.getAcceleration(),driver.getHandling(),driver.getImage().toString(),driver.getName(),driver.getSpeed(),driver.getTraction(),driver.getWeight()));
                }
                break;

                case Tire tire:
                {
                    copy.add(tire.clone(tire.getIdentity(),tire.getAcceleration(),tire.getHandling(),tire.getImage().toString(),tire.getName(),tire.getSpeed(),tire.getTraction(),tire.getWeight()));
                }
                break;

                default:
                {
                    return null;
                }
            }
        }

        return copy;
    }

    public void initializeComponents()
    {
        try
        {
            //PILOTES :
            addParameter(new Pilote(3, 5, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Birdo.png", "Birdo", 6, 3, 4));
            addParameter(new Pilote(0, 0, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Browser.png", "Browser", 10, 0, 10));
            addParameter(new Pilote(3, 5, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Daisy.png", "Daisy", 6, 3, 4));
            addParameter(new Pilote(1, 2, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Donkey.png", "Donkey", 9, 0, 8));
            addParameter(new Pilote(1, 3, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Link.png", "Link", 8, 3, 7));
            addParameter(new Pilote(2, 5, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Luigi.png", "Luigi", 7, 1, 6));
            addParameter(new Pilote(2, 4, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Mario.png", "Mario", 7, 2, 6));
            addParameter(new Pilote(3, 5, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Peach.png", "Peach", 6, 3, 4));
            addParameter(new Pilote(1, 3, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Link.png", "Link", 8, 3, 7));
            addParameter(new Pilote(1, 2, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Roy.png", "Roy", 9, 0, 8));
            addParameter(new Pilote(4, 7, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Toad.png", "Toad", 4, 4, 3));
            addParameter(new Pilote(5, 7, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Toadette.png", "Toadette", 3, 2, 2));
            addParameter(new Pilote(1, 2, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Waluigi.png", "Waluigi", 9, 0, 8));
            addParameter(new Pilote(0, 1, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Wario.png", "Wario", 10, 1, 9));
            addParameter(new Pilote(3, 5, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Pilote\\Yoshi.png", "Yoshi", 6, 3, 4));

            //BODIES :
            addParameter(new Body(6.4, 5.6, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart1.png", "Mario's Standard MR", 6.4, 5.7, 6.4));
            addParameter(new Body(7.4, 7.3, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart2.png", "Luigi's Standard LG", 7.2, 3.2, 6.4));
            addParameter(new Body(7.3, 4.8, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart3.png", "Princess Peach's Standard PC", 4.7, 9.7, 6.4));
            addParameter(new Body(9, 8.4, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart4.png", "Yoshi's Standard YS", 5.5, 3.9, 6.4));
            addParameter(new Body(3, 2.8, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart5.png", "Bowser's Standard BW", 9.6, 6.7, 6.4));
            addParameter(new Body(5, 4.8, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Body\\Kart6.png", "Wario's Standard WR", 8.8, 4.7, 6.4));

            //TIRES :
            addParameter(new Tire(0.25, 1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire1.png", "Slim", -0.25, 1, -0.25));
            addParameter(new Tire(-0.5, -1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire2.png", "Red Monster", 0.75, -1, 0.75));
            addParameter(new Tire(0.75, 2, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire3.png", "Roller", -0.75, -1, -1));
            addParameter(new Tire(0, 0, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire4.png", "Standard", 0, 0, 0));
            addParameter(new Tire(-0.75, -1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire5.png", "Monster", 0.75, 0, 1));
            addParameter(new Tire(0.5, 1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire6.png", "Wood", -0.5, 1, -0.5));
            addParameter(new Tire(0.5, 0, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire7.png", "Sponge", -0.25, 1, -0.75));
            addParameter(new Tire(-0.25, -1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire8.png", "Slick", 1, 1, 0.25));
            addParameter(new Tire(-0.5, -1.25, "C:\\Users\\Utilisateur\\Desktop\\Projets\\Java\\Mario_au_kart\\src\\Model\\Pictures\\Tire\\Tire9.png", "Gold Tire", 1, -1, 0.5));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
