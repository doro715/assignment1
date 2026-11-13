

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
// Moveable Tests (startingState, Turning, Moving)
    private static void startingState(Car car, String carName) {
        boolean result = (car.getDirection() == Car.Direction.NORTH && car.getX() == 0 && car.getY() == 0);
        reportResult(carName + "New car starts at origin facing north", result);
    }

    //Test 2: one right turn gives EAST.
    private static void testTurnRight(Car car, String carName) {
        car.turnRight();
        boolean result = (car.getDirection() == Car.Direction.EAST);
        reportResult(carName + "New car correctly turns right", result);
    }

    //Test 3: one left turn gives WEST.
    private static void testTurnLeft(Car car, String carName) {
        car.turnLeft();
        boolean result = (car.getDirection() == Car.Direction.WEST);
        reportResult(carName + "New car correctly turns left", result);
    }
    
    // Test 4: four right turns give NORTH.
    private static void test4RightTurns(Car car, String carName) {
        for (int i = 0; i < 4; i++) {
            car.turnRight();
        }
        boolean result = (car.getDirection() == Car.Direction.NORTH);
        reportResult(carName + "New car correctly faces NORTH after 4 right turns", result);
    }
    // Test 5: four left turns give NORTH.
    private static void test4LeftTurns(Car car, String carName) {
        for (int i = 0; i < 4; i++) {
            car.turnLeft();
        }
        boolean result = (car.getDirection() == Car.Direction.NORTH);
        reportResult(carName + "New car correctly faces NORTH after 4 left turns", result);
    } 

    // Test 6: a right turn, then a left turn, gives NORTH.
    private static void testSameDirection(Car car, String carName) {
        car.turnRight();
        car.turnLeft();
        boolean result = (car.getDirection() == Car.Direction.NORTH);
        reportResult(carName + "New car correctly faces NORTH after a right and left turn", result);
    }

    private static void testStationaryCar(Car car, String carName) {
        car.move();
        boolean result = (car.getX() == 0  && car.getY() == 0);
        reportResult( carName + "Car with speed 0 does not move", result);
    }

    private static void testMoveNorth(Car car, String carName) {
        car.startEngine();
        car.move();
        boolean result = (car.getX() == 0  && car.getY() == car.getCurrentSpeed());
        reportResult(carName + "Car facing north moves along y by its speed", result);
    }

    private static void testMoveEast(Car car, String carName) {
        car.turnRight();
        car.startEngine();
        car.move();
        boolean result = (car.getX() == car.getCurrentSpeed()  && car.getY() == 0);
        reportResult(carName + "Car facing east moves along x by its speed", result);
    }
//    test currentSpeed will never be more than enginePower in task 4 requirements
    private static void testMaxSpeedLimit(Car car, String carName){
        car.startEngine();
        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }
        boolean result = car.getCurrentSpeed() <= car.getEnginePower();
        reportResult(carName+ "speed does not exceed Engine Power", result);

    }
    static void main() {
        testTurbo();
        testCarFunction(new Saab95(), "Saab95");
        testCarFunction(new Volvo240(), "Volvo240");
        testGasValidInput(new Saab95(), "Saab95");
        testGasValidInput(new Volvo240(), "Volvo240");
        testBrakeInvalidInput(new Volvo240(), "Volvo240");
        testBrakeInvalidInput(new Saab95(), "Saab95");
        startingState(new Saab95(), "Saab95");
        startingState(new Volvo240(), "Volvo240");
        testTurnRight(new Saab95(), "Saab95");
        testTurnRight(new Volvo240(), "Volvo240");
        testTurnLeft(new Saab95(), "Saab95");
        testTurnLeft(new Volvo240(), "Volvo240");
        test4RightTurns(new Saab95(), "Saab95");
        test4RightTurns(new Volvo240(), "Volvo240");    
        test4LeftTurns(new Saab95(), "Saab95");
        test4LeftTurns(new Volvo240(), "Volvo240");
        testSameDirection(new Saab95(), "Saab95");
        testSameDirection(new Volvo240(), "Volvo240");
        testStationaryCar(new Saab95(), "Saab95");
        testStationaryCar(new Volvo240(), "Volvo240");
        testMoveNorth(new Saab95(), "Saab95");
        testMoveNorth(new Volvo240(), "Volvo240");
        testMoveEast(new Saab95(), "Saab95");
        testMoveEast(new Volvo240(), "Volvo240");
        testMaxSpeedLimit(new Saab95(),"Saab95");
        testMaxSpeedLimit(new Volvo240(), "Volvo240");
    }
}