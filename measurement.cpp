// time complexity -> O(low * high * n)
// space complexity -> O(low*high)
#include <vector>
#include<unordered_map>
using namespace std;
string hashablekey(int low,int high){
	return to_string(low)+":"+to_string(high);
}
bool canMeasure(vector<vector<int>> &measuringCups,int low,int high,unordered_map<string,bool> &memorize){
	string answer = hashablekey(low,high);
	if(memorize.find(answer)!=memorize.end()){
		return memorize[answer];
		// if we already find the solution
	}
	// base case;
	if(low<=0 && high<=0){
		return false;
	}
	bool canmeasure = false;
	for(auto &cup : measuringCups){
		int lowcup = cup[0];
		int highcup = cup[1];
		if(low<=lowcup && high>=highcup){
			// then it is in range and we can measure;
			canmeasure = true;
			break;
		}
		canmeasure = canMeasure(measuringCups,low-lowcup,high-highcup,memorize);
		if(canmeasure){
			// if it is true
			break;
		}
	}
	memorize[answer] = canmeasure;
	return canmeasure;
}
bool ambiguousMeasurements(vector<vector<int>> measuringCups, int low,int high) {
	unordered_map<string,bool> memorize;
	return canMeasure(measuringCups,low,high,memorize);
}
