// Time complexity -> O(n * n!)
// Space complexity -> O(n * n!)

import java.util.*;

class Program {
  public static List<List<Integer>> getPermutations(List<Integer> array) {
		List<List<Integer>> list = new ArrayList<>();
		solve(0,array,list);
		return list;
	}
	static void solve(int i,List<Integer> array,List<List<Integer>> list){
		if(i==array.size()-1){
			list.add(new ArrayList<> (array));
		}else{
			for(int j = i ; j<array.size();j++){
				swap(array,i,j);
				solve(i+1,array,list);
				swap(array,i,j);
			}
		}
	}
	
	static void swap(List<Integer> list ,int i ,int j){
		if(i==j) return;
		int temp = list.get(i);
		list.set(i,list.get(j));
		list.set(j,temp);
	}
}
