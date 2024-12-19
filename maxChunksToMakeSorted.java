class Solution {
    public int maxChunksToSorted(int[] arr) {
     int max = Integer.MIN_VALUE;
     int n = arr.length;
     int count=0;
     for(int i=0;i<n;i++){
        max = Math.max(max, arr[i]);
        if(max < i+1){
            count++;
        }
     }
     return count; 
    }
}
