package app;

public class AutoAdvanced {

    private String brand;
    private int doors;
    private String fuel;
    private int force;
    private int RPM;

    public AutoAdvanced(String brand, int doors, String fuel, int force, int RPM) {
        this.brand = brand;
        this.doors = doors;
        this.fuel = fuel;
        this.force = force;
        this.RPM = RPM;
    }

    public void printBrand() {
        System.out.println("Brand name is: " + brand);
    }

    public void printDoors() {
        System.out.println("Number of doors is: " + doors);
    }

    public void printMotorType() {
        System.out.println("Motor type is: " + fuel);
    }

    public void calculateTorque() {
        double torque = (force * 5252) / RPM;
        System.out.println("Torque: " + torque);
    }
}
