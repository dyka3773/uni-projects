# Introduction
This is a README for the project made by our team for the Operating Systems Design class

## Contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Schedulers](#scheduling-algorithms)
* [Schedulers](#schedulers)
* [Algorithm](#algorithm)

## General info
This project implements a Round Robin CPU scheduler, 4 different disk schedulers and the Priority Queue-ing which handles all the above.

## Technologies
This project was created with:
* Apache NetBeans IDE 12.0
* Java
* JDK 14

The project uses a Command Line UI

## Scheduling Algorithms
* The CPU Schedulers that were used are:
  * Round Robin

* The Disk Schedulers that were used are:
  * FIFO
  * SSTF
  * SCAN
  * C-SCAN

## Schedulers
The interface that was used for the Disk Schedulers are:
  * [Interface DiskScheduler](./scheduler/src/Scheduler/DiskScheduler/DiskScheduler.java)

The classes that were used for the Schedulers are:
  * [Class RoundRobin](./scheduler/src/Scheduler/ProcessScheduler/RoundRobin.java)
  * [Class SSTF](./scheduler/src/Scheduler/DiskScheduler/SSTF.java)
  * [Class FIFO](./scheduler/src/Scheduler/DiskScheduler/FIFO.java)
  * [Class SCAN](./scheduler/src/Scheduler/DiskScheduler/SCAN.java)
  * [Class CSCAN](./scheduler/src/Scheduler/DiskScheduler/CSCAN.java)

## Algorithm
* [Class EntryPoint](./scheduler/src/CLI/EntryPoint.java) contains our main method. An ArrayList object is created, named ``memory``, where inside our “fake” Processes are stored. Then, a PriorityQueue object is created, named ``pq``, and initialized with the ``memory`` ArrayList.

* [Class SimProcess](./scheduler/src/Scheduler/SimProcess.java) contains our “false” Processes. Each SimProcess contains the following attributes: ``name, arrivalTime, burstTime, priority, size, trackAddress, trackAddressHex, needIO`` and a static final attribute for the process’ rank. Also, the appropriate ``getters``, ``setters`` and ``toString`` were added.

* [Class PriorityQueue](./scheduler/src/Scheduler/ProcessScheduler/PriorityQueue.java) implements the queue-ing needed to the processes and their ordering inside the CPU. Attributes ``processesQueue`` and ``blockedQueue``, which both are ArrayLists, are used. ``processesQueue`` is initialized in the constructor of the class with the parameter ``memory`` from EntryPoint and ``blockedQueue`` is filled with SimProcesses that Round Robin found they needed IO. Two methods are used :
  * ``sortQueuesByPriority(ArrayList<SimProcess> memory)`` which gets an ArrayList as a parameter and distributes the SimProcess elements in the ``processesQueue`` arrays according to their ``priority``
  * ``start()``, which initializes a RoundRobin object, named ``scheduler``, asks the user to select a disk scheduler and begins dispensing each priority queue to the ``scheduler``. A  ``blockedQueue`` is returned and the disk scheduler selected starts functioning. Round Robin collects the processes and starts once again. This happens for every priority queue in line.

Schedulers will not be analyzed as they were descriptively taught during the semester.

It must be noted that the program is serialized and is not running both Round Robin and Disk Schedulers simultaneously.


