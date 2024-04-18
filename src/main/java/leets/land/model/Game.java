package leets.land.model;

import java.util.Random;

public class Game {
    private int targetNumber;
    private char targetLetter;
    private int minNumber = 1;
    private int maxNumber = 100;
    private char minLetter = 'A';
    private char maxLetter = 'Z';
    private int guessCount = 0;
    private boolean gameOver = false;
    private int gameType;

    public void initializeGame(int gameType) {
        this.gameType = gameType;
        Random rand = new Random();
        if (gameType == 1) {
            targetNumber = rand.nextInt(maxNumber - minNumber + 1) + minNumber;
        } else {
            minLetter = 'A';
            maxLetter = 'z';
            targetLetter = (char) (rand.nextInt('z' - 'A' + 1) + 'A');
        }
    }

    public boolean isValidGuess(String guess) {
        if (gameType == 1) {
            try {
                int guessNum = Integer.parseInt(guess);
                return guessNum >= minNumber && guessNum <= maxNumber;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            if (guess.length() != 1) return false;
            char guessChar = guess.charAt(0);
            return (guessChar >= minLetter && guessChar <= maxLetter) ||
                    (guessChar >= Character.toLowerCase(minLetter) && guessChar <= Character.toLowerCase(maxLetter));
        }
    }

    public void processGuess(String guess) {
        guessCount++;
        if (gameType == 1) {
            int guessNum;
            try {
                guessNum = Integer.parseInt(guess);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 정수 값을 입력하세요.");
                return;
            }

            if (guessNum < targetNumber) {
                minNumber = guessNum + 1;
                System.out.println("UP");
            } else if (guessNum > targetNumber) {
                maxNumber = guessNum - 1;
                System.out.println("DOWN");
            } else {
                gameOver = true;
                System.out.println("정답!");
            }
        } else {
            char guessChar = guess.charAt(0);
            if (guessChar >= 'A' && guessChar <= 'Z') {
                if (guessChar < targetLetter) {
                    minLetter = (char) (guessChar + 1);
                    System.out.println("UP");
                } else if (guessChar > targetLetter) {
                    maxLetter = (char) (guessChar - 1);
                    System.out.println("DOWN");
                } else {
                    gameOver = true;
                }
            } else if (guessChar >= 'a' && guessChar <= 'z') {
                if (guessChar < targetLetter) {
                    minLetter = (char) (guessChar + 1);
                    System.out.println("UP");
                } else if (guessChar > targetLetter) {
                    maxLetter = (char) (guessChar - 1);
                    System.out.println("DOWN");
                } else {
                    gameOver = true;
                }
            } else {
                System.out.println("[ERROR] 범위 내의 올바른 값을 입력하세요.");
            }

            if (maxLetter >= '[' && maxLetter <= '`') {
                maxLetter = 'Z';
            } else if (minLetter > 'Z' && minLetter < 'a') {
                minLetter = 'a';
            }
        }
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    public int getGuessCount() {
        return this.guessCount;
    }

    public String getCurrentRange() {
        if (gameType == 1) {
            return String.format("(%d ~ %d)", minNumber, maxNumber);
        } else {
            return String.format("(%c ~ %c)", minLetter, maxLetter);
        }
    }
}
