package eighteen.algo;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        reverseArray(arr, 0, n);
        System.out.println(new String(arr));
        int i = 0;
        int j = 1;
        while (j < n) {
            if (j == n-1) {
                reverseArray(arr, i, j+1);
                return new String(arr);
            }
            if (arr[j] == ' ') {
                reverseArray(arr, i, j);
                i = findNextSpace(arr, j);
                j = i+1;
            } else {
                j++;
            }
        }
        return new String(arr);
    }

    private int findNextSpace(char[] arr, int i) {
        while (i < arr.length && arr[i] == ' ') {
            i++;
        }
        return i;
    }

    void reverseArray(char[] arr, int i, int j) {
        for (int k = 0; k < (j-i)/2; k++) {
            char t = arr[i+k];
            arr[i+k] = arr[j-k-1];
            arr[j-k-1] = t;
        }
    }

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here
        int idx = -1;
        int min = 0;
        int max = arr.length;

        while (min < max) {
            int med = (min + max)/2;
            int val = arr[med];

            if (med == val) {
                idx = med;

                if (!hasMatchLeft(arr, idx)) {
                    return idx;
                }
                max = med-1;
            } else if (med < val) {
                max = med-1;
            } else {
                min = med+1;
            }
        }
        return idx;
    }

    private static boolean hasMatchLeft(int[] arr, int i) {
        if (i == 0) {
            return false;
        }

        int vR = arr[i];
        int vL = arr[i-1];
        return vR-vL == 1;
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWordsInAString rw = new ReverseWordsInAString();
        String t = rw.reverseWords(s);
        System.out.println(t);
    }
}
