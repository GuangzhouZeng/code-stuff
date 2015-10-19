/*
 * Student.c
 *
 * Description: This file has main function of students' part. It will implement two things: send information to admission office and get back result.
 *  Created on: Jul 29, 2015
 *      Author: guangzhz
 */

#include "Student.h"


int main(int argc, char* argv[]){
	if (argc >1) {
		fprintf(stderr, "usage:./Department\n");
		exit(1);
	}

	int i;
	for(i=1;i<=5;i++){		//fork five children
		if(fork()==0){
			sendStuInfo(i);	//send students information
			recvResult(i);	//get back result
			exit(0);
		}
	}

	while(wait(NULL)>-1);
	return 0;
}
