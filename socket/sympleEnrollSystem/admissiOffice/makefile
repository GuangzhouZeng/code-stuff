Admission: Admission.o tcp_recv.o udp_send.o
	gcc -o Admission -g Admission.o tcp_recv.o udp_send.o 

Admission.o: Admission.c Admission.h
	gcc -g -c -Wall Admission.c -lsocket -lnsl -lresolv

tcp_recv.o: tcp_recv.c Admission.h
	gcc -g -c -Wall tcp_recv.c

udp_send.o: udp_send.c Admission.h
	gcc -g -c -Wall udp_send.c

clean:
	rm -f *~ *.o Admission *.txt 
