// Time complexity -> O(N) N is number of nodes
// Space complexity -> O(H) H is height of binary tree

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
	// create a class with two property
	static class TreeInfo{
		public boolean isBalanced;
		public int Height;
		public TreeInfo(boolean isbalanced,int height){
			this.isBalanced = isbalanced;
			this.Height = height;
		}
	}

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    TreeInfo treeinfo = getinfo(tree);
		return treeinfo.isBalanced;
  }
	public TreeInfo getinfo(BinaryTree rootnode){
		// base case
		if(rootnode == null){
			return new TreeInfo(true,0);
		}
		TreeInfo leftsubtree = getinfo(rootnode.left);
		TreeInfo rightsubtree = getinfo(rootnode.right);
		boolean isbalanced = leftsubtree.isBalanced && rightsubtree.isBalanced && (Math.abs(leftsubtree.Height - rightsubtree.Height)<=1);
		int isheight = Math.max(leftsubtree.Height,rightsubtree.Height) + 1;
		return new TreeInfo(isbalanced,isheight);
	}
}
