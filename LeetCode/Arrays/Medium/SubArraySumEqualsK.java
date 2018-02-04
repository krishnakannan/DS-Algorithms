import java.util.*;
import java.lang.*;
import java.io.*;

class SubArraySumEqualsK {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        SubArraySumEqualsK se = new SubArraySumEqualsK();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(se.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int total = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if (map.containsKey(sum - k)) {
                total += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return total;
    }
}