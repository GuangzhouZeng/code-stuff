function [time,trans]=flooding()

node=linspace(0,0,32);
node(1)=1;
time=0;     %time used
trans=0;    %number of transmission;


while 1
    meet=linspace(0,0,2); %two meet node
    time=time+1;
    while meet(1)==meet(2) %if same node meet, create again
        meet=randi([1,32],1,2);
    end
    
    if node(meet(1))==1||node(meet(2))==1 %if one of the node has the packet
        if node(meet(1))+node(meet(2))==1 %one node is 1,another is 0 can transmit
            trans=trans+1;
            node(meet(1))=1;
            node(meet(2))=1;
        end
    end
 
    if node(32)==1 %if node32 get the copy. success!
        break;  
    end
end
time;
