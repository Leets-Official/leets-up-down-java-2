package leets.land.domain;

public class NumberUpDown implements UpDown {
    private final int answerNumber = Answer.setNumber();
    private int startNumber = 1, endNumber = 100;
    private int count = 0;

    @Override
    public int getAnswerAsInt() {
        return answerNumber;
    }

    @Override
    public char getAnswerAsChar() {
        return 0;
    }

    @Override
    public int getStartAsInt() {
        return startNumber;
    }

    @Override
    public char getStartAsChar() {
        return 0;
    }

    @Override
    public int getEndAsInt() {
        return endNumber;
    }

    @Override
    public char getEndAsChar() {
        return 0;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setStart(int start) {
        startNumber = start;
    }

    @Override
    public void setEnd(int end) {
        endNumber = end;
    }

    @Override
    public void increaseCount() {
        count++;
    }

    @Override
    public void validator(char alphabet) {
        return;
    }

    @Override
    public void validator(int number) {
        if (number < startNumber || number > endNumber) {
            throw new IllegalArgumentException("[ERROR] 범위 내의 숫자를 입력하세요.");
        }
    }
}
