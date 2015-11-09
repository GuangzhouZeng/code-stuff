clc;
clear all;
T=[0,1,3,1,8,2,4,8,2,4,5,6,4,8,2,3,9,10,3,1,3,4,4,5,5,6,3,1,2,5,6,7,4,5,6,3,2,1,3,5,7,8,6,4,2,1,1,4,4,5,5,0];
D=3;
len=length(T);
E=inf(len);
for i=1:1:len
    for j=i:1:len
        if j-i<=D
           E(i,j)=max(T(j)-T(i),0);
           if i==j
               C(i,j)=0;
           else
               C(i,j)=exp(j-i);
           end
        end
    end
end
Cmax=max(max(C));
C=C/(len*Cmax);
Combine=E+C;

[res,next]=BellmanFord(Combine);
path=findPath(next);
disp(['path: ',num2str(path-1)]);
timeUsed=totalTime(T,path)
powUsed=totalEnergy(T,path)
