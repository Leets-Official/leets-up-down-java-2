package leets.land.domain;

import java.util.Random;

public class NumberVersionService {

    public int getNumber(String input) {
        return Integer.parseInt(input);
    }

    public boolean checkRange(String input, int min, int max) {
        int value = convertStringToNum(input);

        return value >= min && value <= max;
    }

    private int convertStringToNum(String input) {
        return Integer.parseInt(input);
    }

    public int setRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public boolean checkAnswer(int answer, int number) {
        return answer == number;
    }

    public boolean calcIsNumberUp(int answer, int number) {
        return answer > number;
    }
}
