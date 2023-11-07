class Solution {
    public int carFleet(String dates) {
        String month = dates.substring(5, 8);
        String dayRough = dates.substring(0, 1);
        String year = dates.substring(dates.length()-4);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<=dayRough.length()-1;i++){
            if(Character.isDigit(dayRough.charAt(i))){
                sb.append(dayRough.charAt(i))
            }
        }
        HashMap<String, String> hm = new HashMap();
        hm.put("Jan", "01");
        hm.put("Feb", "02");
        hm.put("Mar", "03");
        hm.put("Apr", "04");
        hm.put("May", "05");
        hm.put("Jun", "06");
        hm.put("Jul", "07");
        hm.put("Aug", "08");
        hm.put("Sep", "09");
        hm.put("Oct", "10");
        hm.put("Nov", "11");
        hm.put("Dec", "12");

        String day = sb.toString();
        if(day.length() == 1){
            day = "0" + day;
        }
        month = hm.get(month.trim());
        StringBuilder result = new StringBuilder();
        result.append(year);
        result.append('-');
        result.append(month);
        result.append('-');
        result.append(day);
        return result.toString();
        
    }
}