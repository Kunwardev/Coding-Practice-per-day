/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

/**
 *
 * @author kunwar
 */
public class ShuffleCards {
    
    private static int randomNumber(int lower, int higher){
        return lower +(int) (Math.random()* (higher - lower + 1));
    }
    
    private static int[] function(int[] cards, int i)
    {
        if(i == 0)
            return cards;
        int rand_index = randomNumber(0, i);
        int temp = cards[rand_index];
        cards[rand_index] = cards[i];
        cards[i] = temp;
        return function(cards, i-1);
    }
    
    public static void main(String[] args) {
        int[] cards = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] newCards = function(cards, 9);
        for(int i: newCards){
            System.out.print(i+" ");
        }
    }
    
}
