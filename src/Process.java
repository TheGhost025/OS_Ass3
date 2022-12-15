public class Process {
    private int size;
    private String name;
    private boolean state;

    public Process(int s,String n){
        size=s;
        name=n;
        state=false;
    }

    public Process(){
        size=0;
        name=null;
        state=false;
    }

    public void setProcessName(String n){
        name=n;
    }

    public void setProcessSize(int s){
        size=s;
    }

    public void setProcessState(boolean s){
        state=s;
    }

    public String getProcessName(){
        return name;
    }

    public int getProcessSize(){
        return size;
    }

    public boolean getProcessState(){
        return state;
    }
}
