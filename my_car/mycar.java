package my_car;
import java.awt.*;

public abstract class mycar implements my_moveable{
    protected  final int nrDoors;
    protected  final double enginePower;
    protected double currentSpeed;
    private double x;
    private double y;
    private Direction direction;
    protected Color color;
    protected  final String modelName;
    public enum direction { NORTH, EAST, SOUTH, WEST }

//    Constructor
    public mycar(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
    }
//Public interfaced
    
    public int getNrDoors() {
        return nrDoors;
    }
    public double getEnginePower() {
        return enginePower;
    }
    public double getCurrentSpeed() {
        return currentSpeed;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color clr) {
        color = clr;
    }
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

//  Since Saab and Volvo have different bodies of speedFactor, Abstract methods to be implemented by subclasses
    protected abstract double speedFactor();


//    Internal access that only gas and brake using them
    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) {
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        decrementSpeed(amount);
    }
//  my moveable contract
public void move();

public void turnLeft();

public void turnRight();

}


