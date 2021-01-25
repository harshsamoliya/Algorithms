// Time complexity ->O(n*c) // n is the no. of items, c is capacity 
// Space complexity ->(n*c) 

import java.util.*;
class Program {
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
		int[][] dp = new int[items.length+1][capacity+1];
		for(int i = 1 ; i<dp.length;i++){
			int currentweight = items[i-1][1];
			int currentvalue = items[i-1][0];
			for(int j =0 ; j<dp[0].length;j++){
				if(currentweight>j){
					dp[i][j] = dp[i-1][j];
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-currentweight] + currentvalue);
				}
			}
		}
		return Helper(dp,items,dp[items.length][capacity]);
	}
	static List<List<Integer>> Helper(int[][] dp,int[][] items,int weight){
		List<List<Integer>> sequence = new ArrayList<>();
		List<Integer> totalweight = new ArrayList<>();
		totalweight.add(weight);
		sequence.add(totalweight);
		sequence.add(new ArrayList<Integer>());
		int i = dp.length-1;
		int j = dp[0].length-1;
		while(i>0){
			if(dp[i-1][j]==dp[i][j]) i--;
			else {
				sequence.get(1).add(0,i-1);
				j-=items[i-1][1];
				i--;
			}
			if(j==0) break;
		}
		return sequence;
	}
}
