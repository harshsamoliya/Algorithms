// Time Complexity O(v+e)
// Space Complexity O(v)
// v-> vertices and e-> edges

import java.util.*;

class Program {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }
		public List<String> breadthFirstSearch(List<String> array) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this);
		while (!queue.isEmpty()){
				Node current  = queue.pop();
				array.add(current.name);
				queue.addAll(current.children);
		}
		return array;
}

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
