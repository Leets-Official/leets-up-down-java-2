package leets.land;


public class UpNumberVersion {

    public void printUpDown(int number, int randomNumber) {
        if (number < randomNumber) {
            System.out.println("UP");
        } else if(number > randomNumber) {
            System.out.println("Down");
        }
    }
}
