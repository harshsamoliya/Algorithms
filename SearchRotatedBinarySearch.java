// time complexity -> O(log(n))
// space complexity -> O(1)

import java.util.*;

class Program {
  public static int shiftedBinarySearch(int[] array, int target) {
		int i = 0; 
		int j = array.length-1 ;
		while(i<=j){
			int mid = i + (j-i)/2;
			if(target==array[mid]){
				// answer 
				return mid;
			}else if(array[mid]>=array[i]){
				// left side 
				if(target>=array[i] && target<array[mid]){
					j = mid - 1;
				}else{
					i = mid + 1;
				}
			}else{
				// right side
				if(target>array[mid] && target<=array[j]){
					i = mid + 1;
				}else{
					j = mid - 1;
				}
			}
		}
		return -1;
  }
}
