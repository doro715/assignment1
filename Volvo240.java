import java.awt.*;

public class Volvo240 extends Car {
//    prevent accidental change so using final
    private static final double trimFactor = 1.25;
    public Volvo240(){
        super(4,100, Color.black, "Volvo240");}

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
