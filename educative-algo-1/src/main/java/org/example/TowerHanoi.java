package org.example;

public class TowerHanoi {

    public static void hanoi(int disks, char source,char destination,char temp){
        if (disks == 0) return;
        else {
            hanoi(disks-1,source, temp, destination);
            System.out.println("Moving disk " + disks + " from " + source + " to " + destination);
            hanoi(disks-1,temp, destination,source);
        }

    }
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }
}
