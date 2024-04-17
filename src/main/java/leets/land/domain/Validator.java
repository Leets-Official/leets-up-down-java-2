package leets.land.domain;

public class Validator {
    public boolean versionInputIsValid(String inputValue) {
        if (inputValue.equals("1") || inputValue.equals("2")) {
            return true;
        }
        return false;
    }
}
