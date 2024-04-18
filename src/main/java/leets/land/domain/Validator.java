package leets.land.domain;

public class Validator {

    public boolean versionInputIsValid(String inputValue) {
        return inputValue.equals("1") || inputValue.equals("2");
    }

    public boolean isInputNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    public boolean isInputChar(String input) {
        int charValue = input.charAt(0);
        return charValue >= 65 && charValue <= 122;
    }

    public boolean checkInputTypeForNumberVersion(String input) {
        return input.isBlank() || !isInputNumber(input);
    }

    public boolean checkInputTypeForCharVersion(String input) {
        return input.isBlank() || input.length() != 1;
    }
}
