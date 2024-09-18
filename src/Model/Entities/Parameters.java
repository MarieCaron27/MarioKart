package Model.Entities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Parameters
{
    //Fields :
    protected int identity;
    protected double acceleration;
    protected double handling;
    protected ImageIcon imageIcon;
    protected BufferedImage image;
    protected String name;
    protected double speed;
    protected double traction;
    protected double weight;

    //Constructors :
    public Parameters(double a,double h,String iPath,String n,double s,double t,double w)
    {
        setAcceleration(a);
        setHandling(h);
        setImage(iPath);
        setName(n);
        setSpeed(s);
        setTraction(t);
        setWeight(w);
    }

    //Setters :
    public void setId(int id)
    {
        identity = id;
    }

    public void setAcceleration(double a)
    {
        acceleration = a;
    }

    public void setHandling(double h)
    {
        handling = h;
    }

    public void setImage(String imagePath)
    {
        try
        {
            File file = new File(imagePath);
            if (!file.exists())
            {
                System.err.println("Le fichier d'image n'existe pas : " + imagePath);
                return;
            }

            imageIcon = new ImageIcon(imagePath);
            image = ImageIO.read(file);

        }
        catch (IOException e)
        {
            System.err.println("Erreur lors de la lecture du fichier d'image : " + imagePath);
            e.printStackTrace();
        }
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setSpeed(double s)
    {
        speed = s;
    }

    public void setTraction(double t)
    {
        traction = t;
    }

    public void setWeight(double w)
    {
        weight = w;
    }

    //Getters :
    public int getIdentity()
    {
        return identity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getHandling() {
        return handling;
    }

    public ImageIcon getImage()
    {
        return imageIcon;
    }

    public BufferedImage getImageBuffered()
    {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getTraction() {
        return traction;
    }

    public double getWeight()
    {
        return weight;
    }

    //Clone method :
    public abstract Parameters clone(int id, double a, double h, String iPath, String n, double s, double t, double w);

}
