package Leetcode;

import DataStructure.TreeNode;

public class GPTQuestion {
    
    private void serializeUtil(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        sb.append(root.data+",");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    private String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private TreeNode deserializeUtil(String[] s, int[] index){
        if(index[0] >= s.length || s[index[0]].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[index[0]]));
        index[0]++;
        root.left = deserializeUtil(s, index);
        index[0]++;
        root.right = deserializeUtil(s, index);
        return root;
    }

    private TreeNode deserialize(String s){
        String[] split = s.split(",");
        int[] index = new int[]{0};
        return deserializeUtil(split, index);
    }

}
