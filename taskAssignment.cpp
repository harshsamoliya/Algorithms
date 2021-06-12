// time complexity -> O(nlog(n)) and space complexity -> O(n)
#include <vector>
using namespace std;

unordered_map<int,vector<int>> getTaskDuration(vector<int> tasks){
	unordered_map<int,vector<int>> tasksDurationToindices;
	for(int i = 0 ; i< tasks.size() ; i++){
		auto taskduration = tasks[i];
		if(tasksDurationToindices.find(taskduration)!=tasksDurationToindices.end()){
			tasksDurationToindices[taskduration].push_back(i);
		}else{
			tasksDurationToindices[taskduration] = vector<int> {i};
		}
	}
	return tasksDurationToindices;
}
vector<vector<int>> taskAssignment(int k, vector<int> tasks) {
	vector<vector<int>> pairedtask;
	auto taskDurationToIndicies = getTaskDuration(tasks);
	
	vector<int> sortedtask(tasks);
	sort(sortedtask.begin(),sortedtask.end());
	for(int idx = 0 ; idx< k ;idx++){
		auto task1Duration = sortedtask[idx];
		auto indiceswithTaskduration = &taskDurationToIndicies[task1Duration];
		auto task1Index = indiceswithTaskduration->back();
		indiceswithTaskduration->pop_back();
		// same thing for ending task
		auto task2Duration = sortedtask[tasks.size()-1-idx];
		auto indiceswithTask2duration = &taskDurationToIndicies[task2Duration];
		auto task2Index = indiceswithTask2duration->back();
		indiceswithTask2duration->pop_back();
		
		pairedtask.push_back((vector<int>){task1Index,task2Index});
	}
	return pairedtask;
}
