/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;
import java.util.Stack;
/**
 *
 * The stock span problem is a financial problem where we have a series of n daily
 * price quotes for a stock and we need to calculate span of stock’s price for all n days.
    The span Si of the stock’s price on a given day i is defined as the maximum number 
* of consecutive days just before the given day, for which the price of the stock on
* the current day is less than or equal to its price on the given day.
 *
 */
public class StockSpan {
    
    private static void function(int[] price, int[] S){
        S[0] = 1;
        int length = price.length;
        for(int i=1;i<length;i++){
            S[i] = 1;
            for(int j=i-1;j>=0;j--){
                if(price[j] > price[i])
                    break;
                else{
                    S[i]++;
                }
            }
        }
    }
    
    private static void functionEfficient(int[] price, int[] S){
        S[0] = 1;
        int length = price.length;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int j=1;j<length;j++){
            while(!s.isEmpty() && price[s.peek()] <= price[j]){
                s.pop();
            }
            S[j] = s.isEmpty() ? (j+1) : (j - s.peek());
            s.push(j);
        }
    }
    
    public static void main(String[] args) {
        int[] price = new int[] { 10, 4, 5, 90, 120, 80 };
        int length = price.length;
        int[] S = new int[length];
        function(price, S);
        for(int i: S){
            System.out.print(i+" ");
        }
        int[] T = new int[length];
        functionEfficient(price, T);
        System.out.println();
        for(int p: T){
            System.out.print(p+" ");
        }
    }
    
}
