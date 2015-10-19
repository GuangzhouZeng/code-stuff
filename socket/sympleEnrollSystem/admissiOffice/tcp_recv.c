/*
 * tcp_recv.c
 *
 * Description: this file is used to receive data from students and departments, then write down in "programInfo.txt" and "studentInfo.txt" respectively.
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 30, 2015
 *      Author: guangzhz
 */
#include "Admission.h"

int recvPacStu[STUSIZE]={0};	//detect how many packets have been received from a student
int recvPacDep[DEPTSIZE]={0};	//detect how many packets have been received from a department
int validProg[STUSIZE];			//how many valid program does student i have. if 0, should reply 0 and stop.

void *get_in_addr(struct sockaddr *sa){
	if (sa->sa_family == AF_INET) {
		return &(((struct sockaddr_in*)sa)->sin_addr);
	}
	return &(((struct sockaddr_in6*)sa)->sin6_addr);
}

//getaddrinfo
struct addrinfo* doGetAddrInfo() {
	int rv;
	struct addrinfo hint, *serinfo;
	memset(&hint, 0, sizeof(hint));
	hint.ai_family = AF_UNSPEC;
	hint.ai_socktype = SOCK_STREAM;
	hint.ai_flags = AI_PASSIVE;

	if ((rv = getaddrinfo(NULL, ADM_PORT, &hint, &serinfo)) != 0) {
		fprintf(stderr, "getaddrinfo:%s\n", gai_strerror(rv));
		exit(1);
	}
	return serinfo;
}

//sock(), setsockopt(), bind()
int doSocketPre(struct addrinfo *serinfo) {
	int yes = 1;  //on nunki: char yes='1';
	int sockfd;
	struct addrinfo *p;


	for (p = serinfo; p != NULL; p = p->ai_next) {
		if ((sockfd = socket(p->ai_family, p->ai_socktype, p->ai_protocol))
				== -1) {
			perror("AdmiOffice: socket");
			continue;
		}

		if (setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &yes, sizeof(int))
				== -1) {
			perror("setsockopt");
			exit(1);
		}

		if ((bind(sockfd, p->ai_addr, p->ai_addrlen)) == -1) {
			perror("AdmiOffice: bind");
			continue;
		}
		break;
	}

	if (p == NULL) {
		fprintf(stderr, "AdmiOffice: fail to connect\n");
		exit(1);
	}

	//char la[INET6_ADDRSTRLEN]; //local address
	//inet_ntop(p->ai_family, get_in_addr(p->ai_addr), la, sizeof(la));
	//printf("Department: connect to %s\n", la);
	//printf("The admission office has TCP port %d and IP address %s\n",atoi(ADM_PORT),la);  //something wrong here, I cannot get the right ip address

	freeaddrinfo(serinfo);
	return sockfd;
}

//waiting for new connection
void doListen(int sockfd) {
	if (listen(sockfd, QUENUM) == -1) {
		perror("listen");
		exit(1);
	}
	//printf("AdmiOffice: Waiting for connection!\n");
}

//write down into file
void doWrite(char* buf,char* filename){
	FILE *fp=fopen(filename,"a");
	fprintf(fp,"%s",buf);
	fclose(fp);
}

//return 1 if exist, return 0 if not exist
int checkProgExist(char* value){
	int i=0;
	for(;i<PROGSIZE;i++){
		if(!strcmp(value,progArr[i].prog)){ //if equal
			return 1; // the program exist;
		}
	}
	return 0; //no such program
}

//check whether the student's application is valid
void checkValidProgram(char* buf){
	char str[DATASIZE];
	strncpy(str,buf,DATASIZE);
	char* temp = strtok(str,"#");
	int tag=atoi(temp);
	char *key=strtok(NULL,"#");
	char *value=strtok(NULL,"#");
	value[strlen(value)-1]='\0';

	if(strcmp(key,"Interest1")==0){
		if(!checkProgExist(value)){ //program does not exist
			validProg[tag-1]--;
		}
	}else if(strcmp(key,"Interest2")==0){
		if(!checkProgExist(value)){
			validProg[tag-1]--;
		}
	}
}

//write down the department information into file
void doDepartmentRecord(char* buf){
	char* filename;
	filename=FILEPROG;
	recvPacDep[buf[0]-'A']++;
	doWrite(buf,filename);
	if(recvPacDep[buf[0]-'A']==3){
		printf("Received the program list from <Department%c>\n",buf[0]);
	}
}

//reply to students in TCP
void doReply(int id, int sockfd){
	if(validProg[id]){ //validProg[id]>0; this is a valid application
		char* str="1";
		if (send(sockfd, str, sizeof(str), 0) == -1){
			perror("send");
			exit(1);
		}
		//printf("Admission Office:send '%s'!\n",str);
	}else{	//this is an invalid application
		char* str="0";
		if (send(sockfd, str, sizeof(str), 0) == -1){
			perror("send");
			exit(1);
		}
		//printf("Admission Office:send '%s'!\n",str);
	}
}

//write down the department information into file, then reply to them whether valid
void doStudentRecord(char* buf, int newfd){
	char* filename=FILESTUD;
	char str[DATASIZE];
	str[DATASIZE-1]='\0';
	recvPacStu[buf[0]-'1']++;
	doWrite(buf,filename);
	checkValidProgram(buf);
	if(recvPacStu[buf[0]-'1']==3){
		printf("Admission office receive the application from <Student%c>\n",buf[0]);
		//only get all infromation from a student, then reply valid or invalid
		doReply(buf[0]-'1', newfd);// if validProg[i]==0 reply invalid, else reply valid
		sprintf(str,"%c#isValid#%d\n",buf[0],validProg[buf[0]-'1']);//1#isValid#1
		doWrite(str,filename);
	}
}

//do recv(), then write down into file
void doReceive(int newfd){
	int numbytes;
	char buf[DATASIZE];
	int i;
	//int isReply=0;	//only reply to students

	for(i=0;i<PROGNUM;i++){
		numbytes = recv(newfd, buf, DATASIZE - 1, 0);
		if (numbytes == -1) {
			perror("recv");
			exit(1);
		}

		if(numbytes!=0) {
			buf[numbytes] = '\0';
			//printf("AdmiOffice received:\n%s\n", buf);
			if(buf[0]<='5'&&buf[0]>='1'){
				doStudentRecord(buf,newfd);
			}else{
				doDepartmentRecord(buf);
			}
		}

	}
}

//accept(), if get a new connection, fork a child to recv
int doAccept(int sockfd) {
	int newfd;
	struct sockaddr_storage comeaddr;
	char s[INET6_ADDRSTRLEN];
	socklen_t comeaddr_len = sizeof(comeaddr);

	newfd = accept(sockfd, (struct sockaddr *) &comeaddr, &comeaddr_len);
	if (newfd == -1) {
		perror("accpet");
		return 0;
	}

	//here is another way to get IP address and PORT number
	/*struct sockaddr_in la; //local address
	int addrlen = sizeof(la);
	if(getsockname(newfd,(struct sockaddr*)&la,(socklen_t*)&addrlen)==-1){
		perror("Admission Office: getsockname");
		exit(1);
	}
	printf("The admission office has TCP port %d and IP address %s\n",ntohs(la.sin_port),inet_ntoa(la.sin_addr));*/
	//here is another way to get IP address and PORT number

	inet_ntop(comeaddr.ss_family, get_in_addr((struct sockaddr*)&comeaddr), s, sizeof(s));
	//printf("AdmiOffice: connect to %s\n", s);

	if (fork() == 0) {
		close(sockfd);
		doReceive(newfd);
		close(newfd);
		exit(0);
	}
	close(newfd);
	return 1;
}

/*format
A#A1#3.6
A#A2#3.5
A#A3#3.7
*/
void readProgFile(){
	char buf[DATASIZE], *temp;
	FILE* fp=fopen(FILEPROG,"r");
	if(fp==NULL){
		fprintf(stderr,"fail to open programInfo.txt\n");
		exit(1);
	}
	int i=0;
	while(fgets(buf,sizeof(buf),fp)!=NULL){
		int j=0;
		temp=strtok(buf,"#");
		while(temp!=NULL){
			switch(j){
			case 0: sprintf(progArr[i].dept,"%s",temp); break;
			case 1: sprintf(progArr[i].prog,"%s",temp); break;
			case 2: progArr[i].gpa=atof(temp);break;
			}
			temp=strtok(NULL,"#");
			j++;
		}
		i++;
	}
	fclose(fp);
}

//Do TCP receive process
void doTcpReceive(int size){
	int sockfd;
	printTcpPortIP();
	struct addrinfo *serinfo;
	serinfo = doGetAddrInfo();
	sockfd = doSocketPre(serinfo);
	doListen(sockfd);

	int suc=0;
	while(suc<size){
		suc+=doAccept(sockfd);
	}
	close(sockfd);
	while(wait(NULL)>1);
}

//TCP server: receive information from Dept and Stud
int recvProcess() {

	int i;
	for(i=0;i<STUSIZE;i++){
		validProg[i]=2;
	}

	//here is phase 1, receive department information
	printf("Upon startup of Phase 1: ");
	doTcpReceive(DEPTSIZE);
	//here read department's information into structure
	readProgFile();
	printf("End of Phase 1 for the admission office\n");

	//here is phase 2, receive student's information
	printf("Upon startup of Phase 2: ");
	doTcpReceive(STUSIZE);

	return 0;
}
