package Scheduler;

import Scheduler.ProcessScheduler.PriorityQueue;
import Scheduler.DiskScheduler.SCAN;
import java.util.ArrayList;

public class Sandbox {
    public static void main(String[] args) {
        
        ArrayList<SimProcess> p = new ArrayList(5);
        SimProcess p1 = new SimProcess("P1", 0, 11, 2, 45, 11);
        SimProcess p2 = new SimProcess("P2", 0, 28, 0, 1024, 34);
        SimProcess p3 = new SimProcess("P3", 12, 2, 3, 95, 92);
        SimProcess p4 = new SimProcess("P4", 2, 10, 1, 103, 120);
        SimProcess p5 = new SimProcess("P5", 19, 16, 4, 2048, 79);
        
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        
        // SCAN s;
        // s = new SCAN(p, SCAN.Direction.LEFT);
        // System.out.println(s.toString());
        PriorityQueue pq = new PriorityQueue(p);
        System.out.println(pq.toString());
        pq.sortProcesses(0, pq.size()-1);
        System.out.println(pq.toString());
        
    }
}
