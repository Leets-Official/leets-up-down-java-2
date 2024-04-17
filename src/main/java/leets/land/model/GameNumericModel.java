package leets.land.model;

import java.util.Scanner;

public class GameNumericModel {

  private final int answer = (int) (Math.random() * 100);
  private static int count;
  private int min = 1;
  private int max = 100;

  public boolean up(int input) {
    return input < answer;
  }

  public int changeLimitForUp(int input) {
    System.out.println("UP");
    count++;

    min = input + 1;

    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요(" + min + " ~ " + max + ") : ");
    return sc.nextInt();
  }

  public boolean down(int input) {
    return input > answer;
  }

  public int changeLimitForDown(int input) {
    System.out.println("DOWN");
    count++;

    max = input - 1;
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요(" + min + " ~ " + max + ") : ");
    return sc.nextInt();
  }

  public boolean isCorrect(int input) {
    return input == answer;
  }

  public static int getCount() {
    return count;
  }
}
