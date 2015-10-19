Student: Student.o tcp_send.o udp_recv.o
	gcc -o Student -g -Wall Student.o tcp_send.o udp_recv.o 

Student.o: Student.c Student.h
	gcc -g -c -Wall Student.c -lsocket -lnsl -lresolv

tcp_send.o: tcp_send.c Student.h
	gcc -g -c -Wall tcp_send.c

udp_recv.o: udp_recv.c Student.h
	gcc -g -c -Wall udp_recv.c

clean:
	rm -f *.o *~ Student
