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

    @Override
    public String toString() {
        return "Process{" + "processID=" + processID 
                + ", processArrivalTime=" + processArrivalTime 
                + ", processExecuteTime=" + processExecuteTime 
                + ", processServiceTime=" + processServiceTime 
                + ", processWaitTime=" + processWaitTime + "}\n";
    }
    
    
}
