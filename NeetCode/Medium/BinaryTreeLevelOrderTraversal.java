/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();

        if(root == null){
            return arr;
        }

        queue.add(root);
        int index = 0;
        int cnt = 1;
        while(queue.size() != 0){
            int tempCnt = 0;
            for(int i = 0; i < cnt; i++){
                TreeNode curr = queue.remove();

                if(arr.size() == index){
                    arr.add(new ArrayList<>() );
                    arr.get(index).add(curr.val);
                }else{
                    arr.get(index).add(curr.val);
                }
            
                if(curr.left!= null){
                    queue.add(curr.left);
                    tempCnt++;
                }
                if(curr.right != null){
                    queue.add(curr.right);
                    tempCnt++;
                }
            }
            cnt = tempCnt;
            tempCnt = 0;
            index++;
        }
        return arr;
    }
}
