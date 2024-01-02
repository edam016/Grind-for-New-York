class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<=nums.length-1;i++){
            for(int j = 0;j<=result.size()-1;j++){
                System.out.println(result.get(j).contains(nums[i]));
                if(!(result.get(j).contains(nums[i]))){
                    List<Integer> arr = result.get(j);
                    arr.add(nums[i]);
                    break;
                }
                else if(j == result.size()-1){
                    List<Integer> arr = new ArrayList();
                    arr.add(nums[i]);
                    result.add(arr);
                    break;
                }
            }
            if(result.size() == 0 && i == 0){
                List<Integer> arr = new ArrayList();
                arr.add(nums[i]);
                result.add(arr);
            }
        }
        return result;
    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] count = new int[201];
        int maxVal = Integer.MIN_VALUE;
        int maxOc = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList();
        for(int i = 0;i<=nums.length-1;i++){
            count[nums[i]]++;
            maxOc = Math.max(count[nums[i]], maxOc);
            maxVal = Math.max(nums[i], maxVal);
        }
        int i = 0;
        for(int j = 0;j<maxOc;j++){
            List<Integer> arr = new ArrayList();
            result.add(arr);
        }
        while(i <= maxVal){
            for(int j = 0;j<count[i];j++){
                result.get(j).add(i);
            }
            i++;
        }
        return result;
    }
}