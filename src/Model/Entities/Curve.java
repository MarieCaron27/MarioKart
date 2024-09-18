package Model.Entities;

public class Curve extends Segment {
    private float angle; // in radians

    public Curve(float length, float angle) {
        super(length);
        this.angle = (float) Math.toRadians(angle);
    }

    public float getAngle() {
        return angle;
    }

    public float getRadius() {
        return this.length / this.angle;
    }
}