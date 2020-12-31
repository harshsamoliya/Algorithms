// time Complexity O(N)
// Space Complexity O(1)

import java.util.*;

class Program {
  public static boolean hasSingleCycle(int[] array) {
		int check = 0;
		int currentInd = 0;
		while(check<array.length){
			if(check>0 && currentInd==0){
				return false;
			}
			check++;
			currentInd = Next(currentInd,array);
		}
		return currentInd==0;
  }
	public static int Next(int current,int[] array){
		int jump = array[current];
		current = (current+jump)%(array.length);
		if(current>=0){
			return current;
		}else{
			return array.length+current;
		}
	}
}
