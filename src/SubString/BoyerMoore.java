package SubString;

public class BoyerMoore {

    public static int search(String pat, String txt) {
        int[] right = new int[26];
        for (int i = 0; i < 26; ++i) {
            right[i] = -1;
        }
        for (int i = 0; i < pat.length(); ++i) {
            right[(int) pat.charAt(i) - 97] = i;
        }
        int N = txt.length();
        int M = pat.length();
        int skip = 0;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; --j) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[(int) txt.charAt(i + j) - 97]);
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return N;
    }
}
