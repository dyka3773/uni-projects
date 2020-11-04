/**
 *
 * @author Thanasis Metallas
 */
package Scheduler;


import java.util.ArrayList;

public class SJNSScheduler {
    private ArrayList <Process> ProcessQueue;
    private double AverageTurnAroundTime;
    private double AverageResponseTime;
    
    // Default constructor.
    public SJNSScheduler() {
        this.ProcessQueue = new ArrayList<>();
    }
    
    // Constructor pou pairnei ArrayList me antikeimena typou Process.
    public SJNSScheduler(ArrayList<Process> Proc) {
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
    
    public void selectSJN(){
        // thelei parapanw douleia auto to kommati
        // tha grapsw sxolia aurio, thelw na paw gia ypno twra
        // PS. na sbhseis auta ta sxolia.
        double minArrivalTime = ProcessQueue.get(0).getProcessArrivalTime();
        double minServiceTime = ProcessQueue.get(0).getProcessServiceTime();
        double tempArrivalTime, tempServiceTime;
        int sjnIndex;
        for (int i = 0; i < ProcessQueue.size(); i++){
            tempArrivalTime = ProcessQueue.get(i).getProcessArrivalTime();
            tempServiceTime = ProcessQueue.get(i).getProcessServiceTime();
            if (tempArrivalTime < minArrivalTime && tempServiceTime < minServiceTime){
                minArrivalTime = tempArrivalTime;
                minServiceTime = tempServiceTime;
                sjnIndex = i;
            }
        }
    }
    
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
