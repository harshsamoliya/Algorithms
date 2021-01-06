// Time complexity -> O((2^n)*n)
// Space complexity -> O((2^n)*n)

import java.util.*;

class Program {
  public static List<List<Integer>> powerset(List<Integer> array) {
		List<List<Integer>> subset = new ArrayList<>();
		subset.add(new ArrayList<>());
		for(Integer ele : array){
			int leng = subset.size();
			for(int i = 0 ; i <leng;i++){
				List<Integer> currentSubset = new ArrayList<>(subset.get(i));
				// currentSubset.add();
				currentSubset.add(ele);
				subset.add(currentSubset);
			}
		}
		return subset;
	}
}
