package searchingSortingDataStructures;

import java.util.*;

public class HitterHeapExample {

    public static void main(String[] args) {
        Hitter[] hitters = new Hitter[]{
                new Hitter("A", 30),
                new Hitter("B", 10),
                new Hitter("C", 40),
                new Hitter("D", 20),
        };

        // Create a min heap
        PriorityQueue<Hitter> minHeap = new PriorityQueue<>(Comparator.comparingInt(Hitter::getFreq));
        for (Hitter hitter : hitters) {
            minHeap.add(hitter);
        }

//        List<Hitter> minResult = new ArrayList<>();
//        while(minHeap.size()> 0)    minResult.add(minHeap.peek());

        // Print the min heap
        System.out.println("Min Heap:");
        minHeap.forEach(hitter -> System.out.println("ID: " + hitter.getId() + ", Frequency: " + hitter.getFreq()));

        // Create a max heap
        PriorityQueue<Hitter> maxHeap = new PriorityQueue<>(Comparator.comparingInt(Hitter::getFreq).reversed());
        for (Hitter hitter : hitters) {
            maxHeap.add(hitter);
        }

//
//        List<Hitter> maxResult = new ArrayList<>();
//        while(maxHeap.size()> 0)    maxResult.add(maxHeap.peek());

        // Print the max heap
        System.out.println("Max Heap:");
        maxHeap.forEach(hitter -> System.out.println("ID: " + hitter.getId() + ", Frequency: " + hitter.getFreq()));
    }
}

class Hitter {
    private String id;
    private int freq;

    public Hitter(String id, int freq) {
        this.id = id;
        this.freq = freq;
    }

    public String getId() {
        return id;
    }

    public int getFreq() {
        return freq;
    }
}

