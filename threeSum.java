// a+b+c == targerSum in an array
// time Complexity O(n*n)
// Space Complexity O(n)



import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);
		List<Integer[]> list = new ArrayList<>();
		for(int i = 0 ;i<array.length;i++){
			int current_no = i;
			int left = i+1;
			int right  = array.length-1;
			while(left<right){
				int current_sum = array[current_no] + array[left] + array[right];
				if(current_sum==targetSum){
					Integer[] lt = {array[current_no],array[left],array[right]};
					list.add(lt);
					left++;
					right--;
				}else if(current_sum<targetSum){
					left++;
				}else{
					right--;
				}
			}
		}
		return list;
	}
}
