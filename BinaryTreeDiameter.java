import java.util.*;
// Time Complexity -> O(n)
// Space Complexity -> O(h)
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
	static class TreeInfo{
		public int diameter;
		public int height;

		public TreeInfo(int diameter,int height){
			this.diameter = diameter;
			this.height = height;
		}
	}
	
	
	public int binaryTreeDiameter(BinaryTree tree) {
		return getTreeInfo(tree).diameter;
	}
	
	// recursive ..//
	public TreeInfo getTreeInfo(BinaryTree tree){
		if(tree == null){
			return new TreeInfo(0,0);
		}
		TreeInfo leftTreeInfo = getTreeInfo(tree.left);
		TreeInfo rightTreeInfo = getTreeInfo(tree.right);
		int Diam = Math.max(leftTreeInfo.height + rightTreeInfo.height,Math.max(leftTreeInfo.diameter,rightTreeInfo.diameter));
		return new TreeInfo(Diam,Math.max(leftTreeInfo.height,rightTreeInfo.height) +1 );
	}
}
