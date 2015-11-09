clc;
clear all;

totalTry=5000;
k=[1,2,4,8,16,32];%copies
time1 = linspace(0,0,length(k)); %time of spray and wait
time2 = linspace(0,0,length(k)); %time of epidemic flooding
trans1=linspace(0,0,length(k));
trans2=linspace(0,0,length(k));
for i=1:1:6
    for j=1:1:totalTry
        [timetemp,transtemp]=SAW(k(i));
        time1(i)=timetemp+time1(i);
        trans1(i)=transtemp+trans1(i);
        %[time2(i),trans2(i)]=time2(i)+flooding();
    end
    time1(i)=time1(i)/totalTry;
    trans1(i)=trans1(i)/totalTry;
    %time2(i)=time2(i)/totalTry;
end
disp(['time:', num2str(time1)]);
disp(['trans:', num2str(trans1)]);
%disp(['time:', num2str(time2)]);
k=[1,2,4,8,16,32];
figure(1);
plot(k,time1);
xlabel('number of copies');
ylabel('timeslots*E[T]');
title('Expected time VS number of copies ')

figure(2);
plot(k,trans1);
xlabel('number of copies');
ylabel('number of transmissions');
title('Expected number of transmissions VS number of copies');
%hold on;
%plot(k,time2);



