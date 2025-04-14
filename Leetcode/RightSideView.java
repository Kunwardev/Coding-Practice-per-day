package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructure.TreeNode;

public class RightSideView{

    private List<Integer> function(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode curr = q.poll();
                if(i == level - 1){
                    result.add(curr.data);
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
        }
        System.out.println(result);
        return result;
    }

    private List<Integer> functionLeftSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode curr = q.poll();
                if(i == level - 1){
                    result.add(curr.data);
                }
                if(curr.right != null)
                    q.add(curr.right);
                if(curr.left != null)
                    q.add(curr.left);
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        RightSideView r = new RightSideView();
        r.function(root);
        r.functionLeftSideView(root);
    }

}