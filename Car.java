import java.awt.*;

public abstract class Car implements Moveable{
    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    private double x;
    private double y;
    private Direction direction;

    public enum Direction {
        NORTH, EAST, SOUTH, WEST
    }

    // Constructor
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
    }
    // Public interface

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
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    // Since Saab and Volvo have different bodies of speedFactor, Abstract methods
    // to be implemented by subclasses
    protected abstract double speedFactor();

    // Internal access that only gas and brake using them
    private void incrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        // Setting the max limit for current speed
        currentSpeed = Math.min(currentSpeed, getEnginePower());
    }

    private void decrementSpeed(double amount) {

        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        // Setting the min limit for current speed
        currentSpeed = Math.max(currentSpeed,0);
    }

    public void gas(double amount) {
        // Checking if "amount" in acceptable range
        if (amount < 0 || amount > 1){
            return;
        }
        incrementSpeed(amount);
    }

    public void brake(double amount) {
        // Checking if "amount" in acceptable range
        if (amount < 0 || amount > 1){
            return;
        }
        decrementSpeed(amount);
    }

    // Movement (moveable interface)
    @Override
    public void move() {
        if (direction == Direction.NORTH) {
            y += currentSpeed;
        } else if (direction == Direction.SOUTH) {
            y -= currentSpeed;
        } else if (direction == Direction.EAST) {
            x += currentSpeed;
        } else if (direction == Direction.WEST) {
            x -= currentSpeed;
        }

    }

    @Override
    public void turnLeft() {
        if (direction == Direction.NORTH) {
            direction = Direction.WEST;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.EAST;
        } else if (direction == Direction.EAST) {
            direction = Direction.NORTH;
        } else if (direction == Direction.WEST) {
            direction = Direction.SOUTH;
        }

    }

    @Override
    public void turnRight() {
        if (direction == Direction.NORTH) {
            direction = Direction.EAST;
        } else if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
        } else if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
        } else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
        }

    }
}
