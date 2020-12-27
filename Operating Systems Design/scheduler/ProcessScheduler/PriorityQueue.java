package Scheduler.ProcessScheduler;
import Scheduler.SimProcess;
import java.util.ArrayList;


public class PriorityQueue {
    private ArrayList<SimProcess> processList;
    private double averageResponseTime;
    private double averageTurnAroundTime;

    public PriorityQueue() {
        this.processList = new ArrayList();
    }
    
    public PriorityQueue(ArrayList<SimProcess> processList) {
        this.processList = processList;
    }
    
    public void addProcess(SimProcess p) {
        this.processList.add(p);
        calculateAverageResponseTime();
        calculateAverageTurnaroundTime();
    }
    
    public void removeProcess(SimProcess p) {
        this.processList.remove(p);
        calculateAverageResponseTime();
        calculateAverageTurnaroundTime();
    }

    @Override
    public String toString() {
        return "PriorityQueue:\n" + "processList=" + processList 
                + "\nAverage Response Time=" + averageResponseTime 
                + " ms\nAverage TurnAround Time=" + averageTurnAroundTime + " ms\n";
    }
    
    public void calculateAverageResponseTime() {
        double r = 0;
        for (SimProcess p: this.processList) {
            r = r + p.getBurstTime();
        }
        this.averageResponseTime = r/this.processList.size();
    }
    
    public void calculateAverageTurnaroundTime() {
        double t = 0;
        for (SimProcess p: this.processList) {
            t = p.getBurstTime() + p.getArrivalTime();
        }
        this.averageTurnAroundTime = t/this.processList.size();
    }
    
    private void swap(ArrayList<SimProcess> arr, int i, int j) {
        SimProcess temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    } 
    
    // Quick sort implementation to compare by arrival time or priority
    private int partition(int low, int high) {
        int pivotArrivalTime = this.processList.get(high).getArrivalTime();
        int pivotPriority = this.processList.get(high).getPriority();
        int i = low-1;
        for(int j=low; j<high; j++) {
            // If arrival times are the same, then sort by priority
            if (this.processList.get(j).getArrivalTime() == pivotArrivalTime) {
                if (this.processList.get(j).getPriority() < pivotPriority) {
                    i++;
                    swap(this.processList, i, j);
                }
            // Else sort by arrival time
            } else if (this.processList.get(j).getArrivalTime() < pivotArrivalTime) {
                i++;
                swap(this.processList, i, j);
            }
        }
        swap(this.processList, i+1, high);
        return i+1;
    }
    
    public void sortProcesses(int low, int high) {
        // Check if no processes are loaded
        // If not, exit, else, continue with scheduling.
        if (this.processList.isEmpty()) {
            System.err.print("The list is empty. "
                    + "No processes have been loaded.\n");
            System.exit(1);
        }
        if (low < high) {
            int pi = partition(low, high);
            sortProcesses(low, pi-1);
            sortProcesses(pi+1, high);
        }
    }
    
    public int size() {
        return this.processList.size();
    }
    
    public double getAverageResponseTime() {
        return averageResponseTime;
    }

    public double getAverageTurnAroundTime() {
        return averageTurnAroundTime;
    }
}

