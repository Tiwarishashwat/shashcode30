class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int res=0;
        int n = values.length;
        int leftMax = values[0] +0;
        for(int j=1;j<n;j++){
            int rightVal = values[j] - j;
            res = Math.max(res, leftMax + rightVal);
            leftMax = Math.max(leftMax, values[j] + j);
        }
        return res;
    }
}
