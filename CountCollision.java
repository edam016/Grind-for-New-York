class Solution {
    public int countCollisions(String directions) {
        Stack<Character> sk = new Stack();
        int total = 0;
        for(char ch : directions.toCharArray()){
            if(sk.isEmpty()){
                sk.push(ch);
            }
            else if(!sk.isEmpty() && sk.peek() == 'R'){
                while(!sk.isEmpty() && sk.peek() == 'R' && ch != 'R'){
                    if(ch == 'S'){
                        total += 1;
                    }
                    else if(ch == 'L'){
                        total += 2;
                    }
                    sk.pop();
                    ch = 'S';
                }
                sk.push(ch);
            }
            else if(!sk.isEmpty() && sk.peek() == 'S'){
                if(ch == 'R'){
                    sk.push('R');
                }
                else if(ch == 'S'){
                    sk.push('S');
                }
                else{
                    total++;
                    sk.push('S');
                }
            }
            else if(!sk.isEmpty() && sk.peek() == 'L'){
                sk.push(ch);
            }
        }
        return total;
        /*
        
        Test cases:

        - Right in stack and current is Stationary or L, must use a while loop for this due to a chain in crashes
        - Left in Stack, doesnt matter just push ch in
        - Stationary in Stack, just push in Right or collide with L making another S

         */
    }
}