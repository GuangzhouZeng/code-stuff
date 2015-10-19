/*
 * udp_recv.c
 *
 * Description: This file implement recvResult(), used to send results back to students.
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */



#include "Student.h"


/*
flag=1=>stu1
flag=2=>stu2
flag=3=>stu3
flag=4=>stu4
flag=5=>stu5
*/

struct addrinfo* doGetAddrInfo_udp(int flag, char* port){
	struct addrinfo hint,*serinfo;
	int rv;

	memset(&hint,0,sizeof(hint));
	hint.ai_family=AF_UNSPEC;
	hint.ai_flags=AI_PASSIVE;
	hint.ai_socktype=SOCK_DGRAM;

	if((rv=getaddrinfo(NULL,port,&hint,&serinfo))!=0){
		fprintf(stderr,"Student:%s",gai_strerror(rv));
		exit(1);
	}

	return serinfo;
}

int doSockPre_udp(struct addrinfo* serinfo, int flag){
	int sockfd;
	struct addrinfo* p;
	//struct timeval timeout;
	//timeout.tv_sec=60;
	//timeout.tv_usec=0;
	for (p = serinfo; p != NULL; p = p->ai_next) {
		if ((sockfd = socket(p->ai_family,p->ai_socktype,p->ai_protocol)) == -1) {
			perror("Student: socket");
			continue;
		}
		/*if(setsockopt(sockfd,SOL_SOCKET,SO_RCVTIMEO,&timeout,sizeof(timeout))==-1){
			perror("Student: setsockopt");
			continue;
		}*/
		if((bind(sockfd,p->ai_addr,p->ai_addrlen))==-1){
			close(sockfd);
			perror("Student: bind");
			continue;
		}
		break;
	}
	if(p==NULL){
		fprintf(stderr,"fail to connect\n");
		exit(1);
	}
	freeaddrinfo(serinfo);
	return sockfd;
}

void doRecv_udp(int sockfd,int flag){
	char buf[DATASIZE];
	struct sockaddr_storage comeaddr;
	int bytenum;
	socklen_t addrlen=sizeof(comeaddr);
	while(strcmp(buf,"done")!=0){
		if((bytenum=recvfrom(sockfd,buf,DATASIZE-1,0,(struct sockaddr*)&comeaddr,(socklen_t*)&addrlen))==-1){
			perror("Student: recvfrom");
			exit(1);
		}
		buf[bytenum] = '\0';
		if(strcmp(buf,"done") != 0) {
			printf("<Student%d> has received the application result: %s\n",flag,buf);
			//printf("Student%d: get result: \"%s\"\n", flag,buf);
		}
	}
}

void recvResult(int flag){
	struct addrinfo *serinfo;
	int sockfd;

	char port[NAMESIZE];
	switch(flag){
	case 1:sprintf(port,"%s",PORT1);break;
	case 2:sprintf(port,"%s",PORT2);break;
	case 3:sprintf(port,"%s",PORT3);break;
	case 4:sprintf(port,"%s",PORT4);break;
	case 5:sprintf(port,"%s",PORT5);break;
	}

	printf("<Student%d> has UDP port %s and IP address %s for Phase 2\n",flag,port,IPaddr);

	serinfo = doGetAddrInfo_udp(flag,port);
	sockfd = doSockPre_udp(serinfo, flag);
	doRecv_udp(sockfd, flag);
	//sleep(20);
	close(sockfd);
	printf("End of Phase 2 for <Student%d>\n",flag);

}
