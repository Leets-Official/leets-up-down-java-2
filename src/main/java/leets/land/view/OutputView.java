package leets.land.view;

public class OutputView {
    public void displayWelcomeMessage() {
        System.out.println("업다운 게임을 시작합니다.");
    }

    public void displayPrompt(String message) {
        System.out.print(message);
    }

    public void displayFeedback(String feedback) {
        System.out.println(feedback);
    }

    public void displayError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }


    public void displayGameOverMessage(int guessCount) {
        System.out.println("정답!\n");
        System.out.println("시도한 횟수 : " + guessCount + "회");
    }
}