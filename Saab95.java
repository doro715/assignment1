import java.awt.*;

import java.awt.Color;

public class Saab95 extends Car {
    //    only Saab knew this
    private boolean turboOn;


    public Saab95() {
        super(2, 125, Color.red, "Saab95");
        this.turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}

