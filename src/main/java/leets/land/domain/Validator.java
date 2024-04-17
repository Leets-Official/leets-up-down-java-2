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
        if (input != null && input.length() == 1) {
            int charValue = input.charAt(0);
            return charValue >= 97 && charValue <= 122;
        }
        return false;
    }
}
