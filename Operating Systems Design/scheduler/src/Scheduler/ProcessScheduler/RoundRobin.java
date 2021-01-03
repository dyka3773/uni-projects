/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scheduler.ProcessScheduler;

import Scheduler.SimProcess;
import java.util.ArrayList;

/**
 *
 * @author Herck
 */
public class RoundRobin {
    
    private int quantum = 2;
    private ArrayList<SimProcess> processList;
    private int n;
    
    private int arrival_time[];
    private int brusttime[];
    private int waiting_time[];
    private int turnaround_time[];
    private int completion_time[];
    
    public RoundRobin() {
    }
                                       //***Priority Queue Elements are ArrayLists***
    public ArrayList<SimProcess> start(ArrayList<SimProcess> sortedQueue){
        
        //Sorting the Process Array according to it's arrival time
        for (int i = 0; i < sortedQueue.size()-1; i++) 
            for (int j = 0; j < sortedQueue.size()-i-1; j++) 
                if (sortedQueue.get(j).getArrivalTime() > sortedQueue.get(j+1).getArrivalTime()) 
                {
                    SimProcess temp = sortedQueue.get(j); 
                    sortedQueue.set(j, sortedQueue.get(j+1)); 
                    sortedQueue.set(j+1, temp); 
                }
        
        ArrayList<SimProcess> execQueue = new ArrayList();
        ArrayList<SimProcess> BlockedQueue = new ArrayList<SimProcess>();
        
        for (SimProcess i : sortedQueue){
            if (i.needsIO()){
                BlockedQueue.add(i);
                continue;
            }
            execQueue.add(i);
        }
        
        this.processList = execQueue;
        this.n = processList.size();
        arrival_time = new int[n];
        String process[] = new String[n];
        brusttime = new int[n];
        
        int index =0;
        
        for(SimProcess i : processList){
            arrival_time[index] = i.getArrivalTime();
            brusttime[index] = i.getBurstTime();
            process[index] = i.getName();
            index++;
        }
        
        System.out.println("Round Robin's Execution Queue: ");
        for(SimProcess i: execQueue)
            System.out.println(i.toString());
        
        findAvgTime(process);
        
        for(SimProcess i: BlockedQueue){
            i.setIO(false);
        }
        return BlockedQueue;
    }
    
    public void findWaitingTime(){
        // copy the value of brusttime array into wt_time array.
        int rem_time[] = new int[n];
         
        for(int i=0;i<waiting_time.length;i++){
            rem_time[i]= brusttime[i];
        }
        int t=0;
        int arrival=0;
        // processing until the value of element of rem_time array is 0
        while(true){
            boolean done = true;
            for(int i=0;i<n;i++){
                if(rem_time[i]>0){
                    done =false;
                    if(rem_time[i]>quantum && arrival_time[i]<=arrival){
                        t +=quantum;
                        rem_time[i]-=quantum;
                        arrival++;
                    }
                    else if(arrival_time[i]<=arrival){
                        arrival++;
                        t+=rem_time[i];
                        rem_time[i]=0;
                        completion_time[i]=t; 
                    }
                    else arrival++;
                }
            }
             
            if(done==true)    
            { 
                break;
                }
        }    
    }
    
    public void findTurnAroundTime(){
        for(int i=0;i<n;i++){
            turnaround_time[i]= Math.abs(completion_time[i]-arrival_time[i]);
            waiting_time[i] = Math.abs(turnaround_time[i]-brusttime[i]);
             
             
        }    
    }
    
    public void findAvgTime(String process[]){
      waiting_time = new int[n];
      turnaround_time = new int[n];
      completion_time = new int[n];
      findWaitingTime();    
      findTurnAroundTime();
      int total_wt = 0, total_tat = 0; 
       
      System.out.println("Processes " +" Arrival Time\t"+ "  Burst time " +" Completion time"+ 
              " Turnaround Time " + " Waiting time");
      for (int i=0; i<n; i++) 
      { 
          total_wt = total_wt + waiting_time[i]; 
          total_tat = total_tat + turnaround_time[i]; 
          System.out.println(" " + process[i] + "\t\t"+ arrival_time[i]+"\t\t"+ + brusttime[i] +"\t " +completion_time[i]+"\t\t"
                            +turnaround_time[i] +"\t\t " + waiting_time[i]); 
      } 
      
      System.out.println("Average waiting time = " + 
                        (float)total_wt / (float)n); 
      System.out.println("Average turn around time = " + 
                         (float)total_tat / (float)n); 
    }
    
}
