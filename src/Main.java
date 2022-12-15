import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Partition> partitions=new LinkedList<Partition>();
        LinkedList<Process> processes=new LinkedList<Process>();
        int maxNumOfPartition;
        int maxNumOfProcess;
        Scanner myObj=new Scanner(System.in);

        System.out.print("Enter number of Partition ");
        maxNumOfPartition=myObj.nextInt();

        for(int i=0;i<maxNumOfPartition;i++){
            System.out.print("Partition "+(i+1)+" ");
            int size=myObj.nextInt();
            partitions.add(new Partition(size,"Partition "+(i+1)));
        }

        System.out.print("Enter number of Process ");
        maxNumOfProcess=myObj.nextInt();
        for(int i=0;i<maxNumOfProcess;i++){
            System.out.print("Process "+(i+1)+" ");
            int size=myObj.nextInt();
            processes.add(new Process(size,"Process "+(i+1)));
        }

        System.out.println("Select the policy you want to apply:");
        System.out.println("1  First fit");
        System.out.println("2 Worst fit");
        System.out.println("3 Best fit");
        int choose=myObj.nextInt();

        //Fisrt Fit
        if(choose==1){

        }
        //Worst Fit
        else if(choose==2){

        }
        //Best Fit
        else if(choose==3){
            for(int i=0;i<maxNumOfProcess;i++){
                int min=1000000000;
                int index=0;
                for(int j=0;j<partitions.size();j++){
                    if((processes.get(i).getProcessSize()<=partitions.get(j).getPartitionSize())&&(partitions.get(j).getPartitionProcess()==null)){
                        if(min>=partitions.get(j).getPartitionSize()){
                            min=partitions.get(j).getPartitionSize();
                            index=j;
                        }
                    }
                }
                if(min!=1000000000){
                    int sizeNewPartiton=partitions.get(index).getPartitionSize()-processes.get(i).getProcessSize();
                    partitions.get(index).setPartitionProcess(processes.get(i));
                    processes.get(i).setProcessState(true);
                    partitions.get(index).setPartitionSize(processes.get(i).getProcessSize());
                    if(sizeNewPartiton!=0){
                        partitions.add(index+1,new Partition(sizeNewPartiton,"Partition "+(partitions.size()+1)));
                    }
                }
            }
            for(int i=0;i<partitions.size();i++){
                System.out.print(partitions.get(i).getPartitionName()+" "+partitions.get(i).getPartitionSize()+ " KB => ");
                if(partitions.get(i).getPartitionProcess()!=null){
                    System.out.print(partitions.get(i).getPartitionProcess().getProcessName());
                }
                else {
                    System.out.print("External fragment");
                }
                System.out.println();
            }
            System.out.print("Do you want to compact? 1.yes 2.no ");
            int state=myObj.nextInt();
            //compaction
            if(state==1){
                int sum=0;
                int size=partitions.size()+1;
                LinkedList<Partition> deletedPartion=new LinkedList<Partition>();
                for(int i=0;i<partitions.size();i++){
                    if(partitions.get(i).getPartitionProcess()==null){
                        sum+=partitions.get(i).getPartitionSize();
                        deletedPartion.add(partitions.get(i));
                    }
                }

                for(int i=0;i< deletedPartion.size();i++){
                    partitions.remove(deletedPartion.get(i));
                }

                partitions.add(new Partition(sum,"Partition "+size));

                for(int i=0;i<maxNumOfProcess;i++){
                    if(!processes.get(i).getProcessState()){
                        int min=1000000000;
                        int index=0;
                        for(int j=0;j<partitions.size();j++){
                            if((processes.get(i).getProcessSize()<=partitions.get(j).getPartitionSize())&&(partitions.get(j).getPartitionProcess()==null)){
                                if(min>=partitions.get(j).getPartitionSize()){
                                    min=partitions.get(j).getPartitionSize();
                                    index=j;
                                }
                            }
                        }
                        if(min!=1000000000){
                            int sizeNewPartiton=partitions.get(index).getPartitionSize()-processes.get(i).getProcessSize();
                            partitions.get(index).setPartitionProcess(processes.get(i));
                            processes.get(i).setProcessState(true);
                            partitions.get(index).setPartitionSize(processes.get(i).getProcessSize());
                            if(sizeNewPartiton!=0){
                                partitions.add(index+1,new Partition(sizeNewPartiton,"Partition "+(partitions.size()+1)));
                            }
                        }
                    }
                }

                for(int i=0;i<partitions.size();i++){
                    System.out.print(partitions.get(i).getPartitionName()+" "+partitions.get(i).getPartitionSize()+ " KB => ");
                    if(partitions.get(i).getPartitionProcess()!=null){
                        System.out.print(partitions.get(i).getPartitionProcess().getProcessName());
                    }
                    else {
                        System.out.print("External fragment");
                    }
                    System.out.println();
                }
            }
        }
    }
}