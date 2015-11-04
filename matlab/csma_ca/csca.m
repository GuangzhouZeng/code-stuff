function throughput=csca(node,time,m)
%network state: 
%0        idle
%1        busy, no collision, can transmit
%>1       busy, collision, cannot transmit, have to calculate a new state
netState = 0;        

transID=0;  %next transmit node;    
state=linspace(1,1,node);  %each node's state, ex. %state=[0,1,2,3,4]

%statistics
totalPkt=0;     %success packets.
tranTime=0;     %total transmit timeslot
idleTime=0;     %total idle timeslot
collTime=0;     %total collision timeslot


for t=1:1:time
    netState=0; %every time slot, netState is idle
    %disp('--------------------------------');
    %disp(['timeslot ',num2str(t),':']);
    %disp(state);    %display current state
    %pause(0.01);    %just used for simulation effect. Unit: second
    for i=1:1:node
        curSta=state(i);
        if log2(curSta)-floor(log2(curSta))==0
            if netState==0
                transID=i;
            else
               state=newState(i,state,m);
               %disp(['Collision node:',num2str(i)]);
            end
            netState=netState+1;
        else     %other back off state
            state(i)=state(i)-1; 
        end
    end
    if netState==1 %only one transmitter, it can transmit
        state(transID)=1;  %if success, state back to 1;
        totalPkt=totalPkt+1;
        tranTime=tranTime+1;
        %disp(['Success! Now node ',num2str(transID), ' transmit packet:', num2str(totalPkt)]);
    elseif netState>1 %more than one transmitter, collision!
        transmitID=0;
        state=newState(transID,state,m);
        collTime=collTime+1;
        %disp(['Collision node: ',num2str(transID)]);
    else  % netState=0 nothing happens.
        idleTime=idleTime+1;
        %disp('Idle in this timeslot');
    end
end

%disp('--------------statistics------------------');
%disp(['Success: ',num2str(totalPkt)]);
%disp(['Time: ',num2str(time)]);
%disp(['Throughput: ',num2str(totalPkt/time)]);
%disp(['Transmit timeslot: ',num2str(tranTime)]);
%disp(['Collision timeslot: ',num2str(collTime)]);
%disp(['Idle timeslot: ',num2str(idleTime)]);
throughput=(totalPkt/time);


