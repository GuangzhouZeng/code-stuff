function res=totalEnergy(T,path)
res=0;

path=path-1;
for i=1:1:length(path)-1
    dist=path(i+1)-path(i);
    res=res+exp(dist);
end