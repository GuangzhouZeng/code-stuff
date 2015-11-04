//============================================================================
// Name        : DPP.cpp
// Author      : guangzhz
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
#include <cfloat>
using namespace std;

#define PROBLEM 2
#if PROBLEM==1
int theta1=1;
int theta2=5;
int theta3=5;
#else
int theta1 = 1;
int theta2 = 2;
int theta3 = 2;
#endif

//int v=10;
int C = 1;
int b = 5;

int main() {
	double vtemp[12] = { 0.0, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.5, 2.0, 5.0, 10.0,
			20.0 };
	vector<double> V(vtemp, vtemp + 12);

	for (int i = 0; i < 12; i++) {

		int size = (V[i] + 1) * 100000;
		vector<double> x1(size + 1, 0);
		vector<double> x2(size + 1, 0);
		vector<double> x3(size + 1, 0);
		vector<double> Q(size + 1, 0);
		double sum1 = 0, sum2 = 0, sum3 = 0;
		double maxQ=0; //Q[0]=0;

		x1[0] = C;
		x2[0] = C;
		x3[0] = C;

		for (int t = 1; t < size; t++) {
			Q[t + 1] = max(Q[t] + x1[t] + x2[t] + x3[t] - C, 0.0);

			if (Q[t + 1] == 0)
				Q[t + 1] = 1e-6;
			x1[t + 1] = (V[i] * theta1 / Q[t + 1] - 1) / (double) b;
			x2[t + 1] = (V[i] * theta2 / Q[t + 1] - 1) / (double) b;
			x3[t + 1] = (V[i] * theta3 / Q[t + 1] - 1) / (double) b;

			if (x1[t + 1] >= C)
				x1[t + 1] = C;
			if (x1[t + 1] <= 0)
				x1[t + 1] = 0;

			if (x2[t + 1] >= C)
				x2[t + 1] = C;
			if (x2[t + 1] <= 0)
				x2[t + 1] = 0;

			if (x3[t + 1] >= C)
				x3[t + 1] = C;
			if (x3[t + 1] <= 0)
				x3[t + 1] = 0;

			//cout<<"loop"<<t<<": "<<x1[t+1]<<" "<<x2[t+1]<<" "<<x3[t+1]<<endl;
			sum1 += x1[t + 1];
			sum2 += x2[t + 1];
			sum3 += x3[t + 1];

			maxQ=max(maxQ,Q[t+1]);
			//max2=max(max2,Q[t+1]);
			//max3=max(max3,Q[t+1]);
		}
		double avg1 = sum1 / size;
		double avg2 = sum2 / size;
		double avg3 = sum3 / size;
		cout << "------------" << i << "---------------------" << endl;
		cout << "avg1:" << avg1 << endl;
		cout << "avg2:" << avg2 << endl;
		cout << "avg3:" << avg3 << endl;

		//cout << "maxQ:" << maxQ << endl;

		cout << endl;

	}
	return 0;
}
