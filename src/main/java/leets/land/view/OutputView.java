package leets.land.view;

public class OutputView {
    public void printStart(){
        System.out.println("업다운 게임을 시작합니다.\n");
    }

    public void printUpDownResult(String result){
        System.out.println(result);
    }

    public void printAttempt(int attempt){
        System.out.print("\n시도한 횟수 : " + attempt);
    }
}
