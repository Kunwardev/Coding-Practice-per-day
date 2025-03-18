package Leetcode;

import DataStructure.TreeNode;

public class LowestCommonAncestorIII {
    
    public void commonAncestor(Node p, Node q){
        Node a = p, b = q;
	    while (a != b) {
		    a = a == null? q : a.parent;
		    b = b == null? p : b.parent;    
	    }
	    return a;
    }

}
