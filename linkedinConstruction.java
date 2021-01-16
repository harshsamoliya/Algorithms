// Time Complexity -> setHead,SetTail,remove,insertBefore,insertAfter -> O(1)
// Time Complexity -> removeNodeWithValue,ContainsNodeWithValue -> O(n) ,where n is no. of nodes
// Time Complexity -> insertAtPostion p -> O(p) ,where p is the position Number;
// Space Complexity -> O(1)


import java.util.*;
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      if(head==null){
				head = node;
				tail = node;
				return;
			}
			insertBefore(head,node);
    }

    public void setTail(Node node) {
			if(tail==null){
				head = node;
				tail = node;
				return;
			}
			insertAfter(tail,node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
			if(nodeToInsert==head && nodeToInsert==tail){
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.next = node;
			nodeToInsert.prev = node.prev;
			if(node.prev==null){
				// node is  head //
				head = nodeToInsert;
			}else{
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}

    public void insertAfter(Node node, Node nodeToInsert) {
			if(nodeToInsert==head && nodeToInsert==tail) return;
			remove(nodeToInsert);
			nodeToInsert.next = node.next;
			nodeToInsert.prev = node;
			if(node.next==null){
				tail = nodeToInsert;
			}else{
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
			if(position==1){
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPos = 1;
			while (node!=null && currentPos++!=position) node=node.next;
			if(node!=null){
				insertBefore(node,nodeToInsert);
			}else{
				setTail(nodeToInsert);
			}
    }

    public void removeNodesWithValue(int value) {
			Node node = head;
			while(node!=null){
				Node nodeToRemove = node;
				node = node.next;
				if(nodeToRemove.value==value) remove(nodeToRemove);
			}
    }

    public void remove(Node node) {
			if(node==head){
				head = head.next;
			}
			if(node==tail){
				tail = tail.prev;
			}
			removeNodeBinding(node);
    }
		public void removeNodeBinding(Node node){
			if(node.prev!=null){
				node.prev.next = node.next;
			}
			if(node.next!=null){
				node.next.prev = node.prev;
			}
			node.prev = null;
			node.next = null;
		}

    public boolean containsNodeWithValue(int value) {
			Node node = head;
			while(node!=null && node.value!=value){
				node = node.next;
			}
      return node!=null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
