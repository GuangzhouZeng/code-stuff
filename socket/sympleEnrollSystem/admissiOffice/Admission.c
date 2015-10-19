/*
 * Admission.c
 *
 * Description: This file has main function. Admission office will construct data structures for students/prpgrams and deal with the application in this file
 *  Created on: Jul 28, 2015
 *      Author: guangzhz
 */
#include "Admission.h"

Program progArr[PROGSIZE];
Student stuArr[STUSIZE];
char ip_addr[NAMESIZE];


//read student's information from file to stuArr
/* format
4#GPA#3.9
4#Interest1#A4
4#Interest2#B2
4#isValid#1
*/
void readStuFile(){
	char buf[DATASIZE];
	FILE *fp=fopen(FILESTUD,"r");
	if(fp==NULL){
		fprintf(stderr,"fail to open studentInfo.txt\n");
		exit(1);
	}
	while(fgets(buf,sizeof(buf),fp)!=NULL){
		char* temp = strtok(buf,"#");
		int tag=atoi(temp);
		char *key=strtok(NULL,"#");
		char *value=strtok(NULL,"#");
		value[strlen(value)-1]='\0';

		sprintf(stuArr[tag-1].name,"Student%d",tag);
		//printf("%d-%s-%s-%s\n",tag,key,value,stuArr[tag-1].name);
		if(strcmp(key,"GPA")==0){
			stuArr[tag-1].stugpa=atof(value);
		}else if(strcmp(key,"Interest1")==0){
			sprintf(stuArr[tag-1].inter1,"%s",value);
		}else if(strcmp(key,"Interest2")==0){
			sprintf(stuArr[tag-1].inter2,"%s",value);
		}else stuArr[tag-1].isValid=atoi(value);
	}
}

//test program and student information can be store correctly.
void testProgram(){
	int i;
	for(i=0;i<6;i++){
		printf("%s-%s-%.2f\n",progArr[i].dept,progArr[i].prog,progArr[i].gpa);
	}
	for(i=0;i<5;i++){
		printf("%s-%s-%s-%.2f\n",stuArr[i].name,stuArr[i].inter1,stuArr[i].inter2,stuArr[i].stugpa);
	}
}

//renew the students information for the struct studentInfo
void renewStuInfo(int i, int j){
	sprintf(stuArr[i].studept,"department%s",progArr[j].dept);	//renew student's department
	sprintf(stuArr[i].stuprog,"%s",progArr[j].prog);			//renew student's program
	sprintf(stuArr[i].studret,"Accept#%s#department%s",progArr[j].prog,progArr[j].dept);	//renew student's ret info
	stuArr[i].progid=j;							//program id from 0 to 5
	stuArr[i].status=1;							//student get admit
}

//renew the programs information for the struct programInfo
void renewProgInfo(int i, int j){
	progArr[j].stuaccept[progArr[j].stunum]=i;
	progArr[j].stunum++;
}

//deal with the application, store them in the data structures
void dealApplication(){
	int i,j;
	for(i=0;i<5;i++){ //traverse all students
		sprintf(stuArr[i].studret,"Reject");
		stuArr[i].status=0;
		stuArr[i].progid=-1;
		for(j=0;j<6;j++){ //traverse all programs.
			if(strcmp(stuArr[i].inter1,progArr[j].prog)==0){ //if met the interest1
				if(stuArr[i].stugpa>=progArr[j].gpa){ // if get the requirement, get it. renew the stures and deptres, then deal next student
					renewStuInfo(i,j);
					break;
				}
			}else if(strcmp(stuArr[i].inter2,progArr[j].prog)==0){ // if met the interest2
				if(stuArr[i].stugpa>=progArr[j].gpa){ //if get the requirement, temporary get it till end.
					renewStuInfo(i,j);
				}
			}
		}
		if(stuArr[i].progid>-1){
			renewProgInfo(i,stuArr[i].progid);
		}
	}
}

//test return value
void testRetVal(){
	int i;
	printf("Student Result:\n");
	for(i=0;i<STUSIZE;i++){
		printf("%d:%s\n",i,stuArr[i].studret);
	}

	int j;
	for(i=0;i<PROGSIZE;i++){
		printf("this is department:%s  program:%s\n",progArr[i].dept,progArr[i].prog);
		for(j=0;j<progArr[i].stunum;j++){
			printf("%d  ",progArr[i].stuaccept[j]);
		}
		printf("\n");
	}
}

//after deal dealtest the structure can store the information correctly.
void teststruct(){
	int i,j;

	for(i=0;i<PROGSIZE;i++){
		printf("here is program:%d\n",i);
		printf("gpa=%.2f,prog=%s,dept=%s,stunum=%d\n",progArr[i].gpa,progArr[i].prog,progArr[i].dept,progArr[i].stunum);
		printf("here is program %d's accept students:\n", i);
		for(j=0;j<progArr[i].stunum;j++){
			printf("%d\n",progArr[i].stuaccept[j]);
		}
		printf("------------------\n\n");
	}

	for(i=0;i<STUSIZE;i++){
		printf("here is student:%d\n",i);
		printf("name=%s,gap=%.2f,Inter1=%s,inter2=%s,\ndept=%s,prog=%s,pid=%d,status=%d\n\n",stuArr[i].name,stuArr[i].stugpa,stuArr[i].inter1,stuArr[i].inter2,stuArr[i].studept,stuArr[i].stuprog,stuArr[i].progid,stuArr[i].status);
		printf("here is what return to student %d:\n %s\n\n",i,stuArr[i].studret );
		printf("------------------\n\n");
	}
}

//this function print ip address and TCP port number directly
/*void printTcpPortIP(){  //this function is learned from "Beej's Guide to C Programming and Network Programming" in page 72
  int i;
  struct hostent *he;
  struct in_addr **addr_list;
  if ((he = gethostbyname(HOSTNAME)) == NULL) {
    herror("gethostbyname");
  }
  addr_list = (struct in_addr **)he->h_addr_list;
  for(i = 0; addr_list[i] != NULL; i++) {
    printf("The admission office has TCP port %d and IP address %s\n",atoi(ADM_PORT),inet_ntoa(*addr_list[i]));
  }
}*/

//get my IP address, change HOSTNAME to get another IP, used in udp_send.c
char* getIP(){
	struct hostent *he;
	struct in_addr **addr_list;
	if((he=gethostbyname(HOSTNAME))==NULL){
		herror("Admission Office: gethostbyname.");
	}
	addr_list = (struct in_addr **)he->h_addr_list;
	if(addr_list[0]!=NULL){
		sprintf(ip_addr,"%s",inet_ntoa(*addr_list[0]));
	}else{
		fprintf(stderr,"Admission Office: fail to get IP address\n");
	}
	return ip_addr;
}

void printTcpPortIP(){
	printf("The admission office has TCP port %d and IP address %s\n",atoi(ADM_PORT),getIP());
}

int main(int argc, char* argv[]) {
	/*here is Phase 1*/
	recvProcess();		//receive the information from departments and students, then write down in "programInfo.txt" and "studentInfo.txt" respectively.

	/*here is Phase 2*/
	readStuFile();		//read the student information from the "studentInfo.txt"

	//testProgram();	//before deal test program and student information can be store correctly.
	sleep(2);
	dealApplication();	//deal with the application and program available, then decide the result
	//testRetVal();		//test the program accepts which students
	//teststruct();		//after deal dealtest the structure can store the information correctly.
	sleep(2);
	sendResult();		//send back result in UDP to departments and students.
	printf("End of Phase 2 for the admission office\n");

	return 1;
}
