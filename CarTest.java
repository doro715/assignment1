public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }
//    Test task 1 whether both car function as its designed speed and gas
    private static void testCarFunction(Car car, String carName){
        car.startEngine();
        boolean isSpeedUp = car.getCurrentSpeed()> 0;
        reportResult(carName + " starts the engine with speed > 0", isSpeedUp);

        double speedUpBefore = car.getCurrentSpeed();
        car.gas(1);
        double speedUpAfter = car.getCurrentSpeed();
        boolean result = speedUpAfter > speedUpBefore;
        reportResult(carName + " has speeded up successfully", result);

    }
    private static void testGasValidInput(Car car, String carName){
        car.startEngine();
        double beforeGas = car.getCurrentSpeed();
        car.gas(1.5);
        double afterGas = car.getCurrentSpeed();
        boolean result = afterGas == beforeGas;
        reportResult(carName + " ignore gas() above 1", result);
    }

    private static void testBrakeInvalidInput(Car car, String carName){
        car.startEngine();
        double beforeBrake = car.getCurrentSpeed();
        car.brake( 1.5);
        double afterBrake = car.getCurrentSpeed();
        boolean result = afterBrake == beforeBrake;
        reportResult(carName + " ignore brake above 1", result);
    }

    static void main() {
        testTurbo();
        testCarFunction(new Saab95(), "Saab95");
        testCarFunction(new Volvo240(), "Volvo240");
        testGasValidInput(new Saab95(), "Saab95");
        testGasValidInput(new Volvo240(), "Volvo240");
        testBrakeInvalidInput(new Volvo240(), "Volvo240");
        testBrakeInvalidInput(new Saab95(), "Saab95");


    }
}