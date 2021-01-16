// Time complexity -> O(n)
// space complexity -> O(1)
import java.util.*;

class Program {
  public static LinkedList findLoop(LinkedList head) {
		LinkedList tortoise = head.next;
		LinkedList Hare = head.next.next;
		while(tortoise!=Hare){
			tortoise = tortoise.next;
			Hare = Hare.next.next;
		}
		tortoise = head;
		while(tortoise!=Hare){
			tortoise = tortoise.next;
			Hare = Hare.next;
		}
		return tortoise;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

