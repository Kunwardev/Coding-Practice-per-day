package Leetcode;

import DataStructure.TreeNode;

public class SerializeDeserialize {
    
    private void serializePreOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.data+",");
        serializePreOrder(root.left, sb);
        serializePreOrder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
        System.out.println(sb);
        return sb.toString();
    }

    private TreeNode deserializePreOrder(String[] split, int[] index){
        if(split[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[index[0]]));
        index[0]++;
        root.left = deserializePreOrder(split, index);
        root.right = deserializePreOrder(split, index);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        int[] index = new int[]{0};
        return deserializePreOrder(split, index);
    }
}

}
