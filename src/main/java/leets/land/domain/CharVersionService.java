package leets.land.domain;

public class CharVersionService {

    public char setRandomChar() {
        boolean isUpperCase = Math.random() < 0.5;
        if (isUpperCase) {
            return (char) ((Math.random() * 26) + 65);
        }
        return (char) ((Math.random() * 26) + 97);
    }

    public char getChar(String input) {
        return input.charAt(0);
    }

    public boolean checkAnswer(char answer, char value) {
        return answer == value;
    }

    public boolean calcIsCharUp(char answer, char value) {
        return answer > value;
    }
}
