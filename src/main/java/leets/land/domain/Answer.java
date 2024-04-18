package leets.land.domain;

public class Answer {
    public static int setNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public static char setAlphabet() {
        char answer = (char) ((int) (Math.random() * ('z'-'A'+1)) + 'A');

        if (answer > 'Z' && answer < 'a') {
            return setAlphabet();
        }

        return answer;
    }
}
