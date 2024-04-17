package leets.land.domain;

public class CharVersionService {
    public char setRandomChar() {
        return (char) ((Math.random() * 26) + 97);
    }

    public char getChar(String input) {
        return input.charAt(0);
    }
}
