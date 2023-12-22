import java.util.Stack;

public class IDE{
    public static void main (String[] args){
        // removeKDigits("1432219", 3);
        // removeKDigits("10200", 1);
        // removeKDigits("10", 2);
        System.out.println(incrementVal(33));
    }

    public static int incrementVal(int val){
        return val + 1;
    }



    // public String removeKDigits(String num, int k){
    //     Stack<Integer> sk = new Stack<Integer>();
    //     int count = 0;
    //     while(count < k){
    //         sk.peek();
    //         for(int i = 0;i<=num.length()-1;i++){
    //             if(i == 0){
    //                 sk.push(substring of value);
    //             }
    //             else if(!sk.isEmpty()){
    //                 if(sk.peek() < substring.val){
    //                     sk.pop();
    //                     sk.push(substring.val);
    //                 }
    //             }
    //         }
    //     }
    // }
}