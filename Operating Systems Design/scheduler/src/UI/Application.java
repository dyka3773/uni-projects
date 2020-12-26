package UI;
import Scheduler.SCAN;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import Scheduler.*;
class Application extends javax.swing.JFrame {
    ArrayList<SimProcess> processes = new ArrayList(15);
    public Application() {
        SimProcess p1 = new SimProcess("P1", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p2 = new SimProcess("P2", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p3 = new SimProcess("P3", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p4 = new SimProcess("P4", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p5 = new SimProcess("P5", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p6 = new SimProcess("P6", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p7 = new SimProcess("P7", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p8 = new SimProcess("P8", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p9 = new SimProcess("P9", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p10 = new SimProcess("P10", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p11 = new SimProcess("P11", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p12 = new SimProcess("P12", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p13 = new SimProcess("P13", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p14 = new SimProcess("P14", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        SimProcess p15 = new SimProcess("P15", (int)(Math.random()* 50), 
                (int)(Math.random()* 50), (int)(Math.random()* 25),
                (long)(Math.random()* SCAN.MBYTES),
                (long)(Math.random()* SCAN.DISK_SIZE));
        
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        Log = new javax.swing.JTextArea();
        tabbedPane = new javax.swing.JTabbedPane();
        processesTab = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        processList = new javax.swing.JList<>();
        addProcessToSelectedListButton = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        listModel = new DefaultListModel();
        selectedProcesses = new javax.swing.JList(listModel);
        loadToDiskButton = new javax.swing.JButton();
        clearDiskButton = new javax.swing.JButton();
        diskSchedulerTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        diskList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        diskSelectedTextbox = new javax.swing.JTextField();
        selectDiskButton = new javax.swing.JToggleButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        diskAlgorithmInfo = new javax.swing.JTextArea();
        processSchedulerTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        schedulerList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        schedulerSelectedTextbox = new javax.swing.JTextField();
        selectSchedulerButton = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        schedulerAlgorithmInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scheduler Simulator");
        setPreferredSize(new java.awt.Dimension(1920, 900));
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 900));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        Log.setEditable(false);
        Log.setBackground(new java.awt.Color(0, 0, 0));
        Log.setColumns(30);
        Log.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Log.setForeground(new java.awt.Color(255, 255, 255));
        Log.setLineWrap(true);
        Log.setRows(5);
        Log.setWrapStyleWord(true);
        Log.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operations Log", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        Log.setCaretColor(new java.awt.Color(255, 255, 255));
        Log.setName("Operations Log"); // NOI18N
        jScrollPane1.setViewportView(Log);

        getContentPane().add(jScrollPane1);

        processesTab.setLayout(new java.awt.GridBagLayout());

        jScrollPane6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Processes List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 0, 12))); // NOI18N

        processList.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        processList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13", "P14", "P15" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        processList.setMaximumSize(new java.awt.Dimension(150, 270));
        processList.setMinimumSize(new java.awt.Dimension(150, 270));
        processList.setPreferredSize(new java.awt.Dimension(150, 270));
        jScrollPane6.setViewportView(processList);

        processesTab.add(jScrollPane6, new java.awt.GridBagConstraints());

        addProcessToSelectedListButton.setText("Add to Disk");
        addProcessToSelectedListButton.setMaximumSize(new java.awt.Dimension(147, 23));
        addProcessToSelectedListButton.setMinimumSize(new java.awt.Dimension(147, 23));
        addProcessToSelectedListButton.setPreferredSize(new java.awt.Dimension(147, 23));
        addProcessToSelectedListButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addProcessToSelectedListButtonMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        processesTab.add(addProcessToSelectedListButton, gridBagConstraints);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selected Processes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 0, 12))); // NOI18N

        selectedProcesses.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        selectedProcesses.setMaximumSize(new java.awt.Dimension(150, 270));
        selectedProcesses.setMinimumSize(new java.awt.Dimension(150, 270));
        selectedProcesses.setPreferredSize(new java.awt.Dimension(150, 270));
        jScrollPane7.setViewportView(selectedProcesses);

        processesTab.add(jScrollPane7, new java.awt.GridBagConstraints());

        loadToDiskButton.setText("Load to Disk");
        loadToDiskButton.setMaximumSize(new java.awt.Dimension(147, 23));
        loadToDiskButton.setMinimumSize(new java.awt.Dimension(147, 23));
        loadToDiskButton.setPreferredSize(new java.awt.Dimension(147, 23));
        loadToDiskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loadToDiskButtonMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        processesTab.add(loadToDiskButton, gridBagConstraints);

        clearDiskButton.setText("Clear Selected Proceses");
        clearDiskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearDiskButtonMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        processesTab.add(clearDiskButton, gridBagConstraints);

        tabbedPane.addTab("Processes Selection", processesTab);

        diskSchedulerTab.setLayout(new java.awt.GridBagLayout());

        diskList.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        diskList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "SCAN (Elevator) Disk Scheduler", "C-SCAN Disk Scheduler", "Shortest Seek Time First Disk Scheduler" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        diskList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                diskListMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(diskList);

        diskSchedulerTab.add(jScrollPane2, new java.awt.GridBagConstraints());

        jLabel1.setText("Algorithm Selected:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        diskSchedulerTab.add(jLabel1, gridBagConstraints);

        diskSelectedTextbox.setEditable(false);
        diskSelectedTextbox.setColumns(40);
        diskSelectedTextbox.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        diskSelectedTextbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diskSelectedTextboxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        diskSchedulerTab.add(diskSelectedTextbox, gridBagConstraints);

        selectDiskButton.setText("Load Disk Scheduler Algorithm");
        selectDiskButton.setEnabled(false);
        selectDiskButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectDiskButtonMousePressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        diskSchedulerTab.add(selectDiskButton, gridBagConstraints);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algorithm Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 0, 11))); // NOI18N

        diskAlgorithmInfo.setEditable(false);
        diskAlgorithmInfo.setColumns(60);
        diskAlgorithmInfo.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        diskAlgorithmInfo.setLineWrap(true);
        diskAlgorithmInfo.setRows(20);
        diskAlgorithmInfo.setTabSize(4);
        jScrollPane4.setViewportView(diskAlgorithmInfo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        diskSchedulerTab.add(jScrollPane4, gridBagConstraints);

        tabbedPane.addTab("Disk Scheduler Selection", diskSchedulerTab);

        processSchedulerTab.setLayout(new java.awt.GridBagLayout());

        schedulerList.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        schedulerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Priority Queue Scheduler", "Round Robin Scheduler", "First In First Out Scheduler" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        schedulerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                schedulerListMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(schedulerList);

        processSchedulerTab.add(jScrollPane3, new java.awt.GridBagConstraints());

        jLabel3.setText("Algorithm Selected:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        processSchedulerTab.add(jLabel3, gridBagConstraints);

        schedulerSelectedTextbox.setEditable(false);
        schedulerSelectedTextbox.setColumns(40);
        schedulerSelectedTextbox.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        processSchedulerTab.add(schedulerSelectedTextbox, gridBagConstraints);

        selectSchedulerButton.setText("Load Process Scheduler Algorithm");
        selectSchedulerButton.setEnabled(false);
        selectSchedulerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                selectSchedulerButtonMousePressed(evt);
            }
        });
        selectSchedulerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectSchedulerButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        processSchedulerTab.add(selectSchedulerButton, gridBagConstraints);

        jScrollPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Algorithm Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 0, 11))); // NOI18N

        schedulerAlgorithmInfo.setColumns(60);
        schedulerAlgorithmInfo.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        schedulerAlgorithmInfo.setLineWrap(true);
        schedulerAlgorithmInfo.setRows(20);
        schedulerAlgorithmInfo.setTabSize(4);
        jScrollPane5.setViewportView(schedulerAlgorithmInfo);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        processSchedulerTab.add(jScrollPane5, gridBagConstraints);

        tabbedPane.addTab("Process Schedulers Selection", processSchedulerTab);

        getContentPane().add(tabbedPane);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diskSelectedTextboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diskSelectedTextboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diskSelectedTextboxActionPerformed

    private void selectSchedulerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectSchedulerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectSchedulerButtonActionPerformed

    private void diskListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diskListMousePressed
        // TODO add your handling code here:
        String option = diskList.getSelectedValue();
        if (option.equals("SCAN (Elevator) Disk Scheduler")) {
            selectDiskButton.setEnabled(true);
            diskAlgorithmInfo.setText("In SCAN disk scheduling algorithm, "
                    + "head starts from one end of the disk and moves towards the other end, "
                    + "servicing requests in between one by one and reach the other end. "
                    + "Then the direction of the head is reversed and the process "
                    + "continues as head continuously scan back and forth to access the disk. "
                    + "So, this algorithm works as an elevator and hence also known as the elevator algorithm. "
                    + "As a result, the requests at the midrange are serviced "
                    + "more and those arriving behind the disk arm will have to wait.");
        } else if (option.equals("C-SCAN Disk Scheduler")) {
            selectDiskButton.setEnabled(true);
            selectDiskButton.setEnabled(true);
            diskAlgorithmInfo.setText("Circular SCAN (C-SCAN) scheduling algorithm "
                    + "is a modified version of SCAN disk scheduling algorithm "
                    + "that deals with the inefficiency of SCAN algorithm by "
                    + "servicing the requests more uniformly. Like SCAN (Elevator Algorithm) "
                    + "C-SCAN moves the head from one end servicing all the requests to the other end. "
                    + "However, as soon as the head reaches the other end, "
                    + "it immediately returns to the beginning of the disk "
                    + "without servicing any requests on the return trip (see chart below) "
                    + "and starts servicing again once reaches the beginning. "
                    + "This is also known as the “Circular Elevator Algorithm” "
                    + "as it essentially treats the cylinders as a circular list"
                    + " that wraps around from the final cylinder to the first one.");
        } else if (option.equals("Shortest Seek Time First Disk Scheduler")) {
            selectDiskButton.setEnabled(true);
            selectDiskButton.setEnabled(true);
            diskAlgorithmInfo.setText("This is a direct improvement upon a "
                    + "first-come first-served (FCFS) algorithm. "
                    + "The drive maintains an incoming buffer of requests, "
                    + "and tied with each request is a cylinder number of the request. "
                    + "Lower cylinder numbers indicate that the cylinder is closer to the spindle, "
                    + "while higher numbers indicate the cylinder is farther away. "
                    + "The shortest seek first algorithm determines which request "
                    + "is closest to the current position of the head, "
                    + "and then services that request next.The shortest seek "
                    + "first algorithm has the direct benefit of simplicity and "
                    + "is clearly advantageous in comparison to the FIFO method, "
                    + "in that overall arm movement is reduced, "
                    + "resulting in lower average response time.\n" 
                    +"\n" 
                    +"However, since the buffer is always getting new requests, "
                    + "these can skew the service time of requests that may be "
                    + "farthest away from the disk head's current location, "
                    + "if the new requests are all close to the current location; "
                    + "in fact, starvation may result, "
                    + "with the faraway requests never being able to make progress.");
        }
        Log.setText(Log.getText()+"Selected: " + option + "\n");
    }//GEN-LAST:event_diskListMousePressed

