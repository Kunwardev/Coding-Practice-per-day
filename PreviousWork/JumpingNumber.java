/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.Misc;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DEV
 */
public class JumpingNumber {
    
    private static void function(int num, int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            int extract = q.poll();
            if(extract <= num){
                System.out.print(extract+" ");
                int last_digit = extract % 10;
                if(last_digit == 0){
                    q.add(extract*10+(last_digit+1));
                } else if(last_digit == 9){
                    q.add(extract*10+(last_digit-1));
                } else{
                    q.add(extract*10+(last_digit+1));
                    q.add(extract*10+(last_digit-1));
                }
            }
        }
    }
    
    public static void printJumping(int num){
        System.out.print("0 ");
        for(int i=1;i<=9 && i<num ;i++){
            function(num, i);
        }
    }
    
    public static void main(String[] args) {
        printJumping(40);
    }
    
}
