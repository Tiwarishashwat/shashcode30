class Solution {
    // tc-> O(N)
    // sc-> O(N)
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int element : arr){
            if(set.contains(element*2) || ( (element%2==0) && (set.contains(element/2)) )){
                return true;
            }
            set.add(element);
        }
        return false;
    }
}
