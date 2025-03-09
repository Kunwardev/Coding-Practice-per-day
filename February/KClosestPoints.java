package February;

import java.util.Comparator;
import java.util.PriorityQueue;

class Points{
    public int x;
    public int y;
    public double distance;
    
    public Points(int x, int y){
        this.x = x;
        this.y = y;
        this.distance = Math.sqrt(y*y + x*x);
    }
}

class DistanceComparer implements Comparator<Points>{
    public int compare(Points p1, Points p2){
        if(p1.distance < p2.distance)
            return -1;
        else if(p1.distance > p2.distance)
            return 1;
        return 0;
    }
}

public class KClosestPoints {
    
    public int[][] kClosest(int[][] points, int k) {
        // Your code here
        Points[] p = new Points[points.length];
        PriorityQueue<Points> pq = new PriorityQueue<>(new DistanceComparer());
        for(int i=0;i<points.length;i++){
            p[i] = new Points(points[i][0], points[i][1]);
            pq.add(p[i]);
        }
        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            Points a = pq.remove();
            result[i][0] = a.x;
            result[i][1] = a.y;
        //    System.out.println(a.x + " " + a.y + " "+ a.distance);
        }
        return result;
    }
}