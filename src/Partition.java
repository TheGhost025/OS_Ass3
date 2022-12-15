public class Partition {
    private int size;
    private String name;
    private Process process;

    public Partition(){
        size=0;
        name=null;
        process=null;
    }

    public Partition(int s,String n){
        size=s;
        name=n;
        process=null;
    }

    public void setPartitionName(String n){
        name=n;
    }

    public void setPartitionSize(int s){
        size=s;
    }

    public void setPartitionProcess(Process p){
        process=p;
    }

    public String getPartitionName(){
        return name;
    }

    public int getPartitionSize(){
        return size;
    }

    public Process getPartitionProcess(){
        return process;
    }
}
