function path = findPath(next)

len=length(next);
cur=next(1);

i=2;
path(1)=1;
while cur~=len
    path(i)=cur;
    i=i+1;
    cur=next(cur);
end
path(i)=cur;


