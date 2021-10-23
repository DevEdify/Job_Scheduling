//Job Scheduling
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int n, i, j, temp;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of Jobs : ");
        n = sc.nextInt();
        int jobs[] = new int[n];
        int profit[] = new int[n];
        int deadline[] = new int[n];
        for (i = 0; i < n; i++) {
            jobs[i] = i + 1;
            System.out.print("Enter profit of job " + (i + 1) + " : ");
            profit[i] = sc.nextInt();
            System.out.print("Enter deadlines " + (i + 1) + " : ");
            deadline[i] = sc.nextInt();
        }
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                int min = i;
                if (profit[min] < profit[j]) {
                    temp = jobs[min];
                    jobs[min] = jobs[j];
                    jobs[j] = temp;
                    temp = profit[min];
                    profit[min] = profit[j];
                    profit[j] = temp;
                    temp = deadline[min];
                    deadline[min] = deadline[j];
                    deadline[j] = temp;
                }
            }
        }
        int z = 0;
        for (i = 0; i < n; i++) {
            if (deadline[i] > z) {
                z = deadline[i];
            }
        }
        int s_j[] = new int[z + 1];
        int e_p[] = new int[z + 1];
        i = 0;
        int y = z + 1;
        while (i < n && z > 0) {
            if (s_j[deadline[i]] == 0) {
                s_j[deadline[i]] = jobs[i];
                e_p[deadline[i]] = profit[i];
                z--;
            } else {
                while (deadline[i] >= 1) {
                    if (s_j[deadline[i]] == 0) {
                        s_j[deadline[i]] = jobs[i];
                        e_p[deadline[i]] = profit[i];
                        z--;
                        break;
                    }
                    deadline[i]--;
                }
            }
            i++;
        }
        int total_profit = 0;
        for (i = 1; i < y; i++) {
            total_profit = total_profit + e_p[i];
        }
        System.out.println("Total profit earned : " + total_profit);
        System.out.print("Optimal scheduling is :");
        for (i = 1; i < y; i++) {
            if (s_j[i] == 0)
                continue;
            System.out.print(" " + s_j[i]);
        }
    }
}
