// Time complexity -> O(n*n)
// space complexity -> O(n)
// disk have dimension of width,depth,height

import java.util.*;

class Program {
    public static int  diskStacking(List<Integer[]> disks) {
        disks.sort((disks1,disks2) -> disks1[2].compareTo(disks2[2]));
        
        int height[] = new int[disks.size()];
        for(int i = 0; i<disks.size();i++){
            height[i] = disks.get(i)[2];
        }
        //
        int max = 0;
        for(int i = 0; i<disks.size();i++){
            Integer[] currentDisk = disks.get(i);
            for(int j = 0;j<i;j++){
                Integer[] otherDisk  = disks.get(j);
                if(check(otherDisk,currentDisk)){
                    if(height[i]<=height[j] + currentDisk[2]){
                        height[i] =height[j] + currentDisk[2];
                        max = Math.max(max,height[i]);
                    }
                }
            }
        }
        return max;
    }
    public static Boolean check(Integer[] o,Integer[] c){
        return o[0]<c[0] && o[1] < c[1] && o[2] < c[2];
    }
}
