class Solution {
    public int maxTwoEvents(int[][] events) {
        // sort on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1] ); 
        // sort on start time
        // NlogN
        Arrays.sort(events, (a,b) -> a[0] - b[0]);  
        int prevMax = 0;
        int res = 0;
        // NlogN
        for(int event[] : events){
            //find prevMax
            while(!pq.isEmpty() && pq.peek()[1] < event[0]){
                prevMax = Math.max(prevMax, pq.peek()[2]);
                pq.poll();
            }
            res = Math.max(res, prevMax + event[2]);
            pq.offer(event);
        }
        return res;
    }
}
