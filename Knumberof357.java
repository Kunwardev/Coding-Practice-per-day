/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview;

/**
 *
 * @author kunwar
 */
public class Knumberof357 {
    
    private static int function(int number){
    int[] Number = new int[150];
    int five,seven,three,nextNumber = 0;
    five=seven=three=0;
    Number[0]=1;

    for(int i=1;i<number;i++){
            nextNumber=Math.min(Number[three] * 3, Math.min(Number[five] * 5, Number[seven] * 7));
            if(nextNumber==Number[five]*5)
                five++;
            if(nextNumber==Number[seven]*7)
                seven++;
            if(nextNumber==Number[three]*3)
                three++;
            Number[i]=nextNumber;
    }
    return nextNumber;
    }
    
    public static void main(String[] args) {
        System.out.println(function(6));
    }
    
}
