Department: Department.o tcp_send.o udp_recv.o
	gcc -o Department -g -Wall Department.o tcp_send.o udp_recv.o 

Department.o: Department.c Department.h
	gcc -c -g -Wall Department.c -lsocket -lnsl -lresolv

tcp_send.o: tcp_send.c Department.h
	gcc -c -g -Wall tcp_send.c

udp_recv.o: udp_recv.c Department.h
	gcc -c -g -Wall udp_recv.c

clean:
	rm -f *.o *~ Department
