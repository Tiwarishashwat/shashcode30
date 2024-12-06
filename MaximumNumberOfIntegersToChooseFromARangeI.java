// hashing using set
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int ban : banned){
            set.add(ban);
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(set.contains(i)) continue;
            sum+=i;
            if(sum>maxSum) break;
            count++;
        }
        return count;
    }
}


// hashing using array
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean set[] = new boolean[10001];
        for(int ban : banned){
            set[ban] = true;
        }
        int sum=0;
        int count=0;
        for(int i=1;i<=n;i++){
            if(set[i]==true) continue;
            sum+=i;
            if(sum>maxSum) break;
            count++;
        }
        return count;
    }
}
