function [ Res,next ] = BellmanFord( I )

len=length(I);
Res=ones(len)*Inf;
for i=1:len
    Res(1,i)=I(i,len);
end
next=linspace(len,len,len); %record the previous node
for h=2:len %this is h
    for i=1:len %this is node i
        for j=1:len %this is node j which could be node i's adjancent node
            Res(h,i)=min(Res(h-1,j)+I(i,j),Res(h,i));
            if ((Res(h-1,j)+I(i,j))~=inf)&&(Res(h-1,j)+I(i,j))==Res(h,i)
                next(i)=j;
            end
        end
    end
    if Res(h,:)==Res(h-1,:)
        break;
    end
end