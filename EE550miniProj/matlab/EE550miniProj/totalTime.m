function res=totalTime(T,path)
res=0;

for i=1:1:length(path)
    res=max(res,T(path(i)));
end
