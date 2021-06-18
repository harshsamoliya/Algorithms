// time complexity and space -> O(1) & O(1)
#include <vector>
using namespace std;
bool isValidAtPosition(int value ,int row,int col,vector<vector<int>> &board);
bool trysomethingdiff(int row,int col,vector<vector<int>> &board);
bool solvePartialSudoko(int row,int col,vector<vector<int>> &board);

bool trysomethingdiff(int row,int col,vector<vector<int>> &board){
	for(int value = 1 ; value<=9 ;value++){
		if(isValidAtPosition(value,row,col,board)){
			board[row][col] = value;
			if(solvePartialSudoko(row,col+1,board)){
				return true;
			}
		}
	}
	board[row][col] = 0;
	return false;
}
bool isValidAtPosition(int value ,int row,int col,vector<vector<int>> &board){
	// we are validating value in row and column and subgrid .
	bool rowisValid = find(board[row].begin(),board[row].end(),value) == board[row].end();
	bool colIsValid = true;
	for(auto arr : board){
		if(arr[col] == value){
			colIsValid = false;
			break;
		}
	}
	if(!rowisValid || !colIsValid){
		/// if means the value is present in row or in col //
		// so our value is wrong
		return false;
	}
	// now if value is present in 3 * 3 subgrid then we return false
	int subgridrow = row/3 * 3;
	int subgridcol = col/3 * 3;
	for(int i = 0 ; i<3;i++){
		for(int j = 0 ; j<3 ;j++){
			if(board[i+subgridrow][j+subgridcol]==value){
				return false;
			}
		}
	}
	return true;
}
bool solvePartialSudoko(int row,int col,vector<vector<int>> &board){
	// this function search for values for 0 and backtrack if any problem occur
	int currentRow = row;
	int currentCol = col;
	if(currentCol==board[row].size()){
		// base case for recursive fn which start new row
		currentRow++;
		currentCol = 0;
		if(currentRow==board.size()){
			// we solve the sudoko
			return true;
		}
	}
	if(board[currentRow][currentCol]==0){
		return trysomethingdiff(currentRow,currentCol,board);
	}
	return solvePartialSudoko(currentRow,currentCol+1,board);
}
vector<vector<int>> solveSudoku(vector<vector<int>> board) {
	solvePartialSudoko(0,0,board);
  return board;
}
