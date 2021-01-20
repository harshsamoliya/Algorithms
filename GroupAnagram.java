// Time complexity -> O(w * (n*log(n)) )
// Space complexity -> O(w*n)
// w is the total words
// n is the longest word in words

import java.util.*;
class Program {
  public static List<List<String>> groupAnagrams(List<String> words){
		Map<String,List<String>> map = new HashMap<>();
		for(int i = 0 ; i<words.size();i++){
			char[] c = words.get(i).toCharArray();
			Arrays.sort(c);
			String ans = new String(c);
			if(map.containsKey(ans)){
				map.get(ans).add(words.get(i));
			}else{
				map.put(ans,new ArrayList<String>(Arrays.asList(words.get(i))));
			}
		}
		return new ArrayList<>(map.values());
	}
}
