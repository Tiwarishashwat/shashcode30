class Solution {
    public long findScore(int[] nums) {
        //copy
        // [element,index]
        int n = nums.length;
        int copy[][] = new int[n][2];   // pq (min heap) -> a[0]==b[0], a[1] - b[1] || a[0] - b[0]
        for(int i=0;i<n;i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        Arrays.sort(copy, (a,b) -> a[0] - b[0]);
        long res=0;
        for(int i=0;i<n;i++){
            // remove / poll from queue
            int element = copy[i][0];
            int ind = copy[i][1];
            if(nums[ind]<0) continue;
            res += nums[ind];
            nums[ind] = -nums[ind];
            if(ind-1 >=0 && nums[ind-1] > 0){
                nums[ind-1] = -nums[ind-1];
            }
            if(ind+1 <n && nums[ind+1] > 0){
                nums[ind+1] = -nums[ind+1];
            }
        }
        return res;
    }
}
