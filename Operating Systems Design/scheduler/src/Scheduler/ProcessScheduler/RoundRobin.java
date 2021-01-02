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

                      //***Priority Queue Elements are ArrayLists***
    public RoundRobin() {
    }
    
    public ArrayList<SimProcess> start(ArrayList<SimProcess> sortedQueue){
        this.processList = sortedQueue;
        this.n = processList.size();
        int arrival_time[] = new int[n];
        String process[] = new String[n];
        int brusttime[] = new int[n];
        
        int index =0;
        ArrayList<SimProcess> execQueue = new ArrayList();
        ArrayList<SimProcess> BlockedQueue = new ArrayList<SimProcess>();
        for(SimProcess i : processList){
            if (i.needsIO()){
                BlockedQueue.add(i);
                continue;
            }
            execQueue.add(i);
            arrival_time[index] = i.getArrivalTime();
            brusttime[index] = i.getBurstTime();
            process[index] = i.getName();
        }
        
        System.out.println("Round Robin's Execution Queue: ");
        for(SimProcess i: execQueue)
            System.out.println(i.toString());
        
        //findAvgTime(process,n,brusttime,quantum,arrival_time);
        
        return BlockedQueue;
    }
    
    public static void findWaitingTime(String process[],int wt_time[],int n ,int brusttime[],int quantum,int completion_time[],int arrival_time[]){
        // copy the value of brusttime array into wt_time array.
        int rem_time[] = new int[n];
         
        for(int i=0;i<wt_time.length;i++){
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
                    else{
                    if(arrival_time[i]<=arrival){
                        arrival++;
                        t+=rem_time[i];
                        rem_time[i]=0;
                        completion_time[i]=t; }
                    }
                 }
              }
             
            if(done==true)    
            { 
                break;
                }
        }    
    }
    
    public static void findTurnAroundTime(String process[] ,int wt_time[],int n,int brusttime[],int tat_time[],int completion_time[],int arrival_time[]){
        for(int i=0;i<n;i++){
            tat_time[i]= completion_time[i]-arrival_time[i];
            wt_time[i] = tat_time[i]-brusttime[i];
             
             
        }    
    }
    
    public static void findAvgTime(String process[],int n,int brusttime[],int quantum,int arrival_time[]){
      int wt_time[] = new int[n];
      int tat_time[] = new int[n];
      int completion_time[] = new int[n];
      findWaitingTime(process,wt_time,n,brusttime,quantum,completion_time,arrival_time);    
      findTurnAroundTime(process,wt_time,n,brusttime,tat_time,completion_time,arrival_time);
      int total_wt = 0, total_tat = 0; 
       
      System.out.println("Processes " +" Arrival Time\t"+ "  Burst time " +" completion time"+ 
              " Turn Around Time " + " Waiting time");
      for (int i=0; i<n; i++) 
      { 
          total_wt = total_wt + wt_time[i]; 
          total_tat = total_tat + tat_time[i]; 
          System.out.println(" " + (i+1) + "\t\t"+ arrival_time[i]+"\t\t"+ + brusttime[i] +"\t " +completion_time[i]+"\t\t"
                            +tat_time[i] +"\t\t " + wt_time[i]); 
      } 
      
      System.out.println("Average waiting time = " + 
                        (float)total_wt / (float)n); 
      System.out.println("Average turn around time = " + 
                         (float)total_tat / (float)n); 
    }
    
}
