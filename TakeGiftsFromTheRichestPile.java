class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)-> b-a );
        long sum = 0l;
        for(int gift : gifts){
            sum+=gift;
            pq.offer(gift);
        }
        for(int i=0;i<k;i++){
            if(pq.isEmpty()) break;
            int largest = pq.poll();
            int sq = (int)Math.sqrt(largest);
            sum -= (largest - sq);
            pq.offer(sq);
        }
        return sum;
    }
}
