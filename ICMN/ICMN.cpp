//============================================================================
// Name        : ICMN.cpp
// Author      : guangzhz
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
using namespace std;

vector<vector<int> > getInput(){
	int n=5;
	vector<vector<int> > input(n,vector<int>(n,INT_MAX));
	for(int i=0;i<n;i++){
		input[i][i]=0;
	}
	input[0][1]=1;
	input[1][0]=1;
	input[0][2]=3;
	input[2][0]=3;
	input[3][4]=4;
	input[4][3]=4;
	input[1][3]=5;
	input[3][1]=5;
	input[0][4]=2;
	input[4][0]=2;
	return input;
}

void dfs(vector<vector<int> > input, int src, int dest, vector<int> &path, vector<vector<int> > &res, int costTime) {
	if(dest<input.size()&&input[src][dest]<INT_MAX&&input[src][dest]>0){
		if(costTime>input[src][dest])
			return;
		path.push_back(dest);
		res.push_back(path);
		path.pop_back();
		return;
	}
	for(int i=0;i<input.size();i++){
		if(find(path.begin(),path.end(),i)==path.end()){
			if(input[src][i]<INT_MAX&&input[src][i]>0){
				if(costTime>input[src][i]) continue;
				path.push_back(i);
				dfs(input,i,dest,path,res,input[src][i]);
				path.pop_back();
			}
		}
	}
}

int main() {
	//get from users
	vector<vector<int> > input=getInput();
	int src=0;
	int dest=3;

	vector<int> path;
	vector<vector<int> > res;
	int costTime=0;

	path.push_back(src);
	dfs(input,src,dest,path,res,costTime);
	if(res.size()==0){
		cout<<"no path found"<<endl;
		return 0;
	}
	for(int i=0;i<res.size();i++){
		cout<<"path "<<i+1<<" is: ";
		for(int j=0;j<res[i].size();j++){
			cout<<res[i][j]<<" ";
		}
		cout<<endl;
	}
	return 0;
}


