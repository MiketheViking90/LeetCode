package algorithms;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] wordAry = word.toCharArray();
        char c0 = wordAry[0];

        if (Character.isUpperCase(c0)) {
            return isAllUpper(wordAry, 1) || isAllLower(wordAry, 1);
        } else {
            return isAllLower(wordAry, 1);
        }
    }

    private boolean isAllLower(char[] wordAry, int i) {
        for (int j = i; j < wordAry.length; j++) {
            if (Character.isUpperCase(wordAry[j])) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllUpper(char[] wordAry, int i) {
        for (int j = i; j < wordAry.length; j++) {
            if (Character.isLowerCase(wordAry[j])) {
                return false;
            }
        }
        return true;
    }
}
