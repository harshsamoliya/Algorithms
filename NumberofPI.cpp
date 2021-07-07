// Time complexity -> O(n^3 + m) and space complexity -> O(n+m)
// n is length of no. pi & m is fav number
#include <vector>
using namespace std;
// left to right approach
int getMinSpace(string pi,set<string> numbertable,unordered_map<int,int> &cache,int idx){
	if(idx==pi.length()){
		return -1;
	}
	if( cache.find(idx) != cache.end() ){
		return cache[idx];
	}
	// intiazle minSpace with INT_MAX;
	int minSpace  = INT_MAX;
	for(int i = idx ; i<pi.length() ; i++){
		string prefix = pi.substr(idx,i+1-idx);
		if(numbertable.find(prefix)!=numbertable.end()){
			// we have found prefix
			int minSpaceInSuffix = getMinSpace(pi,numbertable,cache,i+1);
			// if it overflow
			// minSpace = min(minSpace,minSpaceInSuffix+1);
			if(minSpaceInSuffix==INT_MAX){
				minSpace = min(minSpace,minSpaceInSuffix);
			}else{
				minSpace = min(minSpace,minSpaceInSuffix+1);
			}
		}
	}
	cache[idx] = minSpace;
	return minSpace;
}
int numbersInPi(string pi, vector<string> numbers) {
	set<string> numbertable;
	for(auto &i : numbers){
		numbertable.insert(i);
	}
	unordered_map<int,int> cache;
	int minnumberofPI = getMinSpace(pi,numbertable,cache,0);
	return minnumberofPI==INT_MAX ? -1 : minnumberofPI;
}
