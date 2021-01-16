// Time  complexity -> O(n)
// space complexity -> O(1)

import java.util.*;

class Program {
  public static LinkedList reverseLinkedList(LinkedList head) {
		LinkedList current = head;
		LinkedList previous = null;
		while(current!=null){
			LinkedList nextnode = current.next;
			current.next = previous;
			previous = current;
			current = nextnode;
		}
		return previous;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
