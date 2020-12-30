package Scheduler.DiskScheduler;
import java.util.ArrayList;
import Scheduler.SimProcess;

public class CSCAN implements DiskScheduler{
    private long headPosition;
    private long seekOperations;
    private ArrayList<SimProcess> processTrackSequence;
    private ArrayList<SimProcess> inputSequence;

    public CSCAN(ArrayList<SimProcess> input) {
        this.inputSequence = input;
        this.headPosition = DISK_SIZE/2;
        this.seekOperations = 0;
    }

    public void start() {
        int distance = 0;
        int currentTrack = 0;
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

        //Serve the requests in the right
        for(int i=0; i<right.size(); i++) {
            currentTrack = (int)right.get(i).getTrackAddress();
            this.processTrackSequence.add(right.get(i));
            distance = (int)Math.abs(currentTrack-this.headPosition);
            this.seekOperations += distance;
            this.headPosition = currentTrack;
        }

        //Set the head position to the first track address
        setHeadPosition(0L);

        //Serve the requests in the left
        for (int i=0; i<left.size(); i++) {
            currentTrack = (int)left.get(i).getTrackAddress();
            this.processTrackSequence.add(left.get(i));
            distance = (int)Math.abs(currentTrack-this.headPosition);
            this.seekOperations += distance;
            this.headPosition = currentTrack;
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
        // Bubble sort implementation for
        for(int i=0; i<sequence.size()-1; i++)
            for(int j=0; j<sequence.size()-i-1; j++)
                if(sequence.get(j).getTrackAddress() < sequence.get(j+1).getTrackAddress())
                    swap(sequence.get(j), sequence.get(j+1));
    }

    @Override
    public String toString() {
        return ("CSCAN Scheduler:\n"
                +"\tProcess Track Address Sequence:\n"
                +"\t"+getProcessTrackSequence()+'\n');
    }
