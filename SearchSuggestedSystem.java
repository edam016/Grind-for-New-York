class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<List<String>>();
        StringBuilder sb = new StringBuilder();
        List<String> prods = new ArrayList();
        for(String val : products){
            prods.add(val);
        }
        for(int i = 0;i<=searchWord.length()-1;i++){
            sb.append(searchWord.charAt(i));
            int left = 0, right = products.length-1, middle = 0;
            while(left < right){
                middle = (left + right)/2;
                if(sb.toString().compareTo(products[middle]) <= 0){
                    right = middle - 1;
                }
                else{
                    left = middle + 1;
                }
            }
            List<String> arr = newArr(prods, sb.toString());
            List<String> search = new ArrayList();
            for(int b = 0;b<=arr.size()-1;b++){
                if(b == 3){
                    break;
                }
                search.add(arr.get(b));
            }
            result.add(search);
            prods = arr;
        }
        return result;
    }

    public List<String> newArr(List<String> products, String searchWord){
        List<String> arr = new ArrayList();
        for (String element : products) {
            arr.add(element);
        }
        for(int i = 0;i<=searchWord.length()-1;i++){
            for(int j = 0;j<=products.size()-1;j++){
                if(products.get(j).length()<searchWord.length() || searchWord.charAt(i) != products.get(j).charAt(i)){
                    arr.set(j, "remove");
                }
            }
        }
        for(int i = 0;i<=arr.size()-1;i++){
            if(arr.get(i).equals("remove")){
                arr.remove(i);
                i--;
            }
        }
        return arr;
    }
}