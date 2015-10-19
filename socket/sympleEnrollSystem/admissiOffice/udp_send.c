/*
 * udp_send.c
 *
 * Description: this file is used to send result in UDP back to departments and students.
 * Reused Code: In this file, I used some pieces of code from "Beej's Guide to C Programming and Network Programming" from page 27 to page 34
 *  Created on: Jul 30, 2015
 *      Author: guangzhz
 */


#include "Admission.h"


/*
flag=1=>DepA
flag=2=>DepB
flag=3=>stu1
flag=4=>stu2
flag=5=>stu3
flag=6=>stu4
flag=7=>stu5
*/

//getaddrinfo with right port number
struct addrinfo* doGetAddrInfo_udp(int flag){
	struct addrinfo hint, *serinfo;
	int rv;
	char port[NAMESIZE];

	switch(flag){
	case 1:sprintf(port,"%s",PORTA);break;
	case 2:sprintf(port,"%s",PORTB);break;
	case 3:sprintf(port,"%s",PORT1);break;
	case 4:sprintf(port,"%s",PORT2);break;
	case 5:sprintf(port,"%s",PORT3);break;
	case 6:sprintf(port,"%s",PORT4);break;
	case 7:sprintf(port,"%s",PORT5);break;
	}

	memset(&hint,0,sizeof(hint));
	hint.ai_family=AF_UNSPEC;
	hint.ai_socktype=SOCK_DGRAM;

	if((rv=getaddrinfo(HOSTNAME,port,&hint,&serinfo))!=0){
		fprintf(stderr,"AdminOffice:%s\n",gai_strerror(rv));
		exit(1);
	}
	return serinfo;
}

int doSocketPre_udp(struct addrinfo* serinfo,struct addrinfo** q, int flag){
	int sockfd;
	struct addrinfo* p;
	for(p=serinfo;p!=NULL;p=p->ai_next){
		if((sockfd=socket(p->ai_family,p->ai_socktype,p->ai_protocol))==-1){
			perror("AdminOffice: socket");
			continue;
		}

		break;
	}
	if(p==NULL){
		fprintf(stderr,"fail to get socket\n");
		exit(1);
	}
	*q=p;

	//struct sockaddr_in *temp=(struct sockaddr_in*)p->ai_addr;
	//ntohs(la.sin_port),inet_ntoa(la.sin_addr)
	//freeaddrinfo(serinfo);
	//printf("the address is: %d %s\n",ntohs(temp->sin_port),inet_ntoa(temp->sin_addr));
	return sockfd;
}

//This function print UDP port number and IP address
void printUdpPortIP(int sockfd){
	struct sockaddr_in la; //local address
	int addrlen = sizeof(la);
	if(getsockname(sockfd,(struct sockaddr*)&la,(socklen_t*)&addrlen)==-1){
		perror("Admission Office: getsockname");
		exit(1);
	}
	printf("The admission office has UDP port %d and IP address %s for Phase 2\n",ntohs(la.sin_port),getIP());
}

//Sutdent5#4.0#A3
void sendToDept(int sockfd, struct addrinfo* p,int flag, int i, int j){
	char buf[DATASIZE];
	struct studentInfo stu=stuArr[progArr[i].stuaccept[j]];
	sprintf(buf,"%s#%.2f#%s",stu.name,stu.stugpa,stu.stuprog);
	sendto(sockfd,buf,strlen(buf),0,p->ai_addr,p->ai_addrlen);
	//printf("flag=%d, what I have send: %s, accept[i]=%d\n",flag, buf,progArr[i].stuaccept[i]);
	//printf("here print: send Dept%c what:%s\n",flag+'A'-1,buf);

}


//Accept#B2#departmentB
void sendToStu(int sockfd,struct addrinfo* p,int i){
	char buf[DATASIZE];
	sprintf(buf,"%s",stuArr[i].studret);
	buf[DATASIZE-1]='\0';
	if(stuArr[i].isValid){
		sendto(sockfd,buf,DATASIZE,0,p->ai_addr,p->ai_addrlen);
		printUdpPortIP(sockfd);
		printf("The admission office has send the application result to <Student%d>\n",i+1);
	}
	//printf("here print: send Student%d what: %s\n",i+1,buf);
}

//send the information back to departments and students
void doSend_udp(int sockfd, struct addrinfo* p,int flag){
	char* endPoint="done";
	if(flag<=2){		//send department return information: Sutdent5#4.0#A3
		int i=0,j=0,time=1;
		//for(i=PROGNUM*(flag-1);i<PROGNUM*flag;i++){   //flag=1=>0 to 2, flag=2=>3 to 5
		for(i=0;i<6;i++){
			if((flag==1&&!strcmp(progArr[i].dept,"A"))||(flag==2&&!strcmp(progArr[i].dept,"B"))){ //flag=1->send to deptA; flag=2->send to deptB
				for(j=0;j<progArr[i].stunum;j++){
					sendToDept(sockfd,p,flag,i,j);
					if(time){printUdpPortIP(sockfd);time--;} //HERE I can modify the code to show only one time
					printf("The admission office has send one admitted student to <Department%c>\n",flag+'A'-1);
				}
			}
		}
	}else{				//send student return information: Accept#B2#departmentB
		int i=flag-3;
		sendToStu(sockfd,p,i);
	}
	//struct sockaddr_in *temp=(struct sockaddr_in*)p->ai_addr;
	//printf("the address is: %d %s\n",ntohs(temp->sin_port),inet_ntoa(temp->sin_addr));

	if(sendto(sockfd,endPoint,strlen(endPoint),0,p->ai_addr,p->ai_addrlen)==-1){
		perror("AdminOffice: sendto");
		exit(1);
	}
}

//send back result in UDP to departments and students.
int sendResult(){
	int sockfd, flag;
	struct addrinfo *serinfo, *p;

	for(flag=1;flag<=7;flag++){
		serinfo = doGetAddrInfo_udp(flag);
		sockfd = doSocketPre_udp(serinfo,&p,flag);
		doSend_udp(sockfd, p, flag);
		freeaddrinfo(serinfo);
		close(sockfd);
	}

	//while(wait(NULL)>1);


	return 0;
}
