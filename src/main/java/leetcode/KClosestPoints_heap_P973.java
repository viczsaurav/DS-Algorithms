package leetcode;

import java.util.*;

public class KClosestPoints_heap_P973 {
    public int[][] kClosest(int[][] points, int k) {
        //Top k => max/min heap => priority queue

        PriorityQueue<Points> pts = new PriorityQueue<>(
                (a,b)-> b.distance-a.distance
        );

        // Create new array to return for K elements
        int[][] kclosest = new int[k][2];

        for (int[] pt: points){
            Points point = new Points(pt);
            pts.add(point);
        }

        for (int i=0;i<k;i++){
            kclosest[i] = pts.poll().points;
        }
        return kclosest;
    }

    class Points {
        int distance;
        int [] points;

        public Points(int [] point){
            points = point;
            distance = points[0] * points[0] + points[1] * points[1];
        }
    }

    public static void main(String[] args) {

    }
}
