class Solution {
    public int numWays(String[] words, String target) {
        int wordLen = words[0].length();
        int targetLen = target.length();
        int charFreq[][] = new int[wordLen][26];
        
        for(String word : words){
            for(int i=0;i<word.length();i++){
                int charIndex = word.charAt(i) - 'a';
                charFreq[i][charIndex]++;
            }
        }
        long next[] = new long[targetLen+1];
        next[targetLen] = 1;

        for(int i=wordLen-1;i>=0;i--){
            long cur[] = new long[targetLen+1];
            cur[targetLen] = 1;
            for(int j=targetLen-1;j>=0;j--){
                int curIndex = target.charAt(j) - 'a';
                int freq = charFreq[i][curIndex];
                long pick = freq * next[j+1]; //recur(i+1, j+1,charFreq,target,words, dp);
                long noPick = next[j]; //recur(i+1, j,charFreq,target,words, dp);
                long res = (pick + noPick)%1000000007;
                cur[j] = res;
            }
            next = cur;
        }
        return (int) next[0]; //dp[0][0];//recur(0,0,charFreq, target, words, dp);
    }
}






