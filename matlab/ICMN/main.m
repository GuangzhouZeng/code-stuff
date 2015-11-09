
totalTry=5000;
k=[1,2,4,8,16,32];%copies
time = linspace(0,0,length(k));
for i=1:1:6
    for j=1:1:totalTry
        time(i)=time(i)+simulate(k(i));
    end
    time(i)=time(i)/totalTry;
end
disp(['time:', num2str(time)]);
k=[1,2,4,8,16,32];
plot(k,time);
xlabel('number of copies');
ylabel('timeslots*E[T]')