// Time Complexity O(n)
// Space Complexity O(n)


import java.util.*;

class Program {
  public static int[] largestRange(int[] array) {
		HashMap<Integer,Boolean> map = new HashMap<>();
		int ansleft = 0;
		int ansRight = 0;
		for(int i : array){
			map.put(i,true);
		}
		int TL = 0;
		for(int num : array){
			if(!map.get(num)){
				continue;
			}
			map.put(num,false);
			// checking that it is contains in map or not
			int left = num-1;
			int right = num+1;
			int current = 1;
			while(map.containsKey(left)){
				map.put(left,false);
				current++;
				left--;
			}
			while(map.containsKey(right)){
				map.put(right,false);
				current++;
				right++;
			}
			if(current>TL){
				TL = current;
				ansleft = left+1;
				ansRight = right-1;
			}
		}
		return new int[]{ansleft,ansRight};
  }
}
