// Time complexity -> O(n)
// Space complexity -> O(n)

import java.util.*;

class Program {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        boolean goingDown = true;
        while(!isGoingoutofBound(i,j,array.size()-1,array.get(0).size()-1)){
            list.add(array.get(i).get(j)); // array[i][j]
            if(goingDown){
                if(j == 0 || i == array.size()-1 ) {
                    goingDown = false;
                    if(i==array.size()-1) {
                        j++;
                    }else{
                        i++;
                    }
                }else{
                    i++;
                    j--;
                }
            }else {
                if(i==0 || j==array.get(0).size()-1){
                    goingDown = true;
									if(j==array.get(0).size()-1){
										i++;
									}else{
										j++;
									}
								}else {
                    j++;
                    i--;
                }
            }
        }
        return list;
    }
    static boolean isGoingoutofBound(int i,int j , int maxX,int maxY){
        return (i<0 || i>maxX || j > maxY || j<0);
    }
}
