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
public class URLify {
    
    private static void function(char[] arr, int trueLength){
        int spaceCount = 0, index, i;
        for(i=0;i<trueLength;i++)
            if(arr[i] == ' ')
                spaceCount++;
        index = trueLength + spaceCount * 2;
        System.out.println(index);
        if(trueLength < arr.length)
            arr[index] = '\0';
        for(i=trueLength-1; i>=0; i--){
            if(arr[i] == ' '){
                arr[index-1] = '0';
                arr[index-2] = '2';
                arr[index-3] = '%';
                index-=3;
            } else{
                arr[index-1] = arr[i];
                index--;
            }
        }
        
    }
    
    
    public static void main(String[] args) {
        char[] arr = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' ',' ',' ',' '};
        function(arr, 13);
        for(char c: arr){
            System.out.print(c);
        }
        
    }
    
}
