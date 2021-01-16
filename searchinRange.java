// Time complextiy -> 2*O(log(n)) -> O(log(n))
// Space complexity -> O(1)


// 1 2 3 4 5 45 45 45 45 45 6666//

import java.util.*;

class Program {
  public static int[] searchForRange(int[] array, int target) {
		int[] ans = {-1,-1};
		funtion(array,target,0,array.length-1,ans,true);
		funtion(array,target,0,array.length-1,ans,false);
		return ans;
  }
	public static void  funtion(int[] array,int target,int left,int right,int[] ans,boolean goleft){
		while(left<=right){
			int mid = left + (right-left)/2;
			if(array[mid]<target){
				left = mid+1;
			}else if(array[mid]>target){
				right = mid - 1;
			}else{
				if(goleft){
					if(mid ==0 || array[mid-1]!=target) {
						ans[0]  = mid;
						return;
					}else{
						right = mid - 1;
					}
				}else{
					if(mid ==array.length -1  || array[mid+1]!=target) {
						ans[1]  = mid;
						return;
					}else{
						left = mid + 1;
					}
				}
			}
		}
	}
}
