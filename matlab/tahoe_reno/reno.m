function [window,threshold]=reno(window,threshold,event)
%Reno: If three duplicate ACKs are received (i.e., four ACKs acknowledging
%the same packet, which are not piggybacked on data, and do not change the 
%receiver's advertised window), Reno will halve the congestion window (instead 
%of setting it to 1 MSS like Tahoe), set the slow start threshold equal to the 
%new congestion window, perform a fast retransmit, and enter a phase called 
%Fast Recovery. If an ACK times out, slow start is used as it is with Tahoe
%
%event=1: no packet loss
%event=2: 3 acks
%event=3: timeout
if event==1
    if window<threshold
        window=window*2;
    else
        window=window+1;
    end
elseif event==2
    threshold=window/2;
    window=threshold;
else
    threshold=threshold/2;
    window=1;
end



