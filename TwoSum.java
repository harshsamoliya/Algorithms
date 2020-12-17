// Two Sum (a+b=target)
// Time Complexity o(n)
// Space Complexity o(n)


// meathod 1 
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
// meathod 2 Two pointers
// Time Complexity O(nlog(n))
// Space Complexity O(1)
import java.util.*;

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		Arrays.sort(array);
		int i = 0;
		int j = array.length-1;
		while(i<j){
			int target =array[i] + array[j];
			if(target==targetSum){
				return new int[]{array[i],array[j]};
			}else if(target<targetSum){
				i++;
			}else{
				j--;
			}
		}
    return new int[0];
  }
}
