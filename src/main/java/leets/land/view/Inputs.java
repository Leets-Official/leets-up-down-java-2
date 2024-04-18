package leets.land.view;

import leets.land.domain.Version;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Inputs {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    InputHandler inputHandler = new InputHandler();
    Prints prints = new Prints();

    public Version version() {
        try {
            System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) :");
            int versionNumber = Integer.parseInt(br.readLine());
            Version versionNumberEnum = inputHandler.convertToEnum(versionNumber);

            if (versionNumberEnum == Version.ERROR) {
                prints.error(Exceptions.NOT_EXIST_VERSIOM);
                return this.version();
            }
            return versionNumberEnum;
        } catch (Exception e) {
            prints.error(Exceptions.NOT_GOOD_FORMAT);
            return this.version();
        }
    }

    public int expectation(int minLimitValue, int maxLimitValue, Version version) {
        try {
            int expectation;
            if (version == version.NUM) {
                System.out.print("숫자를 입력해주세요(" + minLimitValue + " ~ " + maxLimitValue + ") :");
                expectation = Integer.parseInt(br.readLine());
            } else {
                System.out.print("문자를 입력해주세요(" + (char) minLimitValue + " ~ " + (char) maxLimitValue + ") :");
                expectation = br.readLine().charAt(0);
            }


            if (!inputHandler.isValidRangeValue(version, minLimitValue, maxLimitValue, expectation)) {
                prints.error(Exceptions.NOT_GOOD_RANGE);
                return this.expectation(minLimitValue, maxLimitValue, version);
            }
            return expectation;
        } catch (Exception e) {
            prints.error(Exceptions.NOT_GOOD_FORMAT);
            return this.expectation(minLimitValue, maxLimitValue, version);
        }
    }
}
