# TicketMachine
TicketMachine  (2023 -2024)

## Introduction
## The coursework involves modelling a ticketing system using FSP (Finite State Processes) andimplementing it in Java with appropriate concurrency features. The system consists of a shared TicketMachine used by passengers and serviced by two technicians. The coursework is divided into threeparts

# Part 1 FSP1. 

**1. Develop FSP Processes**

- Develop FSP processes to model the Ticket Machine, Passengers, and Technicians.
- Utilize the FSP Process Composition Analysis & Design Form for the FSP process composition of thecomplete parallel system.
- Incrementally develop the system using the LTSA tool.
- Ensure the FSP model remains within the LTSA tool's state limits.

**2. Translate FSP to Java:**

- Translate the abstract FSP program into a multi-threaded Java program.
- Implement Java classes corresponding to the FSP processes, ensuring appropriatesynchronization.
- Use threads, thread groups, and monitors for concurrency. Do not use semaphores,or other explicit synchronization mechanisms

**3. Documentation**
- Provide screenshots of the FSP model in the LTSA tool.
- Include an example output from the Java program.

# **Develop the following FSP processes**

**(a) Ticket Machine Process**
- Initialize with 3 tickets.
- Allow printing if paper is available.
- Printing procedure includes mutual exclusion.
- Refill paper when it runs out.

**(b) Passenger Process**
- Initialize with the number of tickets to print.
- Take mutual exclusive control of the Ticket Machine to print tickets.
- Terminate after printing all tickets.

**(c) Ticket Technician Process**
- Repeatedly check if the Ticket Machine is out of paper.
- Refill the Ticket Machine with paper when necessary.

**(d) Toner Technician Process**
- Repeatedly check if the Ticket Machine is out of toner.
- Refill the Ticket Machine with toner when necessary.

**(e) Purchase Ticket System**
- Combine instances of Ticket Machine, Passengers, and Technicians in parallel.
- Ensure mutual exclusive access to the Ticket Machine during operations.

# Part 2 Java Implementation of the FSP Mode

**(1) TicketMachine Class**
- Implement the ServiceTicketMachine interface.
- Use the Ticket class for representing tickets.
- Manage ticket paper and toner levels, allowing printing tickets and refilling.
- Implement the monitor pattern to ensure mutual exclusion.

**(2) Passenger Class**
- Represent a passenger purchasing and printing tickets.
- Utilize the Ticket class for ticket information.
- Use random sleep intervals between printing requests.

**(3) TicketPaperTechnician Class**
- Represent a paper technician refilling the Ticket Machine.
- Attempt to refill paper three times with random sleep intervals.

**(4) TicketTonerTechnician Class**
- Represent a toner technician replacing the Ticket Machine's toner cartridge.
- Attempt toner replacement three times with random sleep intervals.

**(5) TicketPrintingSystem** 
- Coordinate all components, including Ticket Machine, Passengers, and Technicians.
- Create necessary threads and thread groups.
- Ensure all threads complete execution before printing the final Ticket Machine status
