package Model.Entities;

public class Vehicule
{
    //Fields :
    private int id;
    private Body body;
    private Pilote pilot;
    private Tire tire;

    //Constructors :
    public Vehicule(Body b,Pilote p,Tire t)
    {
        setBody(b);
        setPilot(p);
        setTire(t);
    }

    //Setters :

    public void setId(int id)
    {
        this.id = id;
    }

    public void setBody(Body body)
    {
        this.body = body;
    }

    public void setPilot(Pilote pilot)
    {
        this.pilot = pilot;
    }

    public void setTire(Tire tire)
    {
        this.tire = tire;
    }

    //Getters :

    public int getId()
    {
        return id;
    }

    public Body getBody()
    {
        return body;
    }

    public Pilote getPilot()
    {
        return pilot;
    }

    //Getters for parameters :
    public Tire getTire()
    {
        return tire;
    }

    public double getAcceleration()
    {
        return body.getAcceleration() + pilot.getAcceleration() + (4*tire.getAcceleration());
    }

    public double getHandling()
    {
        return body.getHandling() + pilot.getHandling() + (4*tire.getHandling());
    }

    public double getSpeed()
    {
        return body.getSpeed() + pilot.getSpeed() + (4*tire.getSpeed());
    }

    public double getTraction()
    {
        return body.getTraction() + pilot.getTraction() + (4*tire.getTraction());
    }

    public double getWeight()
    {
        return body.getWeight() + pilot.getWeight() + (4*tire.getWeight());
    }

    //ToString method :

    public String toString()
    {
        return "Véhicule{" +
                "id =" + getId() +
                ", carrosserie =" + getBody() +
                ", pilote =" + getPilot() +
                ", pneus =" + getTire() +
                ", acceleration =" + getAcceleration() +
                ", handling =" + getHandling() +
                ", vitesse =" + getSpeed() +
                ", traction =" + getTraction() +
                ", poids =" + getWeight() +
                '}';
    }

    public Vehicule clone(int id, Body body, Pilote pilote, Tire tire)
    {
        Vehicule copy = new Vehicule(body, pilote, tire);
        copy.setId(id);

        return copy;
    }

    //Equals method :
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }

        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Vehicule b = (Vehicule) o;

        return this.getId() == b.getId() && this.getBody() == b.getBody() &&
                this.getPilot() == b.getPilot() &&
                this.getTire() == b.getTire();
    }
}
