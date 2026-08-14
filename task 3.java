import java.util.Scanner;
public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int maxSoFar = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            currentMax += val;
            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        System.out.println(maxSoFar);
        scanner.close();
    }
}