class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        for(int i=n-1;i>=0;i--){ //O(N)
            while(!stack.isEmpty() && stack.peek()>prices[i]){
                stack.pop();
            }
            int val = prices[i];
            if(!stack.isEmpty()){
                prices[i]-=stack.peek();
                
            }
            stack.push(val);
        }
        return prices;
    }
}
