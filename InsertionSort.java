import java.util.*;
// Best->O(n)
// Avg -> O(n^2)
// Worst -> O(n^2)

// Space->O(1)
class Program {
  public static int[] insertionSort(int[] array) {
		for(int gap = array.length/2;gap>0;gap/=2){
			for(int i = gap;i<array.length;i++){
				int Newnumber = array[i];
				int j ;
				for( j = i ; j>=gap && array[j-gap]>Newnumber;j-=gap){
					array[j] = array[j-gap];
				}
				array[j] = Newnumber;
			}
		}
    return array;
  }
}
