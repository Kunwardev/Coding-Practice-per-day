/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

/**
 *
 * @author kunwar
 */
public class NearestPetrolPumpToCoverDistance 
{ 
	// A petrol pump has petrol and distance to next petrol pump 
    static class petrolPump 
    { 
            int petrol; 
            int distance; 

            // constructor 
            public petrolPump(int petrol, int distance) 
            { 
                    this.petrol = petrol; 
                    this.distance = distance; 
            } 
    } 

    private static int function(petrolPump[] arr, int n){
        int[] nextDistance = new int[n];
        for(int i=0; i<n; i++){
            nextDistance[i] = arr[i].petrol - arr[i].distance;
        }
        int init = 0, start = 0, end = 0, sum = 0;
        boolean allNegatives = true;
        for(int i=0; i<n; i++){
            if(nextDistance[i] >= 0){
                init = i;
                start = init;
                end = (init+1)%n;
                allNegatives = false;
                break;
            }
        }
        if(allNegatives)
            return -1;
        while(start != end || sum < 0 ){
            while(sum < 0 && start != end){
                sum -= nextDistance[start];
                start = (start + 1 ) % n;
                if(start == init)
                    return -1;
            }
            sum += nextDistance[end];
            end = (end + 1) % n;
        }
        return end;
    }

    public static void main(String[] args) {
        petrolPump[] arr = {new petrolPump(6, 4), 
                            new petrolPump(3, 6), 
                            new petrolPump(7, 3)}; 
        System.out.println(function(arr, 3));
    }
        
}
