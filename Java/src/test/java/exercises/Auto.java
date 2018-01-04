package exercises;

public class Auto {

    public void printBrand(String brand) {
        System.out.println("Brand name is: " + brand);
    }

    public void printDoors(int doors) {
        System.out.println("Number of doors is: " + doors);
    }

    public void printMotorType(String fuel) {
        System.out.println("Motor type is: " + fuel);
    }

    public void calculateTorque(int force, int RPM) {
        double torque = (force * 5252) / RPM;
        System.out.println("Torque: " + torque);
    }
}
