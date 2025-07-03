import java.util.*;

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        String[] ids = new String[n];
        int[] deadlines = new int[n];
        int[] profits = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Job ID, Deadline and Profit for Job " + (i + 1) + ": ");
            ids[i] = sc.next();
            deadlines[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = i;
            jobs[i][1] = deadlines[i];
            jobs[i][2] = profits[i];
        }

        Arrays.sort(jobs, (a, b) -> profits[b[0]] - profits[a[0]]);

        int maxDeadline = Arrays.stream(deadlines).max().getAsInt();
        boolean[] slots = new boolean[maxDeadline + 1];
        String[] result = new String[maxDeadline + 1];

        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            int index = jobs[i][0];
            int deadline = deadlines[index];
            int profit = profits[index];
            String jobId = ids[index];

            for (int j = deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    result[j] = jobId;
                    totalProfit += profit;
                    break;
                }
            }
        }

        System.out.println("Jobs selected: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i]) {
                System.out.print(result[i] + " ");
            }
        }

        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
