import java.util.*;

class Program {
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        disks.sort((disks1,disks2) -> disks1[2].compareTo(disks2[2]));
        int height[] = new int[disks.size()];
        for(int i = 0; i<disks.size();i++){
            height[i] = disks.get(i)[2];
        }
        int sequence[] = new int[disks.size()];
        Arrays.fill(sequence,Integer.MIN_VALUE);
        //
        int maxHeighIndex = 0;
        for(int i = 0; i<disks.size();i++){
            Integer[] currentDisk = disks.get(i);
            for(int j = 0;j<i;j++){
                Integer[] otherDisk  = disks.get(j);
                if(check(otherDisk,currentDisk)){
                    if(height[i]<=height[j] + currentDisk[2]){
                        height[i] =height[j] + currentDisk[2];
                        sequence[i] = j;
                    }
                }
            }
            if(height[i]>=height[maxHeighIndex]){
                maxHeighIndex = i;
            }
        }
        return buildSequence(disks,sequence,maxHeighIndex);
    }
    public static Boolean check(Integer[] o,Integer[] c){
        return o[0]<c[0] && o[1] < c[1] && o[2] < c[2];
    }
    public static List<Integer[]> buildSequence(List<Integer[]> disk, int []sq,int maxheightIndex){
        List<Integer[]> sequence = new ArrayList<>();
        while(maxheightIndex!=Integer.MIN_VALUE){
            sequence.add(0,disk.get(maxheightIndex));
            maxheightIndex = sq[maxheightIndex];
        }
        return sequence;
    }
}
