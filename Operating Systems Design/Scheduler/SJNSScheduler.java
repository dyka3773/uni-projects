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
    
    public SJNSScheduler() {
        this.ProcessQueue = new ArrayList<>();
    }
    
    public SJNSScheduler(ArrayList<Process> Proc) {
        this.ProcessQueue = Proc;     
    }

    public double getAverageTurnAroundTime() {
        return AverageTurnAroundTime;
    }

    public void setAverageTurnAroundTime(double AverageTurnAroundTime) {
        this.AverageTurnAroundTime = AverageTurnAroundTime;
    }

    public double getAverageResponseTime() {
        return AverageResponseTime;
    }

    public void setAverageResponseTime(double AverageResponseTime) {
        this.AverageResponseTime = AverageResponseTime;
    }
    
    String processesEnqueued() {
        return "Process Enqueued: \n" + ProcessQueue.toString();
    }
    
    int size()
    {
        return this.ProcessQueue.size();
    }
    
    void addProcessToListQueue(Process Proc)
    {
        this.ProcessQueue.add(Proc);
    }
}
