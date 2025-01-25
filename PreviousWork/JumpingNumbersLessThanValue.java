/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure.Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author kunwar
 */
public class JumpingNumbersLessThanValue {
    
    private static void functionHelper(int value, int index){
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);
        while(!q.isEmpty()){
            int poppedElement = q.poll();
            if(poppedElement <= value){
                System.out.print(poppedElement+" ");
                int remainder = poppedElement % 10;
                if(remainder == 0){
                    q.offer(poppedElement * 10 + 1);
                } else if(remainder == 9){
                    q.offer(poppedElement * 10 + 8);
                } else{
                    q.offer(poppedElement * 10 + (remainder + 1));
                    q.offer(poppedElement * 10 + (remainder - 1));
                }
            }
        }
    }
    
    private static void function(int x){
        System.out.print("0 ");
        for(int i=1;i<10 && i<=x;i++){
            functionHelper(x, i);
        }
    }
    
    
    public static void main(String[] args) {
        function(4);
    }
    
}
