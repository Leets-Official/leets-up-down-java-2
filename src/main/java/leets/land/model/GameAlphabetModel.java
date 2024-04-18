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

    return isValidAlphabetRange();
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

    return isValidAlphabetRange();
  }

  public boolean isCorrect(int input) {
    return input == answer;
  }

  public static int getCount() {
    return count;
  }

  private char isValidAlphabetRange() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("영어를 입력해주세요(" + min + " ~ " + max + ") : ");
      char newInput = sc.next().charAt(0);

      if (newInput < min || newInput > max) {
        System.out.println("[ERROR] 범위 내의 알파벳을 입력하세요.");
      } else {
        return newInput;
      }
    }
  }
}
