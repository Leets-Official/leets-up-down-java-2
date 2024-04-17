package leets.land.model;

public class AlphabetComputer {

    private static char answer = (char) (Math.random() * ('z'-'A'+1) + 'A');
    private static int count = 1;
    private static char min = 'A';
    private static char max = 'z';


    public int getCount() {
        return count;
    }

    public char getMin(){
        return min;
    }
    public char getMax(){
        return max;
    }
    public void judgeUp(char input) {
        count++;
        if (input == 'Z') {
            min = 'a';
        } else {
            max = (char) (input - 1);
        }
    }

    public void judgeDown(char input) {
        count++;
        if (input == 'a') {
            max = 'Z';
        } else {
            max = (char) (input - 1);
        }
    }

    public boolean up(char input) {
        return answer > input;
    }

    public boolean down(char input) {
        return answer < input;
    }

    public boolean correct(char input) {
        return answer == input;
    }
}
