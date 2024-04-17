package leets.land.domain;

public interface UpDown {
    int getAnswerAsInt();

    char getAnswerAsChar();

    int getStartAsInt();

    char getStartAsChar();

    int getEndAsInt();

    char getEndAsChar();

    int getCount();

    void setStart(int start);

    void setEnd(int end);

    void increaseCount();

    void validator(char alphabet);

    void validator(int number);
}