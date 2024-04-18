package leets.land.view;

import java.util.Scanner;

public class GameView {

  public int getVersionInput() {
    Scanner sc = new Scanner(System.in);
    System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
    return sc.nextInt();
  }

  public int getNumericInput() {
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력해주세요(1 ~ 100) : ");
    return sc.nextInt();
  }

  public char getAlphabetInput() {
    Scanner sc = new Scanner(System.in);
    System.out.print("영어를 입력해주세요(A ~ z) : ");
    return sc.next().charAt(0);
  }
}
