package leets.land.domain;

public class Answer {
    public static int setNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public static char setAlphabet() {
        char answer = (char) ((int) (Math.random() * ('z'-'A')) + 'A');

        if (answer > 'Z' && answer < 'a') {
            return setAlphabet();
        }

        return answer;
    }
}
