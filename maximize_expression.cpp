// time and space complexity -> O(n)
#include <vector>
using namespace std;

int maximizeExpression(vector<int> array) {
	if(array.size()<4) return 0;
	
	vector<int> maxA(array.size(),INT_MIN);
	vector<int> maxAB(array.size(),INT_MIN);
	vector<int> maxABC(array.size(),INT_MIN);
	vector<int> maxABCD(array.size(),INT_MIN);
	
	int value = INT_MIN;
	for(int i = 0 ; i<array.size();i++){
		value = max(array[i],value);
		maxA[i] = value;
	}
	value = INT_MIN;
	for(int i = 1;i<array.size();i++){
		value = max(maxA[i-1]-array[i],value);
		maxAB[i] = value;
	}
	value = INT_MIN;
	for(int i =2; i<array.size();i++){
		value = max(maxAB[i-1]+array[i],value);
		maxABC[i] = value;
	}
	value = INT_MIN;
	for(int i = 3;i<array.size();i++){
		value = max(maxABC[i-1]-array[i],value);
		maxABCD[i] = value;
	}
	return value;
}
