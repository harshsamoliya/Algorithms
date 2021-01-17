// Time complexity -> O(v^2 +e) 
// space complexity -> O(v)

import java.util.*;

class Program {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
		int NumberOfVertices = edges.length;
		int[] minDistance = new int[edges.length];
		Arrays.fill(minDistance,Integer.MAX_VALUE);
		minDistance[start] = 0 ;
		Set<Integer> visited = new HashSet<>();
		while(visited.size()!=NumberOfVertices){
			int[] getData = getMinDistance(minDistance,visited);
			int vertex = getData[0];
			int currMinDist = getData[1];
			
			if(currMinDist==Integer.MAX_VALUE){
				break;
			}
			visited.add(vertex);
			for(int[] edge : edges[vertex] ){
				int destination = edge[0];
				int distanceToDest = edge[1];
				if(visited.contains(destination)){
					continue;
				}
				int newdistance = currMinDist + distanceToDest;
				int currentNewDistance = minDistance[destination];
				if(newdistance<currentNewDistance){
					minDistance[destination] = newdistance;
				}
			}
		}
		//////////////////////////Above code is important//////////////////////////////
		// replacing all INteger.MAX_VALUE with -1 and putting in finalDistance
		int[] finalDistance = new int[minDistance.length];
		for(int i = 0 ; i<minDistance.length;i++){
			if(minDistance[i]==Integer.MAX_VALUE){
				finalDistance[i] = -1;
			}else{
				finalDistance[i] = minDistance[i];
			}
		}
		return finalDistance;
  }
	public int[] getMinDistance(int[] Distance,Set<Integer> visited){
		int currentMinDistance = Integer.MAX_VALUE;
		int vertex = -1;
		for(int i = 0 ; i<Distance.length;i++){
			int distance = Distance[i];
			if(visited.contains(i)){
				continue;
			}
			if(distance<=currentMinDistance){
				vertex = i;
				currentMinDistance = distance;		
			}
		}
		return new int[]{vertex,currentMinDistance};
	}
}
