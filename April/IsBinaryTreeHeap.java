package April;

import java.util.LinkedList;
import java.util.Queue;
import DataStructure.TreeNode;

public class IsBinaryTreeHeap {
    
    private boolean function(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left != null){
                if(flag || temp.left.data > temp.data){
                    return false;
                }
            }else{
                flag = true;
            }
            if(temp.right != null){
                if(flag || temp.right.data > temp.data){
                    return false;
                }
            }else{
                flag = true;
            }
        }
        return true;
    }

}
