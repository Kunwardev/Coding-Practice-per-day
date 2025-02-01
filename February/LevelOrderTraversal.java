package February;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import DataStructure.TreeNode;

public class LevelOrderTraversal {
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Your code here
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        q.offer(root);
        int currLevel = 0;
        while(!q.isEmpty())
        {
            int length = q.size();
            res.add(new ArrayList<Integer>());
            for(int i=0;i<length;i++)
            {
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.offer(temp.left);
                }
                if(temp.right != null){
                    q.offer(temp.right);
                }
                res.get(currLevel).add(temp.data);
            }
            currLevel++;
        }
        return res;
    }

}
