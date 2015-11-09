//============================================================================
// Name        : ee550miniProj_2.cpp
// Author      : guangzhz
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
using namespace std;

int solver(vector<int> time, int D){
	//construct the new time table with S0=0 and Sn+1=0
	vector<int> timetable(time.begin(),time.end());
	timetable.insert(timetable.begin(),0);
	timetable.push_back(0);
	int n=timetable.size();

	//initialize opt array
	vector<int> opt(n,0);
	for(int i=1;i<=D;i++){
		opt[i]=timetable[i];
	}
	//solve recurrence formula one by one
	for(int i=D+1;i<n;i++){
		int minPre=INT_MAX;
		for(int j=1;j<=D;j++){
			minPre=min(minPre,opt[i-j]);
		}
		opt[i]=max(minPre,timetable[i]);
	}
	//out put the opt[] array
	for(int i=0;i<n;i++){
		cout<<opt[i]<<" ";
	}
	//return the solution
	return opt[n-1];
}

int main() {
	int timetable[]={1,3,1,8,2,4,8,2,4,5,6,4,8,2,3,9,10,3,1,3,4,4,5,5,6,3,1,2,5,6,7,4,5,6,3,2,1,3,5,7,8,6,4,2,1,1,4,4,5,5};
	int D=3;
	vector<int> time(timetable,timetable+sizeof(timetable)/sizeof(int));
	cout<<sizeof(timetable)/sizeof(int)<<" stations:"<<endl;
	cout<<endl<<solver(time,D);
	return 0;
}


