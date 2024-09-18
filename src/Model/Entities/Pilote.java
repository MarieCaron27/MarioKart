package Model.Entities;

public class Pilote extends Parameters
{
    //Constructeur d'initialisation :
    public Pilote(double a,double h,String iPath,String n,double s,double t,double w)
    {
        super(a,h,iPath,n,s,t,w);
    }

    //To String method :
    public String toString()
    {
        return "Pilote{" +
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
    public Pilote clone(int id,double a,double h,String iPath,String n,double s,double t,double w)
    {
        Pilote copy = new Pilote(a,h,iPath,n,s,t,w);
        copy.setId(id);
        return copy;
    }

    //Equals method :
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilote p = (Pilote) o;
        return this.getIdentity() == p.getIdentity();
    }
}
