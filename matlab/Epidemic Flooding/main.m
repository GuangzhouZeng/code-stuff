%testFlooding
time=0;
trans=0;
totalTry=10000;
for i=1:1:totalTry
    [temptime,temptrans]=flooding();
    time=time+temptime;
    trans=trans+temptrans;
end
time=time/totalTry
trans=trans/totalTry
