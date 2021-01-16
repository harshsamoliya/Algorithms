// Time complexity -> O(n)
// Space Complexity -> O(1)
import java.util.*;

class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
		int counter = 1;
		LinkedList first = head;
		LinkedList second = head;
		while(counter++<=k){
			first = first.next;
		}
		if(first==null){
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while(first.next!=null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
	}
  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
