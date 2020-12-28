package Scheduler.ProcessScheduler;
import Scheduler.SimProcess;
import java.util.ArrayList;


public class PriorityQueue {
    private ArrayList<ArrayList<SimProcess>> processesQueue;
    private ArrayList<SimProcess> memory;

    public PriorityQueue(ArrayList<SimProcess> memory) {
        this.processesQueue = new ArrayList(SimProcess.PRIORITIES-1);
        this.memory = memory;
        for(int i=0; i<5; i++)
            processesQueue.add(new ArrayList());
    }
    
    public void start() {
        sortQueuesByPriority();
    }
    
    private void sortQueuesByPriority() {
        // Check if no processes are loaded
        // If not, exit, else, continue with scheduling.
        if (this.memory.isEmpty()) {
            System.err.print("The list is empty. "
                    + "No processes have been loaded.\n");
            System.exit(1);
        }
        for(SimProcess p : memory) {
            switch (p.getPriority()) {
                case 0: processesQueue.get(0).add(p);
                        break;
                case 1: processesQueue.get(1).add(p);
                        break;
                case 2: processesQueue.get(2).add(p);
                        break;
                case 3: processesQueue.get(3).add(p);
                        break;
                case 4: processesQueue.get(4).add(p);
                        break;
            }
        }
    }
    
    public void printProcessQueues() {
        processesQueue.forEach(i -> {
            System.out.println(i.toString());
        });
    }
    
    public void printProcessQueuesIndex(int index) {
        try {
            System.out.println(processesQueue.get(index).toString());
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("Error: Index is out of bounds!\n"
            +"Info: Index of ArrayList: " + processesQueue.size());
        }
    }
}

