// o(NlogN)
class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int start=0;
        int end=0;
        long count=0;
        int n = nums.length;
        while(end < n){
            map.put(nums[end] , map.getOrDefault(nums[end],0)+1);
            //shrinking
            while(map.lastEntry().getKey() - map.firstEntry().getKey() >2){
                map.put(nums[start] , map.get(nums[start])-1);
                if(map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                }
                start++;
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}

//most optimal solution - O(N)
class Solution {
    public long continuousSubarrays(int[] nums) {
        int start=0;
        int end=0;
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        long count=0;
        int n = nums.length;
        while(end < n){
            curMin = Math.min(curMin, nums[end]);
            curMax = Math.max(curMax, nums[end]);
            if(curMax - curMin >2){
                start = end;
                curMin = nums[end];
                curMax = nums[end];
                while(start-1>=0 && Math.abs(nums[start-1] - nums[end])<=2){
                    start--;
                    curMin = Math.min(curMin, nums[start]);
                    curMax = Math.max(curMax, nums[start]);
                }    
            }
            count += (end - start + 1);
            end++;
        }
        return count;
    }
}
