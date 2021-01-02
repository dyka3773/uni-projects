package Scheduler.DiskScheduler;

import Scheduler.SimProcess;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Captain Nero
 */
public class SSTF implements DiskScheduler{
    // Attributes used for the algorithm
    private long distance;
    private boolean accessed;
   
    // Attributes used when calling the algorithm
    private ArrayList<SimProcess> requestQueue;
    private long head;
    private long[] seek_sequence;
    private long seek_count;

    public SSTF(ArrayList<SimProcess> ProcessList) {
        this.requestQueue = ProcessList;
        head = DISK_SIZE/2;
        //start();
    }

    public SSTF() {
    }
    
    public void start() {
        shortestSeekTimeFirst();
    }
        
    public int setDistance() {
            return 0;
    }

    public boolean setAccessed() {
        return false;
    }   
        
    public void calculateDifference(SSTF diff[])                                       
    {
        for (int i = 0; i < diff.length; i++) 
            diff[i].distance = Math.abs(requestQueue.get(i).getTrackAddress() - head); 
    } 
    
    public int findMin(SSTF diff[]) 
    { 
        int index = -1;
        long minimum = Long.MAX_VALUE;   
        for (int i = 0; i < diff.length; i++) 
        { 
            if (!diff[i].accessed && minimum > diff[i].distance) 
            {                   
                minimum = diff[i].distance; 
                index = i; 
            } 
        } 
        return index; 
    } 
    
    public void shortestSeekTimeFirst()                                                        
    { 
        if (requestQueue.size() == 0) 
            return; 
              
        // create array of objects of class node     
        SSTF diff[] = new SSTF[requestQueue.size()];  
          
        // initialize array 
        for (int i = 0; i < diff.length; i++)            
            diff[i] = new SSTF(); 
          
        // count total number of seek operation     
        seek_count = 0;  
          
        // stores sequence in which disk access is done 
        seek_sequence = new long[requestQueue.size() + 1];  
          
        for (int i = 0; i < requestQueue.size(); i++) {              
            seek_sequence[i] = head; 
            calculateDifference(diff);               
            int index = findMin(diff);               
            diff[index].accessed = true; 
              
            // increase the total count 
            seek_count += diff[index].distance;  
              
            // accessed track is now new head 
            head = requestQueue.get(index).getTrackAddress();  
        } 
          
        // for last accessed track 
        seek_sequence[seek_sequence.length - 1] = head;           
        System.out.println("Total number of seek operations = " + seek_count);                                                       
        System.out.println("Seek Sequence is"); 
          
        // print the sequence 
        for (int i = 0; i < seek_sequence.length; i++)  
            System.out.println(seek_sequence[i]); 
    }

    @Override
    public String getHeadPosition() {
        return Long.toString(head);
    }

    @Override
    public void setHeadPosition(long hpos) {
        this.head = hpos;
    }

    @Override
    public String getProcessTrackSequence() {
        return seek_sequence.toString();
    }

    @Override
    public String getSeekOperations() {
        return Long.toString(seek_count);
    }

    @Override
    public void setSeekOperations(long sop) {
        seek_count = sop;
    }
    
}
