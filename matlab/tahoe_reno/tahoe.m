function [window,threshold]=tahoe(window,threshold,event)
%Tahoe: Common Tahoe implementations detect congestion only by setting a 
%timer for receiving a related ACK. Tahoe sets the slow start threshold 
%to half of the current congestion window, reduces the congestion window 
%to 1 MSS, and resets to slow-start state.
%
%event=1: no packet loss
%event=2: 3 acks
if event==1
    if window<threshold
        window=window*2;
    else
        window=window+1;
    end
else
    threshold=window/2;
    window=threshold;
end