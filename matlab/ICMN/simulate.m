function time=simulate(k)
node=linspace(0,0,32);
node(1)=k;
time=0;
%randi([1,2],1,2)


while 1
    meet=linspace(0,0,2); %two meet node
    time=time+1;
    while meet(1)==meet(2) %if same node meet, create again
        meet=randi([1,32],1,2);
    end
    
    if meet(1)==1||meet(2)==1 %if one of the node is the seed node
        if node(1)>0  %if seed node still has copies
           node(1)=node(1)-2;
           node(meet(1))=node(meet(1))+1;
           node(meet(2))=node(meet(2))+1;
        end
    end
    
    if meet(1)==32||meet(2)==32 %if one of the node is the dest node
        if node(meet(1))>0||node(meet(2))>0
            node(32)=node(32)+2;
            node(meet(1))=node(meet(1))-1;
            node(meet(2))=node(meet(2))-1;
        end
    end
 
    if node(32)>0 %if node32 get the copy. success!
        break;  
    end
end
time;
