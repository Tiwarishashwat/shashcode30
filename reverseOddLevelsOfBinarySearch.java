class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            //lot
            ArrayList<TreeNode> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(level%2!=0){
                    list.add(node);
                }
            }

            if(level%2!=0){
                int r=0;
                int l=list.size()-1;
                while(r<l){
                    int temp = list.get(r).val;
                    list.get(r).val = list.get(l).val;
                    list.get(l).val = temp;
                    r++;
                    l--;
                }
            }
            level++;
        }
        return root;
    }
}
