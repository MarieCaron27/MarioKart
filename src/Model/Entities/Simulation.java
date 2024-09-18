package Model.Entities;

public class Simulation implements Calculs
{
    private int identity;
    private Circuit circuit;
    private Vehicule vehicle;
    private double rainIndex;

    public Simulation(Circuit circuit, Vehicule vehicle, double rainIndex)
    {
        this.circuit = circuit;
        this.vehicle = vehicle;
        this.rainIndex = rainIndex;
    }

    public Vehicule getVehicule(){
        return this.vehicle;
    }

    @Override
    public double calculateTime()
    {
        double totalTime = 0;
        double currentSpeed = 0;

        for (Segment segment : circuit.getSegments())
        {
            double segmentTime = 0;
            if (segment instanceof Straight)
            {
                segmentTime = calculateStraightTime((Straight) segment, vehicle, currentSpeed, rainIndex);
                currentSpeed = vehicle.getSpeed();
            }
            else if (segment instanceof Curve)
            {
                segmentTime = calculateCurveTime((Curve) segment, vehicle, currentSpeed, rainIndex);
            }
            totalTime += segmentTime;
        }

        return totalTime;
    }

    private double calculateStraightTime(Straight straight, Vehicule vehicle, double initialSpeed, double rainIndex){
        double maxSpeed = vehicle.getSpeed();
        double acceleration = vehicle.getAcceleration();
        double traction = vehicle.getTraction();
        double adjustedAcceleration = Math.sqrt(acceleration * (traction * (1 - rainIndex)));

        double timeToMaxSpeed = (maxSpeed - initialSpeed) / adjustedAcceleration;

        double distanceToMaxSpeed = (initialSpeed * timeToMaxSpeed) + (0.5f * adjustedAcceleration * timeToMaxSpeed * timeToMaxSpeed);

        double remainingDistance = straight.getLength() - distanceToMaxSpeed;
        double timeAtMaxSpeed = remainingDistance / maxSpeed;

        return timeToMaxSpeed + timeAtMaxSpeed;
    }

    private double calculateCurveTime(Curve curve, Vehicule vehicle, double initialSpeed, double rainIndex)
    {
        double traction = vehicle.getTraction();
        double handling = vehicle.getHandling();
        double acceleration = vehicle.getAcceleration();
        double adjustedAcceleration = Math.sqrt(acceleration * (traction * (1 - rainIndex)));

        double maxCurveSpeed = Math.sqrt(handling * curve.getRadius() * (1 - rainIndex));
        while (maxCurveSpeed > vehicle.getSpeed()){
            maxCurveSpeed = Math.sqrt(maxCurveSpeed);
        }

        double timeToMaxSpeed = Math.abs((initialSpeed - maxCurveSpeed) / adjustedAcceleration);
        double distanceToMaxSpeed = (initialSpeed * timeToMaxSpeed) + (0.5f * adjustedAcceleration * timeToMaxSpeed * timeToMaxSpeed);

        if (distanceToMaxSpeed > curve.getLength()){
            distanceToMaxSpeed = curve.getLength();
            timeToMaxSpeed = (-initialSpeed + Math.sqrt(initialSpeed * initialSpeed + 2 * acceleration * curve.getLength())) / acceleration;
        }

        double remainingDistance = curve.getLength() - distanceToMaxSpeed;
        double timeAtMaxSpeed = remainingDistance / maxCurveSpeed;

        return timeAtMaxSpeed + timeToMaxSpeed;
    }

    //Setters :

    public void setId(int id)
    {
        identity = id;
    }

    public void setCircuit(Circuit c)
    {
        circuit = c;
    }

    public void setVehicle(Vehicule vehicle)
    {
        this.vehicle = vehicle;
    }

    public void setRainIndex(double rainIndex)
    {
        this.rainIndex = rainIndex;
    }

    //Getters :

    public int getId()
    {
        return identity;
    }

    public Circuit getCircuit()
    {
        return circuit;
    }

    public Vehicule getVehicle()
    {
        return vehicle;
    }

    public double getRainIndex()
    {
        return rainIndex;
    }

    //Clone method :
    public Simulation clone(int id,Circuit c, Vehicule v, double rI)
    {
        Simulation copy = new Simulation(c,v,rI);
        copy.setId(id);
        return copy;
    }
}