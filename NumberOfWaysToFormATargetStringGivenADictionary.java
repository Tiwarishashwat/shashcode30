// recursion
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
        return (int)recur(0,0,charFreq, target, words);
    }

    long recur(int wordIndex, int targetIndex, int charFreq[][], String target, String words[]){
        //base cases
        if(targetIndex == target.length()){
            return 1;
        } 
        if(wordIndex == words[0].length()){
            return 0;
        }
        if((target.length() - targetIndex) > (words[0].length() - wordIndex)){
            return 0;
        }

        int curIndex = target.charAt(targetIndex) - 'a';
        int freq = charFreq[wordIndex][curIndex];

        long pick = freq * recur(wordIndex+1, targetIndex+1,charFreq,target,words);
        long noPick = recur(wordIndex+1, targetIndex,charFreq,target,words);
        long res = (pick + noPick)%1000000007;
        return res;

    }
}

// top down
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
        long dp[][] = new long[wordLen+1][targetLen+1];
        for(int i=0;i<wordLen+1;i++){
            Arrays.fill(dp[i], -1);
        }
        return (int)recur(0,0,charFreq, target, words, dp);
    }

    long recur(int wordIndex, int targetIndex, int charFreq[][], String target, String words[], long dp[][]){
        //base cases
        if(targetIndex == target.length()){
            dp[wordIndex][targetIndex] = 1;
            return 1;
        } 
        if(wordIndex == words[0].length()){
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }
        if((target.length() - targetIndex) > (words[0].length() - wordIndex)){
            dp[wordIndex][targetIndex] = 0;
            return 0;
        }
        if(dp[wordIndex][targetIndex]!=-1){
            return dp[wordIndex][targetIndex];
        }

        int curIndex = target.charAt(targetIndex) - 'a';
        int freq = charFreq[wordIndex][curIndex];

        long pick = freq * recur(wordIndex+1, targetIndex+1,charFreq,target,words, dp);
        long noPick = recur(wordIndex+1, targetIndex,charFreq,target,words, dp);
        long res = (pick + noPick)%1000000007;
        dp[wordIndex][targetIndex] = res;
        return res;

    }
}







//bottom up
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
        long dp[][] = new long[wordLen+1][targetLen+1];

        //base cases
        for(int i=0;i<wordLen+1;i++){
            dp[i][targetLen] = 1;
        }

        for(int i=wordLen-1;i>=0;i--){
            for(int j=targetLen-1;j>=0;j--){
                int curIndex = target.charAt(j) - 'a';
                int freq = charFreq[i][curIndex];
                long pick = freq * dp[i+1][j+1]; //recur(i+1, j+1,charFreq,target,words, dp);
                long noPick = dp[i+1][j]; //recur(i+1, j,charFreq,target,words, dp);
                long res = (pick + noPick)%1000000007;
                dp[i][j] = res;
            }
        }
        return (int) dp[0][0];//recur(0,0,charFreq, target, words, dp);
    }
}







// bottom up space optimized
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






