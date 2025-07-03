import java.util.Arrays;
import java.util.Scanner;

public class KnapsackProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int capacity = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];
        double[][] ratio = new double[n][3];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
            weights[i] = sc.nextInt();
            ratio[i][0] = (double) values[i] / weights[i];
            ratio[i][1] = values[i];
            ratio[i][2] = weights[i];
        }

        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (capacity >= ratio[i][2]) {
                capacity -= ratio[i][2];
                totalValue += ratio[i][1];
            } else {
                totalValue += ratio[i][1] * (capacity / ratio[i][2]);
                break;
            }
        }

        System.out.printf("%.2f\n", totalValue);
    }
}