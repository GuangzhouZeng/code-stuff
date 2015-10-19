/*
 * Student.h
 *
 * Description: this is header file of the .c files
 *  Created on: Jul 31, 2015
 *      Author: guangzhz
 */

#ifndef STUDENT_H_
#define STUDENT_H_


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

#define QUENUM		10
#define DATASIZE	100		//information size
#define STUSIZE		5		//student size
#define PROGSIZE	6		//program size
#define DEPTSIZE	2		//department size
#define PROGNUM		3
#define NAMESIZE	20		//size of name


/*My USC ID is 9143776451*/
#define ADM_PORT	"3751" 		//3300+451
#define PORT1		"21851"		//21400+451
#define PORT2		"21951"		//21500+451
#define PORT3		"22051"		//21600+451
#define PORT4		"22151"		//21700+451
#define PORT5		"22251"		//21800+451

//#define HOSTNAME "nunki.usc.edu"	//"guangzhz-VirtualBox"
#define HOSTNAME	"guangzhz-VirtualBox"
#define ADDRLEN INET6_ADDRSTRLEN

extern void sendStuInfo(int flag);
extern void recvResult(int flag);

extern char IPaddr[INET6_ADDRSTRLEN];

#endif /* STUDENT_H_ */
