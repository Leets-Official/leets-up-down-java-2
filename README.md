public int readNumber(int min, int max) {
    System.out.printf("숫자를 입력해주세요(%d ~ %d) : ", min, max);
    String number = sc.next();
    return checkNumberRange(checkNumberType(number), min, max);
}

public int checkNumberRange(int number, int min, int max) {
    if (number < min || number > max) {
        System.out.println("[ERROR] 범위 내의 숫자를 입력하세요. ");
        return readNumber(min, max);
    } else {
        return number;
    }
}public void numberVersion() {
    double randomValue = Math.random();
    int randomNumber = (int)(randomValue *100) +1;
    System.out.println(randomNumber);
    int cnt = 0;
    int correct = -1;
    int min = 1;
    int max = 100;
    while (correct != randomNumber) {
        correct = inputView.readNumber(min, max);
        if (correct < randomNumber) {
            System.out.println("UP");
            min = correct + 1;
        } else if (correct > randomNumber) {
            System.out.println("DOWN");
            max = correct - 1;
        }
        cnt ++;
    }
    outputView.printCorrectMessage(cnt);
}# 👆 업다운

</br>

## 🎯 미션 요구사항

    Leets의 정기 모임시간에 진행 할 수 있는 간단한 아이스브레이킹 게임입니다.
    업다운 게임으로 오늘의 감을 테스트해 보아요.

    - 숫자 버전과 영어 버전을 선택하여 게임을 시작 할 수 있습니다.
      영어 : A ~ z
      숫자 : 1 ~ 100
    - 숫자 버전 : 난수를 생성합니다.
    - 영어 버전 : 대문자와 소문자 사이의 알파벳을 임의로 선택합니다.
    ( 난수 사용 )
    - 사용자의 추측 값을 입력 받습니다.
    - 사용자의 입력값과 정답을 비교하여 UP or DOWN을 판단하여 출력합니다.
    - 사용자가 정답을 맞추면 “정답!” 문자열과 시도한 횟수를 출력하세요.

</br>

## 🤖 기능 요구사항

### 입력

- 숫자/영어 버전을 입력 받는다

  > 숫자 = 1, 영어 = 2로 지정되어 있어야 합니다

  ```
  버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : 1
  ```

- 숫자/영어를 입력 받는다
  > 타입에 맞지 않는 입력일 경우 예외처리 합니다
  > 범위에 맞지 않는 입력일 경우 예외처리 합니다

#### 숫자버전

```
숫자를 입력해주세요(1 ~ 100) : 50
```

#### 영어버전

```
영어를 입력해주세요(A ~ z) : a
```

</br>

### 출력

- 사용자의 입력 값과 정답을 비교하여 결과를 반환한다

#### 숫자버전

```
숫자를 입력해주세요(1 ~ 100) : 50
UP
숫자를 입력해주세요(51 ~ 100) : 75
DOWN
숫자를 입력해주세요(51 ~ 74) : 57
정답
```

#### 영어버전

```

영어를 입력해주세요(A ~ z) : a
UP
영어를 입력해주세요(b ~ z) : A
[ERROR] 범위 내의 알파벳을 입력하세요.
영어를 입력해주세요(b ~ z) : c
DOWN
영어를 입력해주세요(b ~ b) : b
정답!
```

- 사용자가 정답을 맞출 때까지 시도한 횟수를 출력한다
  ( 잘못된 값 입력 역시 시도한 횟수에 포함 되어야 한다. )

```
시도한 횟수 : 4회
```

- 요구사항에서 벗어나는 입력이 일어나는 경우 **[ERROR]** 와 함께 에러 메세지를 반환 해야 한다.

```
[ERROR] 존재하지 않는 버전입니다.
[ERROR] 범위 내의 숫자를 입력하세요.
[ERROR] 범위 내의 알파벳을 입력하세요.
[ERROR] 입력 문자의 타입이 맞지 않습니다.
```

</br>

## 📍 실행 예시

### 숫자 버전

```
업다운 게임을 시작합니다.

버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : 1
숫자를 입력해주세요(1 ~ 100) : 50
UP
숫자를 입력해주세요(51 ~ 100) : 49
[ERROR] 범위 내의 숫자를 입력하세요.
숫자를 입력해주세요(51 ~ 100) : 75
DOWN
숫자를 입력해주세요(51 ~ 74) : 57
정답!

시도한 횟수 : 4회
```

</br>

### 영어 버전

```
업다운 게임을 시작합니다.

버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : 2
영어를 입력해주세요(A ~ z) : a
UP
영어를 입력해주세요(b ~ z) : A
[ERROR] 범위 내의 알파벳을 입력하세요.
영어를 입력해주세요(b ~ z) : c
DOWN
영어를 입력해주세요(b ~ b) : b
정답!

시도한 횟수 : 4회
```

</br>

## 💡 프로그래밍 요구사항

- BE는 **Java**를 터미널을 통해 프로그램을 실행 해야 합니다.
- 예외 처리를 해야 합니다.
- ❗️주어진 예외 경우 외에도 필요시 예외 처리를 하시길 바랍니다❗️
    - 이를 위해 **UpdownApplicationTests** 파일에서 추가 적인 예외 처리 코드를 작성 해야 합니다.
- 테스트 코드를 작성해야 합니다.
- 알파벳 혹은 숫자 입력 후 **[ERROR]** 메세지가 반환 되면, 다시 `재입력`을 받아야 합니다

</br>

## 📢 미션 진행 요구사항

미션은 아래의 가이드 노션을 보고 진행합니다.

[미션 진행 가이드](https://leets-final.notion.site/46dbd9440a4f4d5e97228011dff70f5a?pvs=4)
