#include <vector>
using namespace std;

// Time complexity -> O(n)
// Space complexity -> O(1)
bool isgood(int i,int num,vector<int> &array){
	if(i==0) return num <= array[i+1];
	else if(i==array.size()-1) return num >= array[i-1];
	else return num >= array[i-1] && num <= array[i+1];
}
vector<int> subarraySort(vector<int> array) {
	int minunsort = INT_MAX;
	int maxunsort = INT_MIN;
	bool issorted = true;
	for(int i = 0;i<array.size();i++){
		if(!isgood(i,array[i],array)){
			minunsort = min(minunsort,array[i]);
			maxunsort = max(maxunsort,array[i]);
			issorted = false;
		}
	}
	if(issorted){
		return {-1,-1};
	}
	int leftidx = 0;
	while(leftidx < array.size()){
		if(array[leftidx] > minunsort){
			break;
		}
		leftidx++;
	}
	int rightidx = array.size()-1;
	while(rightidx>=0){
		if(array[rightidx] < maxunsort){
			break;
		}
		rightidx--;
	}
	return {leftidx,rightidx};
}
