package Scheduler;

import Scheduler.DiskScheduler.SCAN;
import java.util.Random;

public class SimProcess {
    private String name;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private long size; // Size in bytes
    private long trackAddress;
    private String trackAddressHex = "0x0";
    private boolean needsIO = false;
    public static final int PRIORITIES = 5;

    public SimProcess(String name, int arrivalTime, int burstTime, int priority,
            long size, long trackAddress) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.size = size;
        this.trackAddress = trackAddress;
    }
    
    public SimProcess(String name) {
        this.name = name;
        this.arrivalTime = (int)(Math.random()* 50);
        this.burstTime = (int)(Math.random()* 50);
        this.priority = (int)(Math.random()* SimProcess.PRIORITIES);
        this.size = (long)(Math.random()* SCAN.MBYTES);
        this.trackAddress = (int)(Math.random()* SCAN.DISK_SIZE);
        this.needsIO = new Random().nextBoolean();
    }

    public String getName() {
        return name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public double getSize() {
        return size;
    }

    public long getTrackAddress() {
        return trackAddress;
    }

    @Override
    public String toString() {
        return "\nProcess:" + "\n\tPID: " + name + "\n\tArrival Time: " + arrivalTime 
                + "\n\tBurst Time: " + burstTime + " ms\n\tPriority: " + priority 
                + "\n\tSize: " + size + " Bytes"
                + "\n\tDisk Address: " + trackAddress
                + "\n\tDisk Address (in Hex): " + trackAddressHex 
                + Integer.toHexString((int)trackAddress )
                + "\n\tNeeds IO: " + needsIO + '\n';
    }
}
