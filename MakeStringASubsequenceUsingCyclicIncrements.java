class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        // Min(n,m)
        int index1=0;
        int index2=0;
        int n=str1.length();
        int m=str2.length();
        if(m>n){
            return false;
        }
        while(index2<m && index1<n){
            if(str1.charAt(index1) == str2.charAt(index2)||
            (str1.charAt(index1) == str2.charAt(index2)-1)||
            (str1.charAt(index1)=='z' && str2.charAt(index2)=='a')){
                index2++;
            }
            index1++;
        }
        return (index2 == m);
    }
}
