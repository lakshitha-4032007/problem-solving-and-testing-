import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class PatternMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;
        String text = scanner.next();
        if (!scanner.hasNext()) return;
        String pattern = scanner.next();
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        for (int k = 0; k < result.size(); k++) {
            System.out.print(result.get(k) + (k == result.size() - 1 ? "" : " "));
        }
        System.out.println();
        scanner.close();
    }
}