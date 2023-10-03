class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> row1 = new ArrayList();
        row1.add(1);
        result.add(row1);

        int count = 0;
        for(int i = 0;i<numRows-1;i++){
            List<Integer> row = new ArrayList();
            for(int j = 0;j<=result.get(i).size();j++){
                if(j == 0 || j == result.get(i).size()){
                    row.add(1);
                    continue;
                }
                else{
                    row.add(result.get(i).get(j-1)+result.get(i).get(j));
                }
                
            }
            result.add(row);
        }
        return result;
    }
}