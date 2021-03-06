package com.jie;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	/*
	 * Given a binary search tree (BST), find the lowest common ancestor (LCA)
	 * of two given nodes in the BST.
	 * 
	 * According to the definition of LCA on Wikipedia: ��The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).��
	 */
	/*         _______6______
	        /              \
	     ___2__          ___8__
	    /      \        /      \
	    0      _4       7       9
	          /  \
	          3   5   
	          
	          *
	          */
	/*
	 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
	 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a
	 * descendant of itself according to the LCA definition.
	 */
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
        int val = root.val;
        int max =p.val>q.val?p.val:q.val;
        int min=p.val<q.val?p.val:q.val;
        if(val<max&&val>min){
        	return root;
        }
        if(root==p||root==q){
        	
        	return root;
        }
		if(max<val){
			
		return 	lowestCommonAncestor(root.left,p,q);
		}
		
		return lowestCommonAncestor(root.right,p,q);
		

	}
	
}
