// time complexity -> O(nlog(n)) space complexity -> O(n)
#include <vector>
using namespace std;
int mergedInversion(vector<int> &array,int start,int middle,int end){
	// main focus 
	vector<int> sortedarray;
	int left = start;
	int right = middle;
	int inversion = 0;
	while(left<middle && right<end){
		if(array[left]<=array[right]){
			// already sorted
			sortedarray.push_back(array[left]);
			left++;
		}else{
			// checking how many element are unsorted 
			inversion += middle - left;
			sortedarray.push_back(array[right]);
			right++;
		}
	}
	
	for(int i  = left; i < middle; i++ ){
		sortedarray.push_back(array[i]);
	}
	
	for(int i  = right ; i < end; i++ ){
		sortedarray.push_back(array[i]);
	}
	for(int idx = 0 ;idx<sortedarray.size();idx++){
		int value  = sortedarray[idx];
		array[start + idx] = value;
	}
	return inversion;
}
int SubInversion(vector<int> &array,int start,int end){
	if(end-start<=1){
		return 0;
	}
	int middle = start + (end-start)/2; 
	int leftInversion = SubInversion(array,start,middle);
	int RightInversion = SubInversion(array,middle,end);
	int mergedArrayInversion = mergedInversion(array,start,middle,end);
	return mergedArrayInversion + leftInversion + RightInversion;
}
int countInversions(vector<int> array) {
	return SubInversion(array,0,array.size());
}
