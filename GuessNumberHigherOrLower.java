/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        double left = 0, right = n;
        while(left < right){
            double middle = (left + right)/2;
            if(guess((int)middle) == 0){
                return (int)middle;
            }
            else if(guess((int)middle) == 1){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return (int)left;
    }
}