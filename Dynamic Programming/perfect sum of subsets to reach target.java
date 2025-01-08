import java.util.*;
public class Main {
    public static int countSubsetsWithSum(int[] arr, int target) {
        int n = arr.length;
        int count = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
           ArrayList<Integer>list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    list.add(arr[i]);
                }
            }
            if (sum == target) {
                count++;
                System.out.println("Subset: " +list);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
        int target = 4;
        int result = countSubsetsWithSum(arr, target);
        System.out.println("Total number of subsets with sum " + target + ": " + result);
    }
}
