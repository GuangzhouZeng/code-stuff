/*
 * udp_recv.c
 *
 * Description: This file implement recvResult(), used to send results back to departments.
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */

#include "Department.h"



//char ip_addr[NAMESIZE];		//ip address
//flag=1=>A
//falg=2=>B


struct addrinfo* doGetAddrInfo_udp(int flag){
	struct addrinfo hint,*serinfo;
	int rv;
	char port[NAMESIZE];
	memset(&hint,0,sizeof(hint));
	hint.ai_family=AF_UNSPEC;
	hint.ai_socktype=SOCK_DGRAM;
	hint.ai_flags=AI_PASSIVE;

	sprintf(port,"%s",flag==1?PORTA:PORTB);
	if((rv=getaddrinfo(NULL,port,&hint,&serinfo))!=0){
		fprintf(stderr,"Department: geraddrinfo %s",gai_strerror(rv));
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
	for(p=serinfo;p!=NULL;p=p->ai_next){
		if((sockfd=socket(p->ai_family,p->ai_socktype,p->ai_protocol))==-1){
			perror("Department: socket");
			continue;
		}

		/*if(setsockopt(sockfd,SOL_SOCKET,SO_RCVTIMEO,&timeout,sizeof(timeout))==-1){
			perror("Department: setsockopt");
			continue;
		}*/
		if(bind(sockfd,p->ai_addr,p->ai_addrlen)!=0){
			close(sockfd);
			perror("Department: bind");
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
	int bytenum;
	struct sockaddr_storage comeaddr;
	socklen_t addrlen = sizeof(comeaddr);
	//char s[INET6_ADDRSTRLEN];

	while (strcmp(buf,"done") != 0){
		memset(buf,0,sizeof(buf));
		if ((bytenum = recvfrom(sockfd, buf, DATASIZE - 1, 0,
				(struct sockaddr*) &comeaddr, (socklen_t*) &addrlen)) == -1) {
			perror("Department: recvfrom");
			exit(1);
		}
		/*printf("listener: got packet from %s\n",
				inet_ntop(comeaddr.ss_family,
						get_in_addr((struct sockaddr *) &comeaddr), s,
						sizeof s));
		printf("listener: packet is %d bytes long\n", bytenum);*/
		buf[bytenum] = '\0';
		if(strcmp(buf,"done") != 0){
			//printf("Department: get result \"%s\"\n", buf);
			char temp[DATASIZE];
			sprintf(temp,"%s",buf);
			char* s=strtok(temp,"#");
			printf("<%s> has been admitted to <Department%c>: %s\n",s,dept(flag),buf);
		}
	}
}

void recvResult(int flag){
	struct addrinfo *serinfo;
	int sockfd;

	printf("<Department%c> has UDP port %s and IP address %s for Phase 2\n",dept(flag),flag==1?PORTA:PORTB,IPaddr);

	serinfo = doGetAddrInfo_udp(flag);
	sockfd = doSockPre_udp(serinfo, flag);
	doRecv_udp(sockfd, flag);
	//sleep(20);
	close(sockfd);
	printf("End of Phase 2 for <Department%c>\n",dept(flag));
}
