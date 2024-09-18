package View;

import Model.Entities.Body;
import Model.Entities.Pilote;
import Model.Entities.Tire;
import Model.Entities.Vehicule;

import java.io.*;

public class VehiculeFileManager
{
    // Save Vehicle data to a CSV file
    public static void saveVehiculeToFile(Vehicule vehicle, String filename)
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename)))
        {
            writer.println(vehicle.getPilot().getAcceleration() + "," +
                    vehicle.getPilot().getHandling() + "," +
                    vehicle.getPilot().getImage().toString() + "," +
                    vehicle.getPilot().getName() + "," +
                    vehicle.getPilot().getSpeed() + "," +
                    vehicle.getPilot().getTraction() + "," +
                    vehicle.getPilot().getWeight() + "," +
                    vehicle.getBody().getAcceleration() + "," +
                    vehicle.getBody().getHandling() + "," +
                    vehicle.getBody().getImage().toString() + "," +
                    vehicle.getBody().getName() + "," +
                    vehicle.getBody().getSpeed() + "," +
                    vehicle.getBody().getTraction() + "," +
                    vehicle.getBody().getWeight() + "," +
                    vehicle.getTire().getAcceleration() + "," +
                    vehicle.getTire().getHandling() + "," +
                    vehicle.getTire().getImage().toString() + "," +
                    vehicle.getTire().getName() + "," +
                    vehicle.getTire().getSpeed() + "," +
                    vehicle.getTire().getTraction() + "," +
                    vehicle.getTire().getWeight());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // Load Vehicle data from a CSV file
    public static Vehicule loadVehiculeFromFile(String filename)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line = reader.readLine();

            if (line != null)
            {
                String[] parts = line.split(",");
                float pilotAcceleration = Float.parseFloat(parts[0]);
                float pilotHandling = Float.parseFloat(parts[1]);
                String pilotImage = parts[2];
                String pilotName = parts[3];
                float pilotSpeed = Float.parseFloat(parts[4]);
                float pilotTraction = Float.parseFloat(parts[5]);
                float pilotWeight = Float.parseFloat(parts[6]);
                Pilote pilot = new Pilote(pilotAcceleration,pilotHandling,pilotImage,pilotName,pilotSpeed,pilotTraction,pilotWeight);

                float bodyAcceleration = Float.parseFloat(parts[7]);
                float bodyHandling = Float.parseFloat(parts[8]);
                String bodyImage = parts[9];
                String bodyName = parts[10];
                float bodySpeed = Float.parseFloat(parts[11]);
                float bodyTraction = Float.parseFloat(parts[12]);
                float bodyWeight = Float.parseFloat(parts[13]);
                Body body = new Body(bodyAcceleration,bodyHandling,bodyImage,bodyName,bodySpeed,bodyTraction,bodyWeight);

                float tireAcceleration = Float.parseFloat(parts[14]);
                float tireHandling = Float.parseFloat(parts[15]);
                String tireImage = parts[16];
                String tireName = parts[17];
                float tireSpeed = Float.parseFloat(parts[18]);
                float tireTraction = Float.parseFloat(parts[19]);
                float tireWeight = Float.parseFloat(parts[20]);
                Tire tire = new Tire(tireAcceleration,tireHandling,tireImage,tireName,tireSpeed,tireTraction,tireWeight);

                return new Vehicule(body,pilot,tire);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
