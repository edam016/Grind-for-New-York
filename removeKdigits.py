class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []
        count = k
        for i in num:
            if stack and stack[-1] > i:
                while stack and stack[-1] > i and count > 0:
                    stack.pop()
                    count-= 1
            stack.append(i)
        
        while count > 0:
            stack.pop()
            count -= 1

        i = 0
        while(i < len(stack) and stack[i] == "0"):
            i += 1
            
        return ''.join(stack[i:]) if (len(stack[i:]) > 0) else "0"
                
        
        