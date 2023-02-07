class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int length = 0;
        int maxLength = 0;
        for(int i : nums){
            hs.add(i);
        }
        for(int num : nums){
            int left = num - 1;
            int right = num + 1;
            while(hs.remove(left)){
                left--;
            }
            while(hs.remove(right)){
                right++;
            }
            length = right - left - 1;
            maxLength = Math.max(maxLength, length);
            if(hs.isEmpty()){
                return maxLength;
            }
        }
        return maxLength;
    }
}
//Make a hashmap that correlates to each value of nums and put into a loop where it containsKey() of nums[i]+1

//use bucketSory with frequency mapping of elements then while loop each element going left then right, adding total max outputpublic class LongestConsecutiveSequene {
    
}
