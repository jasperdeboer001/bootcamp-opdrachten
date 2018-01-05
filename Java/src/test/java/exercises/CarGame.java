package exercises;

import app.AutoAdvanced;
import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void checkCar() {
        Auto auto = new Auto();
        auto.printBrand("Volvo");
        auto.printDoors(4);
        auto.printMotorType("Diesel");
        auto.calculateTorque(15, 3000);
    }

    @Test
    public void checkBetterCar() {
        AutoAdvanced autoAdvanced = new AutoAdvanced("Tesla", 4, "Diesel", 15, 3000);
        autoAdvanced.printBrand();
        autoAdvanced.printDoors();
        autoAdvanced.printMotorType();
        autoAdvanced.calculateTorque();
    }
}
