/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;
import java.util.ArrayList;
/**
 *
 * @author Sakis
 */
public class FCFSScheduler {
    @SuppressWarnings("FieldMayBeFinal")
    private ArrayList<Process> ProcessQueue;
    private double averageTurnaroundTime;

    FCFSScheduler(ArrayList<Process> PLQ) 
    {
        if(PLQ == null)
        {
            this.ProcessQueue = new ArrayList<>();
        }
        else
        {
            double sum = 0x0;
            this.ProcessQueue = PLQ;
            sum = this.ProcessQueue.stream().map(PRCS -> this.ProcessQueue.get(this.ProcessQueue.indexOf(PRCS)).getProcessWaitTime()).reduce(sum, (accumulator, _item) -> accumulator + _item);
            this.setAverageTurnaroundTime(sum/this.size());
        }
    }
    int size()
    {
        return this.ProcessQueue.size();
    }
    private void setAverageTurnaroundTime(double averageTurnaroundTime) {
        this.averageTurnaroundTime = averageTurnaroundTime;
    }
    void addProcessToListQueue(Process PRCS)
    {
        this.ProcessQueue.add(PRCS);
    }

    String processesEnqueued() {
        return "Process Enqueued: \n" + ProcessQueue.toString();
    }
    
    void calculateAverageTurnaroundTime()
    {
        double sum = 0x0;
        sum = this.ProcessQueue.stream().map(PRCS -> this.ProcessQueue.get(this.ProcessQueue.indexOf(PRCS)).getProcessWaitTime()).reduce(sum, (accumulator, _item) -> accumulator + _item);
        this.setAverageTurnaroundTime(sum/this.size());
    }

    public double getAverageTurnaroundTime() {
        return averageTurnaroundTime;
    }
    
    
    
}
