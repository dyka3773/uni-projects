package Scheduler.DiskScheduler;

interface DiskScheduler {
    // Class const keywords
    public static final long DISK_SIZE        = 2097152L;
    public static final long MEGABYTES        = 1048576L;
    public static final long INITIAL_HEAD_POS = DISK_SIZE/2;
    // Class methods
    public void   start();
    public String getHeadPosition();
    public void   setHeadPosition(long hpos);
    public String getProcessTrackSequence();
    public String getSeekOperations();
    public void   setSeekOperations(long sop);
}
