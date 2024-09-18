package Model.Entities;

public class Body extends Parameters
{
    //Constructeurs :
    public Body(double a,double h,String iPath,String n,double s,double t,double w)
    {
        super(a,h,iPath,n,s,t,w);
    }

    //To String method :
    public String toString()
    {
        return "Carrosserie{" +
                "id =" + getIdentity() +
                ", acceleration ='" + getAcceleration() +
                ", handling =" + getHandling() +
                ", image =" + getImage().toString() +
                ", nom =" + getName() +
                ", vitesse =" + getSpeed() +
                ", traction =" + getTraction() +
                ", poids =" + getWeight() +
                '}';
    }

    //Clone method :
    public Body clone(int id,double a,double h,String iPath,String n,double s,double t,double w)
    {
        Body copy = new Body(a,h,iPath,n,s,t,w);
        copy.setId(id);
        return copy;
    }

    //Equals method :
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body b = (Body) o;
        return this.getIdentity() == b.getIdentity();
    }
}
