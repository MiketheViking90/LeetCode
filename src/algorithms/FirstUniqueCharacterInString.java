public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }

        int[] counts = new int[128];
        char[] sCharAry = s.toCharArray();
        for (char c : sCharAry) {
            counts[c]++;
        }

        for (int i = 0; i < sCharAry.length; i++) {
            char c = sCharAry[i];
            if (counts[c] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //String test = "plantsplantsz";
        String test = "";

        FirstUniqueCharacterInString f = new FirstUniqueCharacterInString();
        int val = f.firstUniqChar(test);
        System.out.println(val);
    }
}
