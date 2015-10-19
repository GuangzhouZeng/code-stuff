/*
 * Admission.h
 *
 * Description: This is header file
 *  Created on: Jul 30, 2015
 *      Author: guangzhz
 */

#ifndef ADMISSION_H_
#define ADMISSION_H_

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



#define ADM_PORT	"3751" 		//my id 9143776451, 3300+451
#define PORTA		"21651"		//departmentA	21200+451=21651
#define PORTB		"21751"		//departmentB	21300+451=21751
#define PORT1		"21851"		//21400+451
#define PORT2		"21951"		//21500+451
#define PORT3		"22051"		//21600+451
#define PORT4		"22151"		//21700+451
#define PORT5		"22251"		//21800+451

//#define HOSTNAME	"nunki.usc.edu"			//"guangzhz-VirtualBox"
#define HOSTNAME	"guangzhz-VirtualBox"
#define FILEPROG	"programInfo.txt"
#define FILESTUD	"studentInfo.txt"

typedef struct programInfo{
	float	gpa;					//required gpa				=recv=
	char	prog[NAMESIZE];			//the program's name		=recv=
	char	dept[NAMESIZE];			//the programs's department	=recv=
	int		stunum;					//student number
	int		stuaccept[STUSIZE];		//this array store all accepted students by his id.
	//char progres[DATASIZE];
} Program;

typedef struct studentInfo{
	char	name[NAMESIZE];			//student's name		=recv=
	float	stugpa;					//student's gpa			=recv=
	char	inter1[NAMESIZE];		//student's interest1	=recv=
	char	inter2[NAMESIZE];		//student's interest2	=recv=
	char	studept[NAMESIZE];		//student's department if accepted
	char	stuprog[NAMESIZE];		//student's program if accepted
	int		progid;					//student's program id; -1 means not accept
	int		status;					//accept=1 or reject=0
	int		isValid;				//the program info is valid or invalid. 2,1=>valid; 0=>invalid
	char	studret[DATASIZE];		//student's final decision.
} Student;

extern Program progArr[PROGSIZE];		//program id from 0 to 5  randomly
extern Student stuArr[STUSIZE];			//student id from 0 to 4
extern char IPaddr[INET6_ADDRSTRLEN];	//store ip address

extern int recvProcess();
extern int sendResult();
extern void printTcpPortIP();
extern char* getIP();

#endif /* ADMISSION_H_ */

