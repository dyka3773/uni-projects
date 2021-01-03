package Scheduler.DiskScheduler;
import Scheduler.SimProcess;
import java.util.ArrayList;

public class FIFO implements DiskScheduler{
    
    private ArrayList<SimProcess> requestQueue;
    private long currentTrack;
    private double avgSeekLength = 0;
    private long tracksTraversedSum;
    private ArrayList<SimProcess> processTrackSequence = new ArrayList<SimProcess>();
    
    public FIFO(ArrayList<SimProcess> ProcessList) {
        requestQueue = ProcessList;
    }
    
    @Override
    public String toString(){
        return "FIFO: Average seek length is " + avgSeekLength;
    }

    @Override
    public void start() {
        tracksTraversedSum = Math.abs(requestQueue.get(0).getTrackAddress() - currentTrack);
        currentTrack = requestQueue.get(0).getTrackAddress();
        processTrackSequence.add(requestQueue.get(0));
        
        for (int i = 1; i < requestQueue.size(); i++){         
            tracksTraversedSum += Math.abs(requestQueue.get(i).getTrackAddress() - currentTrack);
            currentTrack = requestQueue.get(i).getTrackAddress();
            processTrackSequence.add(requestQueue.get(i));
        }
        
        avgSeekLength =  tracksTraversedSum / (double) (requestQueue.size()); 
    }

    @Override
    public String getHeadPosition() {
        return Long.toString(currentTrack);
    }

    @Override
    public void setHeadPosition(long hpos) {
        currentTrack = hpos;
    }

    @Override
    public String getProcessTrackSequence() {
        return processTrackSequence.toString();
    }

    @Override
    public String getSeekOperations() {
        return Long.toString(tracksTraversedSum);
    }

    @Override
    public void setSeekOperations(long sop) {
        tracksTraversedSum = sop;
    }
    
}
