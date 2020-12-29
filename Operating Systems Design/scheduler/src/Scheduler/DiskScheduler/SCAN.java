package Scheduler.DiskScheduler;

import Scheduler.SimProcess;
import java.util.ArrayList;
import java.util.Collections;

public class SCAN {
    public static final long DISK_SIZE = 2097152L; //That's 2MB in bytes.
    public static final long MBYTES = 1048576L;
    private ArrayList<SimProcess> seekSequence;
    private Long seekOps;
    private long headPosition = this.DISK_SIZE-1;

    public SCAN(ArrayList<SimProcess> sequence, Direction direction) {
        this.seekOps = 0L;
        long distance, currentTrack;
        ArrayList<SimProcess> left = new ArrayList(), right = new ArrayList();
        this.seekSequence = new ArrayList();
        
        /*
        if(direction == Direction.LEFT)
            left.add(null);
        else
            right.add(null);
        */
        
        for(int i=0; i<sequence.size(); i++) {
            if (sequence.get(i).getTrackAddress() < this.headPosition)
                left.add(sequence.get(i));
            else
                right.add(sequence.get(i));
        }
        
        sortByTrack(left);
        sortByTrack(right);
        
        int run = 2;
        while (run-- > 0) {
            if (direction == Direction.LEFT) {
                for (int i=left.size()-1; i>=0; i--) {
                    currentTrack = left.get(i).getTrackAddress();
                    this.seekSequence.add(left.get(i));
                    distance = Math.abs(currentTrack-this.headPosition);
                    seekOps += distance;
                    this.headPosition = currentTrack;
                }
                direction = Direction.RIGHT;
            } else if (direction == Direction.RIGHT) {
                for (int i=0; i < right.size(); i++) {
                    currentTrack = right.get(i).getTrackAddress();
                    this.seekSequence.add(right.get(i));
                    distance = Math.abs(currentTrack-this.headPosition);
                    seekOps += distance;
                    this.headPosition = currentTrack;
                }
                direction = Direction.LEFT;
            }
        }
        for(SimProcess p: seekSequence)
            p.setIO(false);
    }

    public enum Direction{
        LEFT,
        RIGHT
    }
    
    private void swap(SimProcess p1, SimProcess p2) {
        SimProcess temp = p1;
        p1 = p2;
        p2 = temp;
    }
    
    private void sortByTrack(ArrayList<SimProcess> sequence) {
        for(int i=0; i<sequence.size()-1; i++)
            for(int j=0; j<sequence.size()-i-1; j++)
                if(sequence.get(j).getTrackAddress() < sequence.get(j+1).getTrackAddress())
                    swap(sequence.get(j), sequence.get(j+1));
    }
    
    public long getSize() {
        return DISK_SIZE;
    }

    public ArrayList<SimProcess> getSeekSequence() {
        return seekSequence;
    }

    public Long getSeekOps() {
        return seekOps;
    }

    @Override
    public String toString() {
        return "SCAN:" + "\n\tDisk Size: " + (double)DISK_SIZE/this.MBYTES + " MB"
                + "\n\tSeek Sequence List: " + seekSequence 
                + "\n\tSeek Operations: " + seekOps + '\n';
    }
    
    public void printHeadPosition() {
        System.out.println(this.headPosition);
    }
    
}
