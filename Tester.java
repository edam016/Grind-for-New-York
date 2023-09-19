import java.util.Arrays;

class Tester {
    public static void main(String[] args) {
        Tester tester = new Tester(); // Create an instance of MyClass
        int[] sortedArray = tester.sortArray(new int[]{2, 3, 1, 5});
        System.out.println(Arrays.toString(sortedArray)); // Print the sorted array
    }
    public int[] sortArray(int[] nums) {
        //Can do merge sort or heap sort for this question
        if(nums.length == 1){
            return nums;
        }
        nums = mergeSort(nums);
        return nums;
    }
    public static int[] mergeSort(int[] nums){
        int [] array1 = new int[nums.length/2];
        int [] array2 = new int[nums.length/2];
        int j = 0;
        for(int i = 0;i<=nums.length-1;i++){
            if(i <nums.length/2){
                array1[i]=nums[i];
            }
            else if(j==nums.length/2){
                break;
            }
            else{
                array2[j]=nums[i];
                j++;
            }
       }
       array1 = mergeSort(array1);
       array2 = mergeSort(array2);
       return merge(array1, array2);
    }

    public static int[] merge(int[] arr1, int[] arr2){
        int [] result = new int[arr1.length + arr2.length];
        int index = 0;
        int j = 0;
        int i = 0;
        while(i<=arr1.length-1 && j<=arr2.length-1){
            if(arr1[i] > arr2[j]){
                result[index] = arr2[j];
                j++;
                index++;
            }
            else{
                result[index] = arr1[i];
                i++;
                index++;
            }
        }
        while(j<=arr2.length-1){
            result[index] = arr2[j];
            index++;
            j++;
        }
        while(i<=arr1.length-1){
            result[index] = arr1[i];
            index++;
            i++;
        }
        return result;
    }
}