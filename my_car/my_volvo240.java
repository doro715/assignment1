package my_car;
import java.awt.*;
//import java.awt.Color;

public class my_volvo240 extends mycar{
   
    private static final double trimFactor = 1.25;
    public my_volvo240(){
        super(4,
            100, 
            Color.black, 
            "Volvo240");}

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
    
