// Time and Space complexity both O(1)


import java.util.*;

class Program {
	static class MinMaxStack {
  List<Map<String,Integer>> minmaxStack = new ArrayList<Map<String,Integer>>();
	List<Integer> stack = new ArrayList<>();
		public int peek() {
      return stack.get(stack.size()-1);
    }

    public int pop() {
			minmaxStack.remove(minmaxStack.size()-1);
      return stack.remove(stack.size()-1);
    }

    public void push(Integer number) {
			Map<String,Integer> newminmax = new HashMap<>();
			newminmax.put("min",number);
			newminmax.put("max",number);
			if(minmaxStack.size()>0){
				Map<String,Integer> lastminmax = new HashMap<>(minmaxStack.get(minmaxStack.size()-1));
				newminmax.replace("min",Math.min(lastminmax.get("min"),number));
				newminmax.replace("max",Math.max(lastminmax.get("max"),number));			
			}
			minmaxStack.add(newminmax);
			stack.add(number);
		}
    public int getMin() {
			return minmaxStack.get(minmaxStack.size()-1).get("min");
    }

    public int getMax() {
			return minmaxStack.get(minmaxStack.size()-1).get("max");
    }
  }
}
