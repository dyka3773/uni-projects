package Scheduler.ProcessScheduler;
import Scheduler.DiskScheduler.CSCAN;
import Scheduler.DiskScheduler.FIFO;
import Scheduler.DiskScheduler.SCAN;
import Scheduler.DiskScheduler.SSTF;
import Scheduler.SimProcess;
import java.util.ArrayList;
import java.util.Scanner;


public class PriorityQueue {
    private ArrayList<ArrayList<SimProcess>> processesQueue;
    private ArrayList<SimProcess> memory;
    private ArrayList<SimProcess> blockedQueue;

    public PriorityQueue(ArrayList<SimProcess> memory) {
        this.processesQueue = new ArrayList(SimProcess.PRIORITIES-1);
        this.memory = memory;
        for(int i=0; i<5; i++)
            processesQueue.add(new ArrayList());
    }
    
    public void start() {
        RoundRobin scheduler = new RoundRobin();
        int diskSelection = 0;
        System.out.print("Selection:\n1.\tSCAN\n2.\tC-SCAN\n3.\tFIFO\n4.\tSSTF\n"
                + "Your selection: ");
        do {
            Scanner input = new Scanner(System.in);
            diskSelection = input.nextInt();
        }while(diskSelection < 1 || diskSelection > 4);
        
        for(int i=0; i<SimProcess.PRIORITIES; i++) {
            sortQueuesByPriority();
            
            System.out.println("Round Robin's Current Process Queue: \n" + processesQueue.get(i).toString());
            blockedQueue = scheduler.start(processesQueue.get(i));
            System.out.println("Round Robin's Blocked Queue:\n" + blockedQueue.toString());
            
            switch(diskSelection) {
                case 1: 
                    SCAN SCANScheduler = new SCAN(blockedQueue, SCAN.Direction.LEFT);
                    System.out.println("Disk head position: "+ SCANScheduler.getHeadPosition()
                    + "\nDisk sequence:\n" + SCANScheduler.getSeekSequence());
                    break;
                case 2: CSCAN CSCANScheduler = new CSCAN(blockedQueue);
                        System.out.println("Disk head position: "+ CSCANScheduler.getHeadPosition() 
                        + "\nDisk sequence:\n" + CSCANScheduler.getSeekSequence());
                        break;
                //case 3: FIFO FIFOScheduler = new FIFO(blockedQueue);
                //        System.out.println("Disk head position: "+ FIFOScheduler.getHeadPosition() 
                //        + "\nDisk sequence:\n" + CSCANScheduler.getSeekSequence());
                //        break;
                //case 4: SSTF SSTFScheduler = new SSTF();
                //        System.out.println("Disk head position: "+ SSTFScheduler.getHeadPosition() 
                //        + "\nDisk sequence:\n" + CSCANScheduler.getSeekSequence());
                //        break;
            }
            
            blockedQueue = scheduler.start(blockedQueue);
            System.out.println("Round Robin's Blocked Queue:\n" + blockedQueue.toString());
            
            System.out.print("<Press ENTER>\n");
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
        }
        
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

