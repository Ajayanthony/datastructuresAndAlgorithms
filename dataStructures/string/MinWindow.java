package string;

/**
 * Given a set of characters CHARS and a input string INPUT, find the minimum
 * window in str which will contain all the characters in CHARS in complexity O(n).
 * For example, INPUT = ABBACBAA and CHARS = AAB has the minimum window BAA
 */
public class MinWindow {

    public static void findMinWindow(String input, String chars) {
        int[] reqCount = new int[256];
        int[] currCount = new int[256];

        for (char ch : chars.toCharArray()) {
            reqCount[ch] += 1;
        }

        int start = 0;
        int end = 0;
        int minStart = -1;
        int minEnd = -1;
        boolean minWindow = false;

        while (start < input.length() - chars.length()
                && end < input.length()) {
            if (minWindow) {
                start++;
                currCount[input.charAt(start - 1)] -= 1;
                currCount[input.charAt(end)] += 1;
                if (checkArrays(reqCount, currCount) &&
                        (end - start < minEnd - minStart)) {
                    minStart = start;
                    minEnd = end;
                }
            } else {
                currCount[input.charAt(end)] += 1;
                if (checkArrays(reqCount, currCount)) {
                    minWindow = true;
                    minStart = start;
                    minEnd = end;
                }
            }
            end++;
        }

        if (minWindow) {
            System.out.println("Min Window Start:" + (start + 1) + " end:" + (end - 1));
            System.out.println("Window is " + input.substring(start + 1, end));
        } else {
            System.out.println("WIndow not found.");
        }
    }

    public static void main(String[] args) {
        findMinWindow("ABBACBAA", "AAB");
    }

    public static boolean checkArrays(int[] required, int[] current) {
        for (int i = 0; i < required.length; i++) {
            if (required[i] > 0 && required[i] > current[i]) {
                return false;
            }
        }
        return true;
    }
}
