// Time Complexity & Space complexity -> O( w*h )
#include <vector>
using namespace std;
vector<vector<int>> getNeigh(vector<vector<int>> &matrix,int row,int col){
	vector<vector<int>> neigh;
	int rowlength = matrix.size();
	int collength = matrix[row].size();
	if(row-1>=0){
		neigh.push_back(vector<int> {row-1,col});
	}
	if(col-1>=0){
		neigh.push_back(vector<int> {row,col-1});
	}
	if(row+1<rowlength){
		neigh.push_back(vector<int> {row+1,col});
	}
	if(col+1<collength){
		neigh.push_back(vector<int> {row,col+1});
	}
	return neigh;
}
void changeonetoTwos(vector<vector<int>> &matrix,int row,int col){
	vector<vector<int>> stack = {{row,col}};
	while(stack.size() > 0){
		auto currentposition = stack[stack.size()-1];
		stack.pop_back();
		int CurrRow = currentposition[0];
		int CurrCol = currentposition[1];
		matrix[CurrRow][CurrCol] = 2;
		auto neigh = getNeigh(matrix,CurrRow,CurrCol);
		for(auto neighbour: neigh){
			int neighRow = neighbour[0];
			int neighCol = neighbour[1];
			if(matrix[neighRow][neighCol]!=1){
				continue;
			}
			stack.push_back(neighbour);
		}
	}
}
vector<vector<int>> removeIslands(vector<vector<int>> matrix) {
	for(int row = 0; row < matrix.size(); row++){
		for(int col = 0; col < matrix[0].size(); col++){
			bool rowIsBorder = row==0 || row==matrix.size()-1;
			bool colIsBorder = col==0 || col==matrix[row].size()-1;
			if(!(rowIsBorder || colIsBorder)){
				continue;
			}
			if(matrix[row][col]!=1){
				continue;
			}
			changeonetoTwos(matrix,row,col);
		}
	}
	for(auto &row : matrix){
		for(auto &val : row){
			if(val==1){
				val = 0;
			}else if(val==2){
				val = 1;
			}
		}
	}
  return matrix;
}
