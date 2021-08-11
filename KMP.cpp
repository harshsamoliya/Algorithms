using namespace std;

bool knuthMorrisPrattAlgorithm(string str, string substr) {
	// cses string matching
	// preporecissing substr O(m)
	// then find pattern in main string O(n)
	// total time complexity -> O(n+m);
	// step -> 1 preproccing
	vector<int> pattern(substr.size(),-1);
	int j = 0;
	int i = 1;
	while(i < substr.size()){
		if(substr[i]==substr[j]){
			pattern[i] = j;
			i++,j++;
		}else if(j>0){
			j = pattern[j-1] + 1;
		}else{
			i++;
		}
	}
	// step -> 2
	i = 0;
	j = 0;
	while(i+substr.size()-j <= str.size()){
		if(str[i] == substr[j]){
			if(j == (int)substr.size()-1){
				return true;
			}
			i++,j++;
		}else if(j > 0){
			j = pattern[j-1] + 1;
		}else{
			i++;
		}
	}
	return false;
}
