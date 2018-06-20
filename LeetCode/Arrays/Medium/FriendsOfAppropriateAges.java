import java.util.*;
import java.lang.*;
import java.io.*;

class FriendsOfAppropriateAges {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ages = new int[n];
		for (int i = 0; i < ages.length; i++) {
			ages[i] = in.nextInt();
		}
		FriendsOfAppropriateAges foaa = new FriendsOfAppropriateAges();
		System.out.println(foaa.numFriendRequests(ages));
	}

    public int numFriendRequests(int[] ages) {
        int[] ageArray = new int[121];
        int friendRequests = 0;
        for (int i = 0; i < ages.length; i++) {
            ageArray[ages[i]] += 1;
        }        
        
        for (int i = 1; i <= 120; i++) {
            for (int j = 1; j <= i; j++) {
                int A = ageArray[i];
                int B = ageArray[j];
                if ((j <= 0.5 * i + 7) || (j > i) || (j > 100 && i < 100)) {
                    continue;
                }

                if (i == j) {
                    friendRequests += A * (A - 1);                    
                } else {
                    friendRequests += A * B;
                }
            }
        }

        return friendRequests;
    }
}