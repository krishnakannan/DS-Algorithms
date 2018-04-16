import java.util.*;
import java.lang.*;
import java.io.*;

class JumpGameII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		JumpGameII jg = new JumpGameII();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(jg.jump(nums));
	}

    public int jump(int[] nums) {
        int[] aux = new int[nums.length];
        if (nums.length == 0) {
        	return 0;
        }
        Arrays.fill(aux, Integer.MAX_VALUE);
        aux[0] = 0;        

        for (int i = 0; i < nums.length; i++) {
        	int canJump = nums[i];
        	int jumpCount = 1;
            if (i > 0 && nums[i] < nums[i - 1] && aux[i - 1] != Integer.MAX_VALUE) {
                continue;
            }
        	for (int j = i + 1; j < nums.length && jumpCount <= canJump; j++, jumpCount++) {
        		aux[j] = aux[j] > aux[i] + 1 ? aux[i] + 1 : aux[j];
        	}
        }

        return aux[aux.length - 1];
    }
}