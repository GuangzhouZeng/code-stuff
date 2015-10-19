/*
 * tcp_send.c
 *
 * Description: This file implement sendStuInfo(), used to send departments' information
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */

#include "Department.h"

char IPaddr[INET6_ADDRSTRLEN];

struct addrinfo* doGetAddrInfo() {
	struct addrinfo *serinfo;
	struct addrinfo hint;
	int rv;

	memset(&hint, 0, sizeof(hint));
	hint.ai_family = AF_UNSPEC;
	hint.ai_socktype = SOCK_STREAM;

	if ((rv = getaddrinfo(HOSTNAME, ADM_PORT, &hint, &serinfo)) != 0) {
		fprintf(stderr, "getaddrinfo:%s", gai_strerror(rv));
		exit(1);
	}
	return serinfo;
}

void* get_in_addr(struct sockaddr* sa){
	if(sa->sa_family==AF_INET){
		return &(((struct sockaddr_in*)sa)->sin_addr);
	}else{
		return &(((struct sockaddr_in6*)sa)->sin6_addr);
	}
}


int doSockPre(struct addrinfo* serinfo, int flag) {
	struct addrinfo *p;
	struct sockaddr_in la;  //local address;
	int addrlen=sizeof(la);
	int sockfd;

	for (p = serinfo; p != NULL; p = p->ai_next) {
		if ((sockfd = socket(p->ai_family, p->ai_socktype, p->ai_protocol))
				== -1) {
			perror("Department: socket");
			continue;
		}

		if (connect(sockfd, p->ai_addr, p->ai_addrlen) == -1) {
			close(sockfd);
			perror("Department: connect");
			continue;
		}
		if(getsockname(sockfd,(struct sockaddr*)&la,(socklen_t*)&addrlen)==-1){
			perror("Department: getsockname");
			continue;
		}
		sprintf(IPaddr,"%s",inet_ntoa(la.sin_addr));
		printf("<Department%c> has TCP port %d and IP address %s for Phase 1\n",dept(flag),ntohs(la.sin_port),inet_ntoa(la.sin_addr));
		printf("<Department%c> is now connected to the admission office\n",dept(flag));

		break;
	}

	if (p == NULL) {
		fprintf(stderr, "fail to connect\n");
		exit(1);
	}

/*	char s[INET6_ADDRSTRLEN];
	inet_ntop(p->ai_family, get_in_addr(p->ai_addr), s, sizeof(s));
	printf("Department: connect to %s\n", s);*/


	freeaddrinfo(serinfo);
	return sockfd;
}

/*
A1#3.6
A2#3.5
A3#3.7
*/

void doSend(int sockfd, int flag){
	char buf[DATASIZE];
	char str[DATASIZE-1];
	memset(buf,sizeof(buf),0);
	memset(str,sizeof(str),0);
	char* filename=flag==1?"departmentA.txt":"departmentB.txt";
	char* dept=flag==1?"A":"B";
	FILE *fp=fopen(filename,"r");
	if(fp==NULL){
		fprintf(stderr,"Department%s: fail to open file\n",dept);
		if(strcmp(dept,"B")==0) while(wait(NULL)>-1);
		close(sockfd);
		exit(1);
	}
	while(fgets(buf,sizeof(buf),fp)!=NULL){
		char temp[DATASIZE];			//these four lines are used to get the prog name, so that they can be printed out
		char* prog;
		sprintf(temp,"%s",buf);
		prog=strtok(temp,"#");

		sprintf(str,"%s#%s",dept,buf);	//here to send one line
		//str[DATASIZE]='\0';
		if(send(sockfd,str,sizeof(str),0)==-1){
			perror("Department: send");
			exit(1);
		}
		printf("<Department%c> has sent <program:%s> to the admission office\n",dept(flag),prog);
		memset(buf,sizeof(buf),0);
		memset(str,sizeof(str),0);
	}

	printf("Updating the admission office is done for <Department%c>\n",dept(flag));
	fclose(fp);
}

void sendProgram(int flag) {		//flag=1=>A flag=2=>B
	struct addrinfo *serinfo;
	int sockfd;

	serinfo = doGetAddrInfo();
	sockfd = doSockPre(serinfo, flag);
	doSend(sockfd, flag);
	close(sockfd);
	printf("End of Phase 1 for <Department%c>\n",dept(flag));
}
