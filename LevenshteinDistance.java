// Time Complexity -> O(n*m)
// n -> length of string 1 , m-> length of string 2
// Space Complexity -> O(n*m)
import java.util.*;

class Program {
  public static int levenshteinDistance(String str1, String str2) {
		int[][] dp = new int[str2.length()+1][str1.length()+1];
		for(int i = 0 ;i<dp.length;i++){
			for(int j = 0 ;j<dp[0].length;j++){
				dp[i][j] = j;
			}
			dp[i][0] = i;
		}
		
		for(int i =1;i<dp.length;i++){
			for(int j = 1 ;j<dp[0].length;j++){
				if(str2.charAt(i-1)==str1.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
}
