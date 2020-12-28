package CLI;
import Scheduler.ProcessScheduler.PriorityQueue;
import Scheduler.SimProcess;
import java.util.ArrayList;

public class EntryPoint {
    public static void main(String[] args) {

        ArrayList<SimProcess> memory = new ArrayList();
        for(int i=1; i<101; i++)
            memory.add(new SimProcess("P"+i));
        
        PriorityQueue pq = new PriorityQueue(memory);
        pq.start();
        pq.printProcessQueues();
        pq.printProcessQueuesIndex(5);
    }
}
