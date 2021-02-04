// Time,Space complexity -> O(n)

import java.util.*;

class Program {
  public static String longestSubstringWithoutDuplication(String str) {
		Map<Character,Integer> map = new HashMap<>();
		int[] ans = {0,1};
		int startIdx = 0;
		for(int i = 0 ; i< str.length();i++){
			char c = str.charAt(i);
			// 
			if(map.containsKey(c)){
				startIdx = Math.max(startIdx,map.get(c) + 1);
			}
			
			if(ans[1] - ans[0] < i+1 - startIdx ){
				ans = new int[] {startIdx,i+1};
			}
			map.put(c,i);
		}
		
    return str.substring(ans[0],ans[1]);
  }
}
