package Scheduler.DiskScheduler;
import java.util.ArrayList;
import Scheduler.SimProcess;
public class CSCAN {
    public static final long DISK_SIZE = 2097152L; //That's 1GB in bytes.
    public static final long MBYTES = 1048576L;
    private ArrayList<SimProcess> seekSequence;
    private long seekOps;
    private long headPosition = this.DISK_SIZE/2;

    public CSCAN(ArrayList<SimProcess> sequence) {
        int seekOps = 0;
        int distance, currentTrack;
        ArrayList<SimProcess> left = new ArrayList(), right = new ArrayList();
        this.seekSequence = new ArrayList();
        
        for(int i=0; i<sequence.size(); i++) {
            if (sequence.get(i).getTrackAddress() < this.headPosition)
                left.add(sequence.get(i));
            else
                right.add(sequence.get(i));
        }

        sortByTrack(left);
        sortByTrack(right);

        //Serve the requests in the right
        for(int i=0; i<right.size(); i++) {
            currentTrack = (int)right.get(i).getTrackAddress();
            this.seekSequence.add(right.get(i));
            distance = (int)Math.abs(currentTrack-this.headPosition);
            this.seekOps += distance;
            this.headPosition = currentTrack;
        }
        this.headPosition = 0;
        //Serve the requests in the left
        for (int i=0; i<left.size(); i++) {
            currentTrack = (int)left.get(i).getTrackAddress();
            this.seekSequence.add(left.get(i));
            distance = (int)Math.abs(currentTrack-this.headPosition);
            this.seekOps += distance;
            this.headPosition = currentTrack;
        }
        for(SimProcess p: seekSequence)
            p.setIO(false);
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
    
    public String getHeadPosition() {
        return Integer.toString((int)this.headPosition);
    }
}
