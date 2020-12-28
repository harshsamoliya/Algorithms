
// Time Complexity O(n)
// Space Complexity O(1)


import java.util.*;

class Program {
  	public int[] threeNumberSort(int[] array, int[] order) {
		int f  = order[0];
		int s  = order[1];
		int t  = order[2];
		// 
		int first = 0;
		int second = 0;
		int third = array.length-1;
		while(second<=third){
			int value = array[second];
			if(value == f){
				swap(array,first,second);
					first++;
					second++;
			}else if(value==t){
				swap(array,second,third);
				third--;
					// no action on second value
			}else{
				second++;
			}
		}
		return array;
	}
	private void swap(int[] array,int i,int j){
		if(i==j){
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static int[] threeNumberSort2(int[] array,int[] order){
        int f = order[0];
        int t = order[2];
        int firstIdx = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]==f){
                swap(array,firstIdx,i);
                firstIdx++;
            }
        }
        int thirdIdx = array.length-1;
        for(int i = array.length-1;i>=0;i--){
            if(array[i]==t){
                swap(array,thirdIdx,i);
                thirdIdx--;
            }
        }

        return array;
    }
}

