package leets.land.v2.validation.constraint;

import leets.land.v2.validation.exception.InvalidInputException;

import java.util.regex.Pattern;

public class InvalidVersionConstraint implements Constraint<String> {

    /**
     * 저번 주 상황에선 regex를 미리 컴파일 시키는건 이해됐지만, 이번엔 미리 컴파일 시키는게 더 효율적인지는 고민입니다!
     * 이번 상황은 미리 컴파일 하는 시기가 실행되는 순간 바로 되는게 아니라 이 클래스가 실행될 때일텐데..
     * 이번엔 아예 차이가 없거나 오히려 pattern 변수를 생성하고 클래스가 끝날 때 삭제되는 비용이 발생돼서 덜 효율적일 수도 있겠다는 생각이 들어서 질문합니다!
     * 아니면 메서드 내부에서 regex로 한 줄 처리하더라도 내부적으로는 pattern 변수를 생성-삭제 하는 객체 생명주기가 존재해서 같을까요??
     */

    private final Pattern pattern = Pattern.compile("^[12]$");

    @Override
    public void checkValidation(String value) throws InvalidInputException {
        if(!pattern.matcher(value).matches())   // 1, 2가 아닌 다른 값을 입력했는가
            throw new InvalidInputException("[ERROR] 존재하지 않는 버전입니다. 다시 입력해주세요: ");
    }
}
