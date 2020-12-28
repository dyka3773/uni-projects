package CLI;

import Scheduler.DiskScheduler.SCAN;
import Scheduler.SimProcess;
import java.util.ArrayList;

public class EntryPoint {
    public static void main(String[] args) {

        ArrayList<SimProcess> sequence = new ArrayList();
        for(int i=1; i<101; i++)
            sequence.add(new SimProcess("P"+i));
        
        
        SCAN s = new SCAN(sequence, SCAN.Direction.LEFT);
        System.out.println(sequence.toString()+'\n'+s.toString());
    }
}
