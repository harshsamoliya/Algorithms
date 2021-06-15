using namespace std;
// Best time complexity
bool helper(string one ,string two,int i,int j ,string three,vector<vector<int>> &cache){
	if(cache[i][j]!=-1){
		return cache[i][j];
	}
	if(i+j==three.size()) return true;
	if(i<one.size() && one[i]==three[i + j]){
		cache[i][j] = helper(one,two,i+1,j,three,cache);
		if(cache[i][j] == true){
			return true;
		}
	}
	if(j<two.size() && two[j]==three[i + j]){
		cache[i][j] = helper(one,two,i,j+1,three,cache);
		if(cache[i][j] == true){
			return true;
		}
	}
	cache[i][j] = false;
	return false;
}

bool interweavingStrings(string one, string two, string three) {
	if(one.size() + two.size() != three.size()) return false;
	vector<vector<int>> cache(one.size()+1,vector<int> (two.size()+1));
	for(auto &i : cache){
		for(auto &j : i){
			j = -1;
		}
	}
	return helper(one,two,0,0,three,cache);
}
