package Model.Entities;

public abstract class Segment {
    protected float length;

    public Segment(float length) {
        this.length = length;
    }

    public float getLength() {
        return length;
    }
}