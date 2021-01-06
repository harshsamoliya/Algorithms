// Time complexity -> O((2^n)*n)
// Space complexity -> O((2^n)*n)

// Iterative approach
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
// recursive _>
import java.util.*;

class Program {
  public static List<List<Integer>> powerset(List<Integer> array) {
		return powerset(array,array.size()-1);
	}
	static List<List<Integer>> powerset(List<Integer> array,int idx){
		if(idx<0){
			List<List<Integer>> empt = new ArrayList<>();
			empt.add(new ArrayList<>());
			return empt;
		}
		List<List<Integer>> subset =  powerset(array,idx-1);
		int length = subset.size();
		for(int i = 0 ; i<length ; i++){
			List<Integer> currentset = new ArrayList<>(subset.get(i));
			currentset.add(array.get(idx));
			subset.add(currentset);
		}
		return subset;
	}
}

