package Scheduler;
import java.util.ArrayList;

public class FIFO {
    
    private ArrayList<SimProcess> requestQueue;
    private long currentTrack = 100;//(long) (Math.random() * 200 + 1);
    private double avgSeekLength = 0;
    private long tracksTraversedSum;
    
    public FIFO(ArrayList<SimProcess> ProcessList) {
        requestQueue = ProcessList;
        SimProcessSort(requestQueue);
        tracksTraversedSum = Math.abs(requestQueue.get(0).getTrackAddress() - currentTrack);
        currentTrack = requestQueue.get(0).getTrackAddress();
        
        for (int i = 1; i < requestQueue.size(); i++){         
            tracksTraversedSum += Math.abs(requestQueue.get(i).getTrackAddress() - currentTrack);
            currentTrack = requestQueue.get(i).getTrackAddress();
        }
        
        avgSeekLength =  tracksTraversedSum / (double) (requestQueue.size());       
    }
    
    private void SimProcessSort(ArrayList<SimProcess> ProcessList){
        SimProcess temp;
        int length = ProcessList.size();
        
        for (int i = 0; i < length; i++){
            for (int j = 1; j < (length - i); j++){
                if (ProcessList.get(j - 1).getArrivalTime() > ProcessList.get(j).getArrivalTime()){
                    temp = ProcessList.get(j - 1);
                    ProcessList.set(j - 1, ProcessList.get(j));
                    ProcessList.set(j, temp);
                }
            }
        } 
    }
    
    @Override
    public String toString(){
        return "FIFO: Average seek length is " + avgSeekLength;
    }
    
}
