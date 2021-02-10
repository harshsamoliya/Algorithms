// Time complexity -> O(n)
// space complexity -> O(1)

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
		LinkedList currentnode = linkedList;
		while(currentnode!=null){
			LinkedList nextnode = currentnode.next;
			while(nextnode!=null && nextnode.value==currentnode.value){
				nextnode = nextnode.next;
			}
			currentnode.next  = nextnode;
			currentnode = nextnode;
		}
    return linkedList;
  }
}
