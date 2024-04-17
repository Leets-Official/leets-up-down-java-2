package leets.land.domain;

public class AlphabetUpDown implements UpDown {
    private final char answerAlphabet = Answer.setAlphabet();
    private char startAlphabet = 'A', endAlphabet = 'z';
    private int count = 0;

    @Override
    public int getAnswerAsInt() {
        return 0;
    }

    @Override
    public char getAnswerAsChar() {
        return answerAlphabet;
    }

    @Override
    public int getStartAsInt() {
        return 0;
    }

    @Override
    public char getStartAsChar() {
        return startAlphabet;
    }

    @Override
    public int getEndAsInt() {
        return 0;
    }

    @Override
    public char getEndAsChar() {
        return endAlphabet;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setStart(int start) {
        if (start - 1 == 'Z') {
            startAlphabet = 'a';
        } else {
            startAlphabet = (char) start;
        }
    }

    @Override
    public void setEnd(int end) {
        if (end + 1 == 'a') {
            endAlphabet = 'Z';
        } else {
            endAlphabet = (char) end;
        }
    }

    @Override
    public void increaseCount() {
        count++;
    }

    @Override
    public void validator(char alphabet) {
        if (alphabet < startAlphabet || alphabet > endAlphabet) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 알파벳을 입력하세요.");
        }
    }

    @Override
    public void validator(int number) {

    }
}
