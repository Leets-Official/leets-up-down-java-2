package leets.land.view;


import leets.land.domain.Feedback;

public class Prints {
    public void opening() {
        System.out.println("업다운 게임을 시작합니다.");
        System.out.println();
    }

    public void feedback(Feedback feedback) {
        System.out.println(feedback.getValue());
    }

    public void error(Exceptions exceptions) {
        System.out.println(exceptions.getValue());
    }

    public void ending(int tryTimes) {
        System.out.print("시도한 횟수 : " + tryTimes + "회");
    }

}
