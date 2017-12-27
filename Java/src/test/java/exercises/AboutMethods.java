package exercises;

import org.testng.annotations.Test;

public class AboutMethods {

    private int multiply(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber);
    }

    @Test
    public void printProduct() {
        System.out.println(multiply(3, 5));

    }

}
