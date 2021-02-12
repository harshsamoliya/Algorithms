// Time complexity -> O(n*m)
// space complexity -> O(n*m)


import java.util.*;

class Program {
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
		int[][] dp = new int[str1.length+1][str2.length+1];
		for(int i = 1 ; i< dp.length ; i++){
			for(int j = 1 ; j<dp[0].length;j++){
				if(str1[i-1]==str2[j-1]){
					dp[i][j] = dp[i-1][j-1] +1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[dp.length][dp[0].length];
  }
}
