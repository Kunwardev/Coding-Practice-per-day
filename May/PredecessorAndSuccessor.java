package May;

import java.util.ArrayList;

import DataStructure.TreeNode;

public class PredecessorAndSuccessor {
    private TreeNode suc, pre;

    private ArrayList<Integer> findPreSuc(TreeNode root, int key){
        suc = null;
        pre = null;
        findPreSucUtil(root, key);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(pre == null ? -1 : pre.data);
        result.add(suc == null ? -1 : suc.data);
        return result;
    }

    private void findPreSucUtil(TreeNode root, int key) {
        if(root == null)
            return;
        if(root.data == key){
            if(root.left != null){
                TreeNode temp = root.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                pre = temp;
            }
            if(root.right != null){
                TreeNode temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                suc = temp;
            }
        }
        else if(root.data > key){
            suc = root;
            findPreSucUtil(root.left, key);
        }
        else{
            pre = root;
            findPreSucUtil(root.right, key);
        }
    }
}