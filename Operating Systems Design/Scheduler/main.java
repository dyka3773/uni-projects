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
public class main {
    public static void main(String[] args) {
        FCFSScheduler scheduler = new FCFSScheduler(null);
        Process[] PRCS = new Process[4];
        PRCS[0] = new Process("P0", 0, 5, 0);
        PRCS[1] = new Process("P1", 1, 3, 5);
        PRCS[2] = new Process("P2", 2, 8, 8);
        PRCS[3] = new Process("P3", 3, 6, 16);
        for(Process process: PRCS)
        {
            scheduler.addProcessToListQueue(process);
        }
        scheduler.calculateAverageTurnaroundTime();
        System.out.println(scheduler.processesEnqueued()+"\nAverage turnaround time: "+scheduler.getAverageTurnaroundTime());
    }
}
