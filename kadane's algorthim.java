import java.util.*

private static int kadaneSum(int[] array){
	int sum = array[0];
	int sumsofar = array[0];
	for(int i = 1;i<array.length;i++){
	sum = Math.max(array[i],sum + array[1]);
	sumsofar = Math.max(sum,sumsofar);
	}
	return sumsofar;
}