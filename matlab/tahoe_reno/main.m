%unit of time: ms
%¨C There is a packet loss (triple duplicate ACKs) on link A at time t1= 900ms.
%¨C There is a packet loss (triple duplicate ACKs) on link B at time t2= 650ms.
%¨C There is a packet loss (time out) on link B at time t3= 1300ms.
%
%event time
t1=900;
t2=650;
t3=1300;
%event 
e1=2;
e2=2;
e3=3;
%round trip time
rtt1=100;
rtt2=50;
%initialize
threshold=32;
window=1;
time=1500;

%tahoe
window_tahoe=linspace(0,0,time/rtt1);
tag1=1;
for t=0:rtt1:time
    window_tahoe(tag1)=window;
    tag1=tag1+1;
    if(t==t1)
        [window,threshold]=tahoe(window,threshold,e1);
    else
        [window,threshold]=tahoe(window,threshold,1);
    end
    
end


%initialize
 threshold=32;
 window=1;
 time=1500;

%tahoe
 window_reno=linspace(0,0,time/rtt2);
 tag2=1;
 for t=0:rtt2:time
     window_reno(tag2)=window;
     tag2=tag2+1;
     if(t==t2)
         [window,threshold]=reno(window,threshold,e2);
     elseif(t==t3)
         [window,threshold]=reno(window,threshold,e3);
     else
         [window,threshold]=reno(window,threshold,1);
     end
 end


%plot
hold on;
t1=0:rtt1:time;
plot(t1,window_tahoe,':');



t2=0:rtt2:time;
plot(t2,window_reno);
xlabel('time: ms');
ylabel('window size');
title('tahoe VS reno');
legend('tahoe');
