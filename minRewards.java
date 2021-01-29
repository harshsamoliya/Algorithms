// Time complexity -> O(n)
// Space complexity -> O(n)

public static int minRewards(int[] scores) {
    int[] dp  = new int[scores.length];
    Arrays.fill(dp,1);
    for(int i = 1; i < scores.length;i++){
        if(scores[i] > scores[i-1]){
            dp[i] = dp[i-1] + 1;
        }
    }
    //
    for(int i = scores.length-2 ; i>=0 ; i--){
        if(scores[i]>scores[i+1]){
            dp[i] = Math.max(dp[i],dp[i+1] + 1);
        }
    }
    return IntStream.of(dp).sum();
}
