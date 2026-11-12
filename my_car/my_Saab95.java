package my_car;
import java.awt.*;
//import java.awt.Color;

public class my_Saab95 extends mycar {

    private boolean turboOn;
// only saab knew this

    public my_Saab95() {
        super(2, 
            125, 
            Color.red,
            "Saab95");
        this.turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
    

