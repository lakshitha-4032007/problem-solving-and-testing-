import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] salaries = new int[n];
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }
        Arrays.stream(salaries)
              .map(salary -> (int)(salary * 1.1))
              .forEach(salary -> System.out.print(salary + " "));
        scanner.close();
    }
}