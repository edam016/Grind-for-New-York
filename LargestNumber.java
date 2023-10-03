class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0 || nums == null){
            return "";
        }
        String[] num = new String[nums.length];
        for(int i = 0;i<=nums.length-1;i++){
            num[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);// returns positive if s2 > s1 and negative if s1 > s2
            }
        };
        Arrays.sort(num, comp);
        if(num[0].charAt(0) == '0'){
			return "0";
            //checks if 0 is in the first position of the array so the value doesnt work as it returns 00 instead of 0
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=num.length-1;i++){
            sb.append(num[i]);
        }
        return sb.toString();
    }
}