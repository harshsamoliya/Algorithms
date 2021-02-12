// Time comlpexity -> O(n*m) where n is the stair and m is the maxJump
// space complexity -> O(n)


import java.util.*;

class Program {

  public int staircaseTraversal(int height, int maxSteps) {
		int[] dp =  new int [height +1];
		dp[0] =1 ;
		dp[1] = 1;
		for(int i = 2 ; i< height+1 ; i++){
			for(int j = 1 ; j <=Math.min(i,maxSteps);j++){
				dp[i]+=dp[i-j];
			}
		}
    return dp[height];
  }
}
