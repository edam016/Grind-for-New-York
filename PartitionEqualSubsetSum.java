class Solution {
    Boolean[][] mem;
    public boolean canPartition(int[] nums) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        int total = Arrays.stream(nums).sum();
        if(total % 2 != 0){
            return false;
        }
        mem = new Boolean[nums.length+1][total+1];
        return check(nums, 0, 0, total);
    }

    public boolean check(int[] nums, int index, int sum, int total){
        if(total == sum*2){
            return true;
        }
        if(sum > total/2 || index == nums.length){
            return false;
        }
        if(mem[index][sum] != null){
            return mem[index][sum];
        }
        return mem[index][sum] = check(nums, index + 1, sum , total) || check(nums, index + 1, sum + nums[index], total);
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 0 || nums == null){
            return false;
        }
        int total = Arrays.stream(nums).sum();
        if(total % 2 != 0){
            return false;
        }

        return check(nums, 0, 0, total);
    }

    public boolean check(int[] nums, int index, int sum, int total){
        if(sum*2 == total){
            return true;
        }
        if(sum > total/2 || index == nums.length){
            return false;
        }
        return check(nums, index + 1, sum, total) || check(nums, index + 1, sum + nums[index], total);
    }
}