import java.util.*;
// Best->O(n)
// Avg -> O(n^2)
// Worst -> O(n^2)

// Space->O(1)
class Program {
  public static int[] bubbleSort(int[] array) {
		if(array.length==0){
			return new int[]{};
		}
		for(int i = 0 ;i<array.length;i++){
			for(int j = 1;j<array.length;j++){
				if(array[j]<array[j-1]){
					swap(array,j,j-1);
				}
			}
		}
		return array;
  }
	private static void swap(int[] array , int i , int j){
		if(i==j){
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
