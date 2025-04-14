package Leetcode;

import DataStructure.TreeNode;

public class String2BTree{

    private TreeNode str2TreeUtil(String s, TreeNode root, int[] index){
        //    System.out.println(index[0]);
            if(index[0] == s.length()){
                return null;
            }
            boolean isNegative = false;
            if(s.charAt(index[0]) == '-'){
                isNegative = true;
                index[0]++;
            }
            int num = 0;
            while(index[0] < s.length() && s.charAt(index[0]) != '(' && s.charAt(index[0]) != ')'){
                num = num*10+ (s.charAt(index[0]) - '0');
                index[0]++;
            }
            root = new TreeNode(isNegative ? -num: num);
            //index[0]++;
            if(index[0] < s.length() && (s.charAt(index[0]) == '(')){
                index[0]++;
                root.left = str2TreeUtil(s, root.left, index);
                index[0]++;
            }
            if(index[0] < s.length() && s.charAt(index[0]) == '('){
                index[0]++;
                root.right = str2TreeUtil(s, root.right, index);
                index[0]++;
            }
            return root;
        }
    
        public TreeNode str2tree(String s){
            int[] index = new int[]{0};
            TreeNode root = new TreeNode(-1);
            TreeNode head = root;
            root.left = str2TreeUtil(s, root.left, index);
            return head.left;
        }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        String2BTree convert = new String2BTree();
        TreeNode test = convert.str2Tree(s);
        System.out.println(test.data);
    }
}