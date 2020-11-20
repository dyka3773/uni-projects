/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler;

/**
 *
 * @author Sakis
 */
public class Process {
    @SuppressWarnings("FieldMayBeFinal")
    private String processID;
    @SuppressWarnings("FieldMayBeFinal")
    private double processArrivalTime;
    @SuppressWarnings("FieldMayBeFinal")
    private double processExecuteTime;
    @SuppressWarnings("FieldMayBeFinal")
    private double processServiceTime;
    @SuppressWarnings("FieldMayBeFinal")
    private double processWaitTime;
    private boolean isExecuting; // Deixnei an mia diergasia brisketai se ektelesh
    Process(String processID, double processArrivalTime,
            double processExecuteTime, double processServiceTime)
    {
        this.processID = processID;
        this.processArrivalTime = processArrivalTime;
        this.processExecuteTime = processExecuteTime;
        this.processServiceTime = processServiceTime;
        this.processWaitTime = this.processServiceTime - this.processArrivalTime;
    }

    public String getProcessID() {
        return processID;
    }

    public double getProcessArrivalTime() {
        return processArrivalTime;
    }

    public double getProcessExecuteTime() {
        return processExecuteTime;
    }

    public double getProcessServiceTime() {
        return processServiceTime;
    }

    public double getProcessWaitTime() {
        return processWaitTime;
    }

    public boolean getIsExecuting() {
        return isExecuting;
    }

    // H setIsExecuting yparxei edw gia na kathorizete apo ton kathe algorithmo an to process ekteleitai h oxi.
    public void setIsExecuting(boolean isExecuting) {
        this.isExecuting = isExecuting;
    }
    
    @Override
    public String toString() {
        return "Process{" + "processID=" + processID 
                + ", processArrivalTime=" + processArrivalTime 
                + ", processExecuteTime=" + processExecuteTime 
                + ", processServiceTime=" + processServiceTime 
                + ", processWaitTime=" + processWaitTime + "}\n";
    }
    
    
}
