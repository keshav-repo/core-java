package org.learning.misc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

class Ticket {
    private String priority;
    private String details;

    public Ticket(String priority, String details) {
        this.priority = priority;
        this.details = details;
    }

    public String getPriority() {
        return priority;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priority, details);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() != getClass()) return false;
        Ticket ticket = (Ticket) object;
        return Objects.equals(priority, ticket.priority) && Objects.equals(this.details, ticket.details);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "priority='" + priority + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}

public class CustomerSupport {
    private Deque<Ticket> tickets;
    public CustomerSupport() {
        tickets = new LinkedList<>();
    }

    public void addHighPriorityTicket(Ticket ticket) {
        tickets.addFirst(ticket);
    }

    public void addLowPriorityTicket(Ticket ticket) {
        tickets.addFirst(ticket);
    }

    public Ticket pullTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.pollFirst();
    }

    public static void main(String[] args) {
        CustomerSupport customerSupport = new CustomerSupport();

        customerSupport.addHighPriorityTicket(new Ticket("MEDIUM", "ticket 1"));
        customerSupport.addHighPriorityTicket(new Ticket("HIGH", "ticket 2"));
        customerSupport.addHighPriorityTicket(new Ticket("MEDIUM", "ticket 3"));
        customerSupport.addHighPriorityTicket(new Ticket("MEDIUM", "ticket 4"));
        customerSupport.addHighPriorityTicket(new Ticket("HIGH", "ticket 5"));

        Ticket ticket;
        do {
            ticket = customerSupport.pullTicket();
            System.out.println(ticket);
        } while (ticket != null);
    }
}
