package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

import DataStructure.TreeNode;

public class RecoverTreeFromPreOrder {
    
    private TreeMap<Integer, ArrayList<Integer>> getNumbers(String traversal){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(Integer.parseInt(traversal.charAt(0)+""));
        map.put(0, arr);
        char[] tChar = traversal.toCharArray();
        int length = tChar.length;
        int dashCount = 0;
        for(int i=1;i<length;i++){
            if(tChar[i] == '-'){
                dashCount++;
            }else{
                ArrayList<Integer> val = map.getOrDefault(dashCount, new ArrayList<Integer>());
                val.add(Integer.parseInt(tChar[i]+""));
                map.put(dashCount, val);
                dashCount = 0;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        RecoverTreeFromPreOrder r = new RecoverTreeFromPreOrder();
        TreeMap<Integer, ArrayList<Integer>> map = (r.getNumbers("1-2--3--4-5--6--7"));
        TreeNode root = new TreeNode(map.get(0).get(0));
        traverse(root, map);
        inOrder(root);
                }
                
    private static void inOrder(TreeNode root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
        
    private static void traverse(TreeNode root, TreeMap<Integer, ArrayList<Integer>> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.remove(0);
        int level = 1;
        while(!map.isEmpty()){
            ArrayList<Integer> arr = map.get(level);
            System.out.println(arr);
            int size = arr.size();
            int index = 0;
            while(index < size){
                TreeNode temp = q.remove();
                temp.left = new TreeNode(arr.get(index++));
                q.offer(temp.left);
                if(index >= size)
                    break;
                temp.right = new TreeNode(arr.get(index++));
                q.offer(temp.right);
            }
            map.remove(level++);
        }
    }

}
