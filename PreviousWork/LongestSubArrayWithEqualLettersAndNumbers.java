/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrackingCodingInterview;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author kunwar
 */
public class LongestSubArrayWithEqualLettersAndNumbers {
    
    private static char[] function(char[] array){
        int[] differences = computeDiffArray(array);
        int[] match = findLonegestDifference(differences);
        return extract(array, match[0]+1, match[1]);
    }

    private static int[] computeDiffArray(char[] array) {
        int length = array.length;
        int[] differences = new int[length];
        int difference = 0;
        for(int i=0;i<length;i++){
            if(Character.isLetter(array[i])){
                difference++;
            }
            else if(Character.isDigit(array[i])){
                difference--;
            }
            differences[i] = difference;
        }
       
        System.out.println("");
        return differences;
    }

    private static int[] findLonegestDifference(int[] differences) {
        HashMap<Integer, Integer> Difference_Index = new HashMap<>();
        int length = differences.length;
        Difference_Index.put(0, -1);
        int[] max = new int[2];
        for(int i=0;i<length;i++){
            if(!Difference_Index.containsKey(differences[i])){
                Difference_Index.put(differences[i], i);
            } else{
                int match = Difference_Index.get(differences[i]);
                int distance = i - match;
                int longest = max[1] - max[0];
                if(distance > longest){
                    max[1] = i;
                    max[0] = match;
                }
            }
        }
        return max;
    }

    private static char[] extract(char[] array, int start, int end) {
        char[] extracted = new char[end - start + 1];
        for(int i=start; i <= end; i++){
            extracted[i-start] = array[i];
        }
        return extracted;
    }
    
    public static void main(String[] args) {
        char[] array = new char[]{'a','1','a','a','a','1','a','1','1','a','1','a'};
        char[] extract =function(array);
        for(char a : extract){
            System.out.print(a+" ");
        }
    }
    
}
