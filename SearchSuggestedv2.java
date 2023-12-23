class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<List<String>>();
        Arrays.sort(products);
        int left = 0, right = products.length-1;
        for(int i = 0;i<=searchWord.length()-1;i++){
            List<String> arr = new ArrayList();
            while(left <= right && (i >= products[left].length() || searchWord.charAt(i) != products[left].charAt(i))){
                left++;
            }
            while(left <= right && (i >= products[right].length() || searchWord.charAt(i) != products[right].charAt(i))){
                right--;
            }
            for(int j = left;j<=right && j < left + 3;j++){
                arr.add(products[j]);
            }
            result.add(arr);
        }
        return result;
    }
}