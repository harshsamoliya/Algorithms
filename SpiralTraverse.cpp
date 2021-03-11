// Time complexity -> O(n)
// Space Complexity -> O(n)


void helper(vector<vector<int>> &arr, int startrow, int endrow, int startcol, int endcol, vector<int> &ans) {
	if (startrow > endrow || startcol > endcol) {
		return;
	}
	for (int j = startcol; j <= endcol; j++) {
		ans.push_back(arr[startrow][j]);
	}
	for (int i = startrow + 1; i <= endrow; i++) {
		ans.push_back(arr[i][endcol]);
	}
	for (int j = endcol - 1; j >= startcol; j--) {
		if (startrow == endrow) break;
		ans.push_back(arr[endrow][j]);
	}
	for (int i = endrow - 1; i >= startrow + 1; i--) {
		if (startcol == endcol) break;
		ans.push_back(arr[i][startcol]);
	}
	helper(arr, startrow + 1, endrow - 1, startcol + 1, endrow - 1, ans);
}
vector<int> spiralTraverse(vector<vector<int>> array) {
	if (array.size() == 0) {
		return {};
	}
	vector<int> ans {};
	helper(array, 0, array.size() - 1, 0, array[0].size() - 1, ans);
	return ans;
}
