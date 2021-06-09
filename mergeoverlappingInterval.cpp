// time complexity -> o( nlog(n)) and space complexity -> o(n)
#include <vector>
using namespace std;

vector<vector<int>> mergeOverlappingIntervals(vector<vector<int>> intervals) {
	vector<vector<int>> sortedinterval = intervals;
	sort(sortedinterval.begin(),sortedinterval.end(),[](vector<int> a,vector<int> b){ return a[0] < b[0];});
	vector<vector<int>*> merge;
	vector<int> *current = &sortedinterval[0];
	merge.push_back(current);
	for(auto &nextinterval : sortedinterval){
		int currentintervalend = current->at(1);
		int nextintervalstart = nextinterval[0];
		int nextintervalend = nextinterval[1];
		if(nextintervalstart <= currentintervalend){
			current->at(1) = max(currentintervalend,nextintervalend); 
		}else{
			current = &nextinterval;
			merge.push_back(current);
		}
	}
	vector<vector<int>> ans;
	for(auto &i : merge){ans.push_back(*i);}
	return ans;
}
