class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = s.length();
        //gen all special substring and store in map
        for(int i=0;i<n;i++){
            StringBuilder curString = new StringBuilder();
            for(int j=i;j<n;j++){ // 
                if(curString.length() == 0 || 
                s.charAt(j) == curString.charAt(curString.length()-1)){
                    curString.append(s.charAt(j));
                    String cur = curString.toString();
                    map.put(cur, map.getOrDefault(cur, 0)+1);
                }else{
                    break;
                }
            }
        }
        int maxLen=-1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String str = entry.getKey();
            int freq = entry.getValue();
            if(freq > 2){
                maxLen = Math.max(maxLen, str.length());
            }
        }
        return maxLen;
    }
}
