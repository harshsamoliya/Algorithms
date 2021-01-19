// Time complexity -> O(n)
// space complexity -> O(1)

import java.util.*;

class Program {
  public String runLengthEncoding(String string) {
		StringBuilder sb = new StringBuilder();
		int currentLength = 1;
		for(int i = 1 ; i<string.length();i++){
			if(string.charAt(i)!=string.charAt(i-1) || currentLength==9){
				sb.append(Integer.toString(currentLength));
				sb.append(string.charAt(i-1));
				currentLength = 1;
			}else{
				currentLength++;
			}
		}
		sb.append(Integer.toString(currentLength));
		sb.append(string.charAt(string.length()-1));
		return sb.toString();
  }
}
