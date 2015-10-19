/*
 * Department.h
 *
 * Description: this is the header file
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */

#ifndef DEPARTMENT_H_
#define DEPARTMENT_H_


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>
#include <netdb.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <sys/wait.h>

/*My USC ID: 9143776451 */
#define ADM_PORT	"3751" 		//3300+451
#define PORTA		"21651"		//departmentA	21200+451=21651
#define PORTB		"21751"		//departmentB	21300+451=21751

//#define HOSTNAME	"nunki.usc.edu"	//"guangzhz-VirtualBox"
#define HOSTNAME	"guangzhz-VirtualBox"
#define dept(x)		((x)+'A'-1)		//flag map to department number

#define DATASIZE	100			//information size
#define STUSIZE		5			//student size
#define PROGSIZE	6			//program size
#define DEPTSIZE	2			//department size
#define NAMESIZE	20			//size of name

extern void sendProgram(int flag);
extern void recvResult(int flag);
extern void *get_in_addr(struct sockaddr *sa);

extern char IPaddr[INET6_ADDRSTRLEN];	//ip address

#endif /* DEPARTMENT_H_ */
