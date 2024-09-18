package Model.Entities;

public class Tire extends Parameters
{
    //Constructeur d'initialisation :
    public Tire(double a,double h,String iPath,String n,double s,double t,double w)
    {
        super(a,h,iPath,n,s,t,w);
    }

    //To String method :
    public String toString()
    {
        return "Tire{" +
                "id =" + getIdentity() +
                ", acceleration =" + getAcceleration() +
                ", handling =" + getHandling() +
                ", image =" + getImage().toString() +
                ", nom =" + getName() +
                ", vitesse =" + getSpeed() +
                ", traction =" + getTraction() +
                ", poids =" + getWeight() +
                '}';
    }

    //Clone method :
    public Tire clone(int id,double a,double h,String iPath,String n,double s,double t,double w)
    {
        Tire copy = new Tire(a,h,iPath,n,s,t,w);
        copy.setId(id);
        return copy;
    }

    //Equals method :
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tire t = (Tire) o;
        return this.getIdentity() == t.getIdentity();
    }
}
