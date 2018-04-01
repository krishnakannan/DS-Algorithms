/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int guessNum = (int)Math.ceil((double)n / 2);
        double lowerLimit = 0;
        double higherLimit = n;
        int rep = guess(guessNum);

        while (rep != 0) {
            if (rep == 1) {
                lowerLimit = guessNum + 1;
                guessNum = (int)Math.ceil((lowerLimit)/2 + (higherLimit)/2);
            } else if (rep == -1) {
                higherLimit = guessNum - 1;
                guessNum = (int)Math.ceil((higherLimit)/2 + (lowerLimit)/2);
            }
            rep = guess(guessNum);
        }
        
        return guessNum;
    }
}