class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // [diff, pass, total]
        PriorityQueue<double[]> pq = new PriorityQueue<>( (a,b) -> Double.compare(b[0],a[0])); 
        //insert in priority queue (sorted on diff high to low)
        // O(N)
        for(int arr[] : classes){
            int pass = arr[0];
            int total = arr[1];
            double diff = findDiff(pass, total);
            pq.offer(new double[]{diff, pass, total});
        }
        // include extraStudents in that class which will have highest pass ratio
        // K logN
        while(extraStudents>0){
            double arr[] = pq.poll();
            int pass = (int)arr[1] + 1;
            int total = (int)arr[2] + 1;
            double diff = findDiff(pass, total);
            pq.offer(new double[]{diff, pass, total});
            extraStudents--;
        }
        // o(N)
        // sum of pass ratio
        double totalPassRatio=0;
        while(!pq.isEmpty()){
            double arr[] = pq.poll();
            double pass = arr[1];
            double total = arr[2];
            totalPassRatio += (pass / total);
        }
        // average of pass ratio
        return totalPassRatio/classes.length;

    }
    public double findDiff(int pass, int total){
        return ( (double)(pass+1) / (total+1) ) - ((double)pass / total);
    }
}
