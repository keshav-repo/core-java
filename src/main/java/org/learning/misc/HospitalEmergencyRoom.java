package org.learning.misc;

import java.util.Objects;
import java.util.PriorityQueue;

class Patient implements Comparable<Patient>{
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient o) {
        return Integer.compare(severity, o.severity)*-1;
    }

    @Override
    public boolean equals(Object object){
        if(this==object)
            return true;
        if(object==null || getClass()!=object.getClass())
            return false;
        Patient patient = (Patient) object;
        return severity == patient.severity;
    }

    @Override
    public int hashCode(){
        return Objects.hash(severity);
    }
}

public class HospitalEmergencyRoom {
    public static void main(String[] args) {
        PriorityQueue<Patient> emergencyRoomQueue = new PriorityQueue<>();

        emergencyRoomQueue.add(new Patient("John doe", 5));
        emergencyRoomQueue.add(new Patient("John Smith", 4));
        emergencyRoomQueue.add(new Patient("Tom Johnson", 3));
        emergencyRoomQueue.add(new Patient("Emily Davis", 2));

        while (!emergencyRoomQueue.isEmpty()){
            Patient patient = emergencyRoomQueue.poll();
            System.out.println("patient name "+ patient.getName()+" severity: "+ patient.getSeverity());
        }
    }
}
