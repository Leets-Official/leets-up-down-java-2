package leets.land.view;

public class OutputView {
    final String COUNT_MESSAGE = "시도한 횟수 : %d회";

    // 시도한 횟수를 출력하는 함수
    public void printCount(int count) {
        System.out.print(String.format(COUNT_MESSAGE, count));
    }
}
