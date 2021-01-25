// Time complexity -> O(n)
// Space complexity ->O(n)

import java.util.*;

class Program {
  public static int waterArea(int[] heights) {
		int[] maxx = new int[heights.length];
		int leftmax = 0;
		for(int i = 0; i <heights.length;i++){
			maxx[i] = leftmax;
			leftmax = Math.max(leftmax,heights[i]);
		}
		int rightmax = 0;
		int total = 0 ;
		for(int i = heights.length-1 ; i>=0 ;i--){
			int minhight = Math.min(maxx[i],rightmax);
			if(heights[i]<minhight){
				total += minhight - heights[i];
			}else{
				total +=0;
			}
			rightmax = Math.max(rightmax,heights[i]);
		}
		return total;
	}
}
// OR //
// solution 2//
// Time complexity -> O(n)
// Space complexity ->O(1) 
import java.util.*;

class Program {
  public static int waterArea(int[] heights) {
		if(heights.length==0) return 0;
		int i = 0;
		int j = heights.length-1;
		int leftmax = heights[i];
		int rightmax = heights[j];
		int ans = 0;
		while(i<j){
			if(heights[i]<heights[j]){
				i++;
				leftmax = Math.max(leftmax,heights[i]);
				ans+=leftmax - heights[i];
			}else{
				j--;
				rightmax = Math.max(rightmax,heights[j]);
				ans+=rightmax - heights[j];	
			}
		}
		return ans;
	}
}
