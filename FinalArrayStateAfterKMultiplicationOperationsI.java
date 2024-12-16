class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // [element, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        } ); 
        // insert
        for(int i =0;i<nums.length;i++){
            pq.offer(new int[]{nums[i],i});
        }
        //perform K operations
        while(k>0){
            int arr[] = pq.poll();
            nums[arr[1]] = nums[arr[1]] *  multiplier;
            pq.offer(new int[]{nums[arr[1]],arr[1]});
            k--;
        }
        return nums;
    }
}
