import java.util.*;

// time Complexity -> O(n^2)
// space Complexity -> O(n)
// dp
class Program {
  public static int minNumberOfJumps(int[] array) {
		int[] dp = new int[array.length];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 0 ; i<array.length;i++){
			for(int j = 0 ;j<i;j++){
				if(array[j]+j>=i){
					dp[i] = Math.min(dp[i],dp[j]+1);
				}
			}
		}
		return dp[array.length-1];
  }
}
// time Complexity -> O(n)
// space Complexity -> O(1)
class Program {
  public static int minNumberOfJumps(int[] array) {
		if(array.length==1){
			return 0;
		}
		int maxReach = array[0];
		int steps = array[0];
		int jump  = 0;
		for(int i = 1  ;i<array.length-1;i++){
			maxReach  = Math.max(maxReach,array[i]+i);
			steps--;
			if(steps==0){
				jump++;
				steps = maxReach - i;
			}
		}
		return jump +1;
  }
}

