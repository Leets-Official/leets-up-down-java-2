package leets.land;

import java.util.Random;

public class UpNumberVersion {

    public void printUpDown(int number, int randomNumber) {
        if (number < randomNumber) {
            System.out.println("UP");
        } else if(number > randomNumber) {
            System.out.println("Down");
        }
    }
}
