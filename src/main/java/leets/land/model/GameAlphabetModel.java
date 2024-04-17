package leets.land.model;

import java.util.Random;
import java.util.Scanner;

public class GameAlphabetModel {

  private final char answer;
  private static int count;
  private char min = 'A';
  private char max = 'z';

  public GameAlphabetModel() {
    Random random = new Random();
    this.answer = (char) (random.nextInt(26) + (random.nextBoolean() ? 'A' : 'a'));
  }

  public boolean up(int input) {
    return input < answer;
  }

  public char changeLimitForUp(int input) {
    System.out.println("UP");
    count++;

    min = (char) (input + 1);

    Scanner sc = new Scanner(System.in);
    System.out.print("영어를 입력해주세요(" + min + " ~ " + max + ") : ");
    return sc.next().charAt(0);
  }

  public boolean down(int input) {
    return input > answer;
  }

  public char changeLimitForDown(int input) {
    System.out.println("DOWN");
    count++;

    if (input == 'a') {
      max = 'Z';
    } else {
      max = (char) (input - 1);
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("영어를 입력해주세요(" + min + " ~ " + max + ") : ");
    return sc.next().charAt(0);
  }

  public boolean isCorrect(int input) {
    return input == answer;
  }

  public static int getCount() {
    return count;
  }
}
