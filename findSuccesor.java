
// Time complexity - > O(n)
// space complexity -> O(n) where n is the no. of nodes

// This is an input class. Do not edit.
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
  	List<BinaryTree> list = new ArrayList<>();
  	getinorderTraversal(tree,list);
  	for(int i = 0; i< list.size()-1 ; i++){
			// simple checking of succesor
      if(list.get(i)==node){
  			return list.get(i+1);
  		}
	
  	}
    return null;
  }
  // simple in order traversal /
  void getinorderTraversal(BinaryTree tree,List<BinaryTree> list){
  	if(tree!=null){
  		if(tree.left!=null){
  			getinorderTraversal(tree.left,list);
  		}
  		list.add(tree);
  		if(tree.right!=null){
  			getinorderTraversal(tree.right,list);
  		}
  	}
  }
}
// 2 nd Approach 
// Time complexity -> O(h) , h is the height of binary tree
// space complexity -> O(1)
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
		if(node.right!=null){
			return getLeftModeChild(node.right);
		}
    return getRightMostParent(node);
  }
	public BinaryTree getLeftModeChild(BinaryTree node){
		BinaryTree currentNode = node;
		while(currentNode.left!=null){
			currentNode =  currentNode.left;
		}
		return currentNode;
	}
	public BinaryTree  getRightMostParent(BinaryTree node){
		BinaryTree currentNode = node;
		while(currentNode.parent!=null && currentNode.parent.right==currentNode){
			currentNode = currentNode.parent;
		}
		return currentNode.parent;
	}
}


