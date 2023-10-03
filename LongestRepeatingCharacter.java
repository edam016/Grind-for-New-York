class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int j = 0;
        int length = 0, maxLength = 0;
        int maxChar = 0;
        for(int i = 0;i<=s.length()-1;i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                System.out.println("flag1");
            }
            else{
                hm.put(s.charAt(i), 1);
            }
            length++;
            for(char val : hm.keySet()){
                maxChar = Math.max(hm.get(val), maxChar);
            }
            System.out.println(j);
            while(length - maxChar > k){
                for(char val : hm.keySet()){
                maxChar = Math.max(hm.get(val), maxChar);
                }
                if(hm.get(s.charAt(j)) > 1){
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                }
                else{
                    hm.remove(s.charAt(j));
                }
                j++;
                length--;
            }
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = 0;
        int n2 = 0;
        HashSet<Integer> hm = new HashMap();
        for(int j =0lj<=nums1.length-1;j++){
            hs.add(nums1[i]);
        }
        for(int i = 0;i<=nums2.length-1;i++){
            if(!hs.add(nums2[i])){
                for(int j = i + 1;j<=nums2.length-1;j++){
                    if(nums2[j] > nums1[2])
                }
            }
        }
    }
}

//quite slow time efficiency wise