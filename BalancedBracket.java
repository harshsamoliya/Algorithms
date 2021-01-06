// time complexity -> O(n)
// space complexity -> O(n)

import java.util.*;

class Program {
  public static boolean balancedBrackets(String str) {
		String opening = "({[";
		String closing = ")}]";
		Map<Character,Character> map = new HashMap<>();
		map.put(')','(');
		map.put('}','{');
		map.put(']','[');
		Stack<Character> stack = new Stack<>();
		for(int i = 0 ; i<str.length();i++){
			char letter  = str.charAt(i);
			if(opening.indexOf(letter) != -1){
				stack.add(letter);
			}else if(closing.indexOf(letter) != -1){
				if(stack.size()==0){
					return false;
				}
				if(stack.get(stack.size()-1)==map.get(letter)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.size()==0;
  }
}
