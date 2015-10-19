/*
 * tcp_send.c
 *
 * Description: This file implement sendStuInfo(), used to send students' information
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */


#include "Student.h"

char IPaddr[INET6_ADDRSTRLEN];

void* get_in_addr(struct sockaddr* sa){
	if(sa->sa_family==AF_INET){
		return &(((struct sockaddr_in*)sa)->sin_addr);
	}else{
		return &(((struct sockaddr_in6*)sa)->sin6_addr);
	}
}

struct addrinfo* doGetAddrInfo(){
	struct addrinfo hint, *serinfo;
	int rv;

	memset(&hint, 0, sizeof(hint));
	hint.ai_family=AF_UNSPEC;
	hint.ai_socktype=SOCK_STREAM;

	if((rv=getaddrinfo(HOSTNAME,ADM_PORT,&hint,&serinfo))!=0){
		fprintf(stderr,"getaddrinfo:%s",gai_strerror(rv));
		exit(1);
	}
	return serinfo;
}

int doSockPre(struct addrinfo *serinfo, int flag){
	struct addrinfo *q;
	struct sockaddr_in la; //local address
	int addrlen = sizeof(la);
	int sockfd;

	for(q=serinfo;q!=NULL;q=q->ai_next){
		if((sockfd=socket(q->ai_family,q->ai_socktype,q->ai_protocol))==-1){
			perror("Student: socket");
			continue;
		}

		if(connect(sockfd,q->ai_addr,q->ai_addrlen)==-1){
			perror("Student: connect");
			close(sockfd);
			continue;
		}
		if(getsockname(sockfd,(struct sockaddr*)&la,(socklen_t*)&addrlen)==-1){
			perror("Student: getsockname");
			continue;
		}
		printf("<Student%d> has TCP port %d and IP address %s\n",flag,ntohs(la.sin_port),inet_ntoa(la.sin_addr));
		sprintf(IPaddr,"%s",inet_ntoa(la.sin_addr));
		break;
	}
	if(q==NULL){
		fprintf(stderr,"fail to connect\n");
		exit(1);
	}

/*	char s[INET6_ADDRSTRLEN];
	inet_ntop(q->ai_family, get_in_addr(q->ai_addr), s, sizeof(s));
	printf("Student: connect to %s\n", s);*/

	freeaddrinfo(serinfo);
	return sockfd;
}


/*format
GPA#3.8
Interest1#A1
Interest2#B1
 */
//not only send, but also receive back reply
void doSend(int sockfd, int flag){
	char filename[DATASIZE];
	char buf[DATASIZE];
	char str[DATASIZE-1];
	char rec_str[DATASIZE];
	memset(buf,sizeof(buf),0);
	memset(str,sizeof(str),0);
	sprintf(filename,"student%d.txt",flag);
	FILE *fp=fopen(filename,"r");
	if(fp==NULL){
		fprintf(stderr,"Student%d: fail to open file\n",flag);
		close(sockfd);
		exit(1);
	}
	while(fgets(buf,sizeof(buf),fp)!=NULL){
		sprintf(str,"%d#%s",flag,buf);
		//str[DATASIZE]='\0';
		if(send(sockfd,str,sizeof(str),0)==-1){
			perror("Student: send");
			exit(1);
		}
		//memset(buf,sizeof(buf),0);
		//memset(str,sizeof(str),0);
	}
	printf("Completed sending application for <Student%d>.\n",flag);

	//then receive the return value to check whether it valid.
	int numbytes = recv(sockfd, rec_str, DATASIZE, 0);
	if (numbytes == -1) {
		perror("Student: recv");
		exit(1);
	}
	if(numbytes){
		//rec_str[numbytes]='\0';
		printf("<Student%d> has received the reply from the admission office\n",flag);
		//printf("what I have received: %s\n",buf);
		if(!atoi(rec_str)){
			printf("End of Phase 2 for <Student%d>: invalid programs\n",flag);
			exit(0);
		}
	}
	fclose(fp);
}

//send students information
void sendStuInfo(int flag){
	int sockfd;
	struct addrinfo *serinfo;

	serinfo=doGetAddrInfo();

	sockfd = doSockPre(serinfo,flag);
	doSend(sockfd,flag);
	close(sockfd);
}
