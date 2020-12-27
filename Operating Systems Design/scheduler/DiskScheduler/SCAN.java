package Scheduler.DiskScheduler;

import Scheduler.SimProcess;
import java.util.ArrayList;
import java.util.Collections;

public class SCAN {
    public static final long DISK_SIZE = 2097152L; //That's 2MB in bytes.
    public static final long MBYTES = 1048576L;
    private ArrayList<Long> seekSequence;
    private Long seekOps;

    public enum Direction{
        LEFT,
        RIGHT
    }

    public SCAN(ArrayList<SimProcess> sequence, Direction direction) {
        this.seekOps = 0L;
        long distance, currentTrack;
        ArrayList<Long> left = new ArrayList(), right = new ArrayList();
        this.seekSequence = new ArrayList();
        long head = DISK_SIZE/2;
        
        if(direction == Direction.LEFT)
            left.add(0L);
        else
            right.add(this.getSize()-1);
        
        for(int i=0; i<sequence.size(); i++) {
            if (sequence.get(i).getTrackAddress() < head)
                left.add(sequence.get(i).getTrackAddress());
            else
                right.add(sequence.get(i).getTrackAddress());
        }
        Collections.sort(left);
        Collections.sort(right);
        
        int run = 2;
        while (run-- > 0) {
            if (direction == Direction.LEFT) {
                for (int i=left.size()-1; i>=0; i--) {
                    currentTrack = left.get(i);
                    this.seekSequence.add(currentTrack);
                    distance = Math.abs(currentTrack-head);
                    seekOps += distance;
                    head = currentTrack;
                }
                direction = Direction.RIGHT;
            } else if (direction == Direction.RIGHT) {
                for (int i=0; i < right.size(); i++) {
                    currentTrack = right.get(i);
                    this.seekSequence.add(currentTrack);
                    distance = Math.abs(currentTrack-head);
                    seekOps += distance;
                    head = currentTrack;
                }
                direction = Direction.LEFT;
            }
        }
    }
    
    public long getSize() {
        return DISK_SIZE;
    }

    public ArrayList<Long> getSeekSequence() {
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
    
    
}
