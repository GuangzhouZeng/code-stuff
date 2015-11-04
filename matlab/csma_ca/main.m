clear;
%Variables.
node = 20;       %total node. node id from 1 to node
time = 1000;     %total time. iteration time
m=6;            %This is back off depth(0,m), totally m+1 levels; [0,2^m-1] 


throughput=linspace(0,0,node);
throuPerNode=linspace(0,0,node);

for i=1:1:node
%     temp=0;
%     for j=1;1:5
%         temp=temp+csca(i,time,m);
%         temp
%     end
    temp=0;
    for j=1:1:10
        temp=temp+csca(i,time,m);
    end
    throughput(i)=temp/10;
    throuPerNode(i)=throughput(i)./i;
    %throughput(i)=csca(i,time,m);
end
throughput=3*throughput;
throuPerNode=3*throuPerNode;
disp(['throughput:',num2str(throughput)]);
disp(['throughput:',num2str(throuPerNode)]);
nodeNum=1:1:node;

figure(1)
plot(nodeNum,throughput);
xlabel('number of transmitters');
ylabel('Throughput(Mbps)');

figure(2);
plot(nodeNum,throuPerNode);
xlabel('number of transmitters');
ylabel('Throughput per transmitters(Mbps)');