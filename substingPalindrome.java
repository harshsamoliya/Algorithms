// TIme  complexity -> O(n*n)
// Space complexity -> O(n)

import java.util.*;

class Program {
  public static String longestPalindromicSubstring(String str) {
		int left = 0;
		int right = 1;
		int min = Integer.MIN_VALUE;
		for(int i = 1 ;i<str.length();i++){
			int[] odd = Solve(str,i-1,i+1);
			int[] even = Solve(str,i-1,i);
			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
			if(longest[1] - longest[0]>min){
				min = longest[1] - longest[0];
				left = longest[0];
				right = longest[1];
			}
		}
		return str.substring(left,right);
  }
	public static int[] Solve(String str,int i,int j){
		while(i>=0 && j<str.length()){
			if(str.charAt(i)!=str.charAt(j)){
				break;
			}
			i--;
			j++;
		}
		return new int[] {i+1,j};
	}
}
