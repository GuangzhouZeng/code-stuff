%model:
%   0
%   1<-2
%   3<-4<-5<-6
%   ...

function state=newState(id,state,m)
curSta=state(id);
if log2(curSta)<m   %not the last level
    nextBegin=2*curSta;
    nextEnd=4*curSta-1;
else                %last level
    nextBegin=curSta;
    nextEnd=2*curSta-1;
end
state(id)=randi([nextBegin,nextEnd],1,1);














