/*
 * Department.c
 *
 * Description: This file has main function of departments' part. It will implement two things: send information to admission office and get back result.
 *  Created on: Jul 26, 2015
 *      Author: guangzhz
 */

#include "Department.h"

int main(int argc, char* argv[]) {
	if (argc >1) {
		fprintf(stderr, "usage:./Department\n");
		exit(1);
	}

	if(fork()!=0){		//this is parent process, represent DeptA
		/*here is Phase1*/
		sendProgram(1);	//send department to admission office. 1 for Dept A
		/*here is Phase2*/
		recvResult(1);	//get back result from admission office
	}else{				//this is child process, represent DeptB
		/*here is Phase1*/
		sendProgram(2);	//2 for Dept B
		/*here is Phase2*/
		recvResult(2);
		exit(0);
	}

	while(wait(NULL)>-1);

	return 0;
}