    private void schedulerListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulerListMousePressed
        // TODO add your handling code here:
        String option = schedulerList.getSelectedValue();
        if (option.equals("Priority Queue Scheduler")) {
            selectSchedulerButton.setEnabled(true);
            schedulerAlgorithmInfo.setText("Priority scheduling is a non-preemptive algorithm "
                    + "and one of the most common scheduling algorithms in batch systems. "
                    + "Each process is assigned first arrival time (less arrival time process first) "
                    + "if two processes have same arrival time, then compare to priorities (highest process first). "
                    + "Also, if two processes have same priority then compare "
                    + "to process number (less process number first). "
                    + "This process is repeated while all process get executed.");
        } else if (option.equals("Round Robin Scheduler")) {
            selectSchedulerButton.setEnabled(true);
            schedulerAlgorithmInfo.setText("Round-robin is one of the algorithms "
                    + "employed by process and network schedulers in computing. "
                    + "As the term is generally used, time slices "
                    + "(also known as time quanta) are assigned to each process "
                    + "in equal portions and in circular order, "
                    + "handling all processes without priority (also known as cyclic executive). "
                    + "Round-robin scheduling is simple, easy to implement, "
                    + "and starvation-free.");
        } else if (option.equals("First In First Out Scheduler")) {
            selectSchedulerButton.setEnabled(true);
            schedulerAlgorithmInfo.setText("First in, first out (FIFO), "
                    + "also known as first come, first served (FCFS), "
                    + "is the simplest scheduling algorithm. "
                    + "FIFO simply queues processes in the order that they arrive in the ready queue."
                    + "\nIn this, the process that comes first will be executed first "
                    + "and next process starts only after the previous gets fully executed."
                    + "\nHere we are considering that arrival time for all processes is 0.");
        }
        Log.setText(Log.getText()+"Selected: " + option + "\n");
    }//GEN-LAST:event_schedulerListMousePressed

    private void selectDiskButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectDiskButtonMousePressed
        // TODO add your handling code here:
        String loadedOption = diskList.getSelectedValue();
        diskSelectedTextbox.setText(loadedOption);
        Log.setText(Log.getText()+"Loaded: " + loadedOption + "\n");
        selectDiskButton.setEnabled(false);
    }//GEN-LAST:event_selectDiskButtonMousePressed

    private void selectSchedulerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectSchedulerButtonMousePressed
        // TODO add your handling code here:
        String loadedOption = schedulerList.getSelectedValue();
        schedulerSelectedTextbox.setText(loadedOption);
        Log.setText(Log.getText()+"Loaded: " + loadedOption + "\n");
        selectSchedulerButton.setEnabled(false);
    }//GEN-LAST:event_selectSchedulerButtonMousePressed

    private void addProcessToSelectedListButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProcessToSelectedListButtonMousePressed
        // TODO add your handling code here:
        String selectedProcess = processList.getSelectedValue();
        listModel.addElement(selectedProcess);
        Log.setText(Log.getText()+"Added Process: " + selectedProcess + " to disk\n");
    }//GEN-LAST:event_addProcessToSelectedListButtonMousePressed

    private void clearDiskButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearDiskButtonMousePressed
        // TODO add your handling code here:
        listModel.clear();
        Log.setText(Log.getText()+"Cleared all proceses from the list\n");
    }//GEN-LAST:event_clearDiskButtonMousePressed

    private void loadToDiskButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadToDiskButtonMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loadToDiskButtonMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }
    private DefaultListModel listModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Log;
    private javax.swing.JButton addProcessToSelectedListButton;
    private javax.swing.JButton clearDiskButton;
    private javax.swing.JTextArea diskAlgorithmInfo;
    private javax.swing.JList<String> diskList;
    private javax.swing.JPanel diskSchedulerTab;
    private javax.swing.JTextField diskSelectedTextbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton loadToDiskButton;
    private javax.swing.JList<String> processList;
    private javax.swing.JPanel processSchedulerTab;
    private javax.swing.JPanel processesTab;
    private javax.swing.JTextArea schedulerAlgorithmInfo;
    private javax.swing.JList<String> schedulerList;
    private javax.swing.JTextField schedulerSelectedTextbox;
    private javax.swing.JToggleButton selectDiskButton;
    private javax.swing.JToggleButton selectSchedulerButton;
    private javax.swing.JList<String> selectedProcesses;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
