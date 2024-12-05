class Solution {
    public boolean canChange(String start, String target) {
        int i=0;
        int j=0;
        int n = start.length();
        while(i<n || j<n){
            //skip all blanks in start
            while(i<n && start.charAt(i)=='_') i++;

            //skip all blanks in target
            while(j<n && target.charAt(j)=='_') j++;

            //count is same only if both the string end at the same time
            if(i==n || j==n){
                return (i==n && j==n);
            }

            // check false scenarios
            if(start.charAt(i)!=target.charAt(j) || 
            (start.charAt(i)=='L' && j>i) ||
            (start.charAt(i)=='R' && j<i)
            ){
                return false;
            }
            //move to the next character after comparision 
            i++;
            j++;
        }
        return true;
    }
}
