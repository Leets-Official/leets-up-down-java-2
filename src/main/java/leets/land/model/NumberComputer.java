package leets.land.model;

public class NumberComputer {
    private static int answer = (int) (Math.random() * 100) + 1;
    private static int count = 1;
    private static int min = 1;
    private static int max = 100;


    public int getCount() {
        return count;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void judgeUp(int input) {
        count++;
        min = input + 1;
    }

    public void judgeDown(int input) {
        count++;
        max = input - 1;
    }

    public boolean up(int input) {
        return answer > input;
    }

    public boolean down(int input) {
        return answer < input;
    }

    public boolean correct(int input) {
        return answer == input;
    }
}
