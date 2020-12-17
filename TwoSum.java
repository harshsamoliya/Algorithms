// Two Sum (a+b=target)

import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		List<Integer> list = new ArrayList<>();
		for(int i : array){
			list.add(i);
		}
		for(int i = 0;i<array.length;i++){
			int sum  = targetSum-array[i];
			if(list.contains(sum) && sum!=array[i]){
				return new int[]{array[i],sum};
			}
		}
		return new int[0];
  }
}
