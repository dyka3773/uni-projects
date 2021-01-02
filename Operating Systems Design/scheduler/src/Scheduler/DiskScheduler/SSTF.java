package Scheduler.DiskScheduler;

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
    private int arr[];
    private long head;
    private long[] seek_sequence;
    private long seek_count;

    public SSTF(int[] arr) {
        this.arr = arr;
        head = (int)DISK_SIZE/2;
        //start();
    }

    public SSTF() {
    }
    
    public void start() {
        shortestSeekTimeFirst(arr, head);
    }
        
    public int setDistance() {
            return 0;
    }

    public boolean setAccessed() {
        return false;
    }   
        
    public void calculateDifference(int queue[], long head, SSTF diff[])                                       
    {
        for (int i = 0; i < diff.length; i++) 
            diff[i].distance = Math.abs(queue[i] - head); 
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
    
    public void shortestSeekTimeFirst(int request[], long head)                                                        
    { 
        if (request.length == 0) 
            return; 
              
        // create array of objects of class node     
        SSTF diff[] = new SSTF[request.length];  
          
        // initialize array 
        for (int i = 0; i < diff.length; i++)            
            diff[i] = new SSTF(); 
          
        // count total number of seek operation     
        seek_count = 0;  
          
        // stores sequence in which disk access is done 
        seek_sequence = new long[request.length + 1];  
          
        for (int i = 0; i < request.length; i++) {              
            seek_sequence[i] = head; 
            calculateDifference(request, head, diff);               
            int index = findMin(diff);               
            diff[index].accessed = true; 
              
            // increase the total count 
            seek_count += diff[index].distance;  
              
            // accessed track is now new head 
            head = request[index];  
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
