package leets.land.view;

import leets.land.domain.Version;

public class InputHandler {
    public static final char NON_ENG_CHAR_START = '[';
    public static final char NON_ENG_CHAR_END = '`';

    public Version convertToEnum(int versionNumber) {
        if (versionNumber == Version.NUM.getValue()) {
            return Version.NUM;
        } else if (versionNumber == Version.ENG.getValue()) {
            return Version.ENG;
        }
        return Version.ERROR;
    }

    public boolean isValidRangeValue(Version version, int minLimitValue, int maxLimitValue, int expectation) {
        if (expectation < minLimitValue || expectation > maxLimitValue) {
            return false;
        }
        if (version == Version.ENG && expectation >= NON_ENG_CHAR_START && expectation <= NON_ENG_CHAR_END) {
            return false;
        }
        return true;
    }
}
