class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> lasers = new ArrayList();
        if(bank.length == 1){
            return 0;
        }
        for(int i = 0;i<=bank.length-1;i++){
            int count = 0;
            for(int j = 0;j<=bank[i].length()-1;j++){
                if(bank[i].charAt(j) == '1'){
                    count++;
                }
            }
            lasers.add(count);
        }
        for(int i = 0;i<=lasers.size()-1;i++){
            if(lasers.get(i) == 0){
                lasers.remove(i);
                i--;
            }
        }
        if(lasers.size() == 0){
            return 0;
        }
        int result = 0;
        int sum = lasers.get(0);
        for(int i = 1;i<=lasers.size()-1;i++){
            result += sum*lasers.get(i);
            sum = lasers.get(i);
        }
        return result;
    }
}