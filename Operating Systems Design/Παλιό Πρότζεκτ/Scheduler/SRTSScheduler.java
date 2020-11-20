/**
 *
 * @author Thanasis Metallas
 */
package Scheduler;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SRTSScheduler {
    private ArrayList <Process> ProcessQueue;
    private double AverageTurnAroundTime;
    private double AverageResponseTime;
    
    // Default constructor.
    public SRTSScheduler() {
        this.ProcessQueue = new ArrayList<>();
    }
    
    // Constructor pou pairnei ArrayList me antikeimena typou Process.
    public SRTSScheduler(ArrayList<Process> Proc) {
        this.ProcessQueue = Proc;     
    }
    
    // Methodos taksinomisis diergasiwn me bash to arrival time.
    public void sortQueue(){
        Process temp;

        // Taksinomhsh tou ProcessQueue se auksousa seira me bash to ArrivalTime.
        for (int i = 0  ; i < ProcessQueue.size(); i++) {
            for (int j = 1; j < (ProcessQueue.size() - i); j++){
                if (ProcessQueue.get(j - 1).getProcessArrivalTime() > ProcessQueue.get(j).getProcessArrivalTime()){
                    temp = ProcessQueue.get(j - 1);
                    ProcessQueue.set(j - 1, ProcessQueue.get(j));
                    ProcessQueue.set(j, temp);
                }
            }
        } 
    }
    
    // Methodos ekkinhshs algorithmou SJNS
    //        double pin[][] = new double[ProcessQueue.size()][2];
//        for (int i = 0; i < ProcessQueue.size(); i++) {
//            pin[i][0] = i;
//            pin[i][1] = 0;
//        }
        
        // loop ekteleshs tou SRTS
        while (ProcessQueue.size() != 0){
            
            minArrivalTime = ProcessQueue.get(0).getProcessArrivalTime();
            minExecutionTime = ProcessQueue.get(0).getProcessExecuteTime();
            
            // epilogh stoixeiou me mikrotero Arrival kai Execute xrono
            for (int i = 0; i < ProcessQueue.size(); i++){
                tempArrivalTime = ProcessQueue.get(i).getProcessArrivalTime();
                tempExecutionTime = ProcessQueue.get(i).getProcessExecuteTime();
                //System.out.println("in For");
                if (tempArrivalTime <= minArrivalTime && tempExecutionTime <= minExecutionTime){
                    minArrivalTime = tempArrivalTime;
                    minExecutionTime = tempExecutionTime;
                    srtIndex = i;
                }
            }
            System.out.println("index: " + srtIndex);
            sub = ProcessQueue.get(srtIndex).getProcessExecuteTime() - seconds;
            seconds++;
            ProcessQueue.get(srtIndex).setProcessExecuteTime(sub);
            
            if (ProcessQueue.get(srtIndex).getProcessExecuteTime() <= 0){
                System.out.println("Process: " + ProcessQueue.get(srtIndex).getProcessID() + " has finished executing.");
                ProcessQueue.remove(srtIndex);
            }
            System.out.println("\n" + processesEnqueued() + "\n");
            if (ProcessQueue.size() != 0)
                System.out.println("Process selected: " + ProcessQueue.get(srtIndex).getProcessID() + " | ExecuteTime:" + ProcessQueue.get(srtIndex).getProcessExecuteTime());
    
    // Methodos pou epistrefei AverageTurnAroundTime.
    public double getAverageTurnAroundTime() {
        return AverageTurnAroundTime;
    }
    
    // Methodos pou thetei timh sto AverageTurnAroundTime.
    public void setAverageTurnAroundTime(double AverageTurnAroundTime) {
        this.AverageTurnAroundTime = AverageTurnAroundTime;
    }

    // Methodos pou epistrefei AverageResponseTime.
    public double getAverageResponseTime() {
        return AverageResponseTime;
    }

    // Methodos pou thetei timh sto AverageResponseTime.
    public void setAverageResponseTime(double AverageResponseTime) {
        this.AverageResponseTime = AverageResponseTime;
    }
    
    // Methodos pou that typwnei ta stoixeia tis diergasias pou mphke sto queue
    public String processesEnqueued() {
        return "Process Enqueued: \n" + ProcessQueue.toString();
    }
    
    // Methodos epistrofhs megethous tou queue
    public int size()
    {
        return this.ProcessQueue.size();
    }
    
    // Methodos ekxwrhseis diergasias sto queue
    public void addProcessToListQueue(Process Proc)
    {
        this.ProcessQueue.add(Proc);
    }
}
