package Scheduler.DiskScheduler;

import Scheduler.SimProcess;
import java.util.ArrayList;

public class SCAN implements DiskScheduler{
    private long headPosition;
    private long seekOperations ;
    private ArrayList<SimProcess> processTrackSequence;
    private ArrayList<SimProcess> inputSequence;
    private Direction direction = Direction.LEFT;

    public SCAN(ArrayList<SimProcess> input, Direction direction) {
        this.inputSequence = input;
        this.headPosition = DISK_SIZE/2;
        this.seekOperations = 0;
        this.direction = direction;
    }

    public SCAN(ArrayList<SimProcess> input) {
        this.inputSequence = input;
        this.headPosition = DISK_SIZE/2;
        this.seekOperations = 0;
        this.direction = Direction.LEFT;
    }

    public enum Direction{
        LEFT,
        RIGHT
    }

    public void start() {
        long distance = 0;
        long currentTrack = 0;
        ArrayList<SimProcess> left = new ArrayList<>();
        ArrayList<SimProcess> right = new ArrayList<>();

        // Initialize the left and right sides of the disk's track sequences
        for(int i=0; i<this.inputSequence.size(); i++) {
            if (this.inputSequence.get(i).getTrackAddress() < this.headPosition)
                left.add(this.inputSequence.get(i));
            else
                right.add(this.inputSequence.get(i));
        }
        
        // Sort the sides
        sortByTrack(left);
        sortByTrack(right);
        
        // Serve the left side first
        // Also run 2 times to serve the right side too
        int run = 2;
        while (run-- > 0) {
            if (this.direction == Direction.LEFT) {
                for (int i=left.size()-1; i>=0; i--) {
                    currentTrack = left.get(i).getTrackAddress();
                    this.processTrackSequence.add(left.get(i));
                    distance = Math.abs(currentTrack-this.headPosition);
                    this.seekOperations += distance;
                    this.headPosition = currentTrack;
                }
                this.direction = Direction.RIGHT;
            } else {
                // Serve the right side
                for (int i=0; i < right.size(); i++) {
                    currentTrack = right.get(i).getTrackAddress();
                    this.processTrackSequence.add(right.get(i));
                    distance = Math.abs(currentTrack-this.headPosition);
                    this.seekOperations += distance;
                    this.headPosition = currentTrack;
                }

                // Set the direction again to 'LEFT'
                direction = Direction.LEFT;
            }
        }

        // After scheduling the processes, they are considered
        // I/O served, so, set their needIO to false.
        for(SimProcess p: this.processTrackSequence)
            p.setIO(false);

        // Also set the head to its initial position
        setHeadPosition(INITIAL_HEAD_POS);
    }
    
    public String getHeadPosition() {
        return Long.toString(this.headPosition);
    }

    public void setHeadPosition(long hpos) {
        this.headPosition = hpos;
    }

    public String getProcessTrackSequence() {
        return this.processTrackSequence.toString();
    }

    public String getSeekOperations() {
        return Long.toString(this.seekOperations);
    }
    
    public void setSeekOperations(long sop) {
        this.seekOperations = sop;
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

    @Override
    public String toString() {
        return ("SCAN Scheduler:\n"
                +"\tProcess Track Address Sequence:\n"
                +"\t"+getProcessTrackSequence()+'\n');
    }
}
