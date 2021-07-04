// Time and SPace complexity -> O(w*h)
// where w and h are width and height

#include <vector>
using namespace std;
vector<vector<int>> createSumMatrix(vector<vector<int>> &matrix){
	vector<vector<int>> sums(matrix.size(),vector<int> (matrix[0].size()));
	sums[0][0]= matrix[0][0];
	// for first row //left
	for(int i = 1; i<matrix[0].size() ; i++){
		sums[0][i] = sums[0][i-1] + matrix[0][i];
	}
	// for first col // up
	for(int j = 1;j<matrix.size();j++){
		sums[j][0] = sums[j-1][0] + matrix[j][0];
	}
	// for other element up + left - diagonal
	for(int i = 1;i<matrix.size();i++){
		for(int j =1 ;j<matrix[0].size();j++){
			sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
		}
	}
	return sums;
}
int maximumSumSubmatrix(vector<vector<int>> matrix, int size) {
  vector<vector<int>> sums = createSumMatrix(matrix);
	int maxsum = INT_MIN;
	for(int row = size-1 ; row<matrix.size();row++){
		for(int col = size-1;col<matrix[row].size();col++){
			// take out sum upto
			int total = sums[row][col];
			if(row-size>=0){
				total -= sums[row-size][col];
			}
			if(col-size>=0){
				total -= sums[row][col-size];
			}
      // to excule double subtraction in above process
			if(row-size>=0 && col-size>=0){
				total += sums[row-size][col-size];
			}
			maxsum = max(maxsum,total);
		}
	}
	return maxsum;
}
