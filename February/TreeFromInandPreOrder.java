package February;

import java.util.HashMap;
import DataStructure.TreeNode;


public class TreeFromInandPreOrder {
    
    static class PreIndex
    {
        int index;

        public PreIndex()
        {
            this.index = 0;
        }
    }

    private static TreeNode constructTree(int[] preOrder, int[] inOrder)
    {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        PreIndex preIndex = new PreIndex();
        for(int i = 0; i < inOrder.length; i++)
        {
            inMap.put(inOrder[i], i);
        }
        return constructTreeUtil(preOrder, inOrder, preIndex, 0, inOrder.length - 1, inMap);
            }
        
        private static TreeNode constructTreeUtil(int[] preOrder, int[] inOrder, PreIndex preIndex, int start, int end,
            HashMap<Integer, Integer> inMap) {
                if(start > end)
                {
                    return null;
                }
                TreeNode root = new TreeNode(preOrder[preIndex.index++]);
                int index = inMap.get(root.data);
                root.left = constructTreeUtil(preOrder, inOrder, preIndex, start, index - 1, inMap);
                root.right = constructTreeUtil(preOrder, inOrder, preIndex, index + 1, end, inMap);
                return root;
            }

    public static void main(String[] args) {
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        int[] preOrder = {1, 2, 4, 5, 3, 6};
        TreeNode root = constructTree(preOrder, inOrder);
        root.inOrder();
    }

}
