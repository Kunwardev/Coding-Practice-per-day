/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreviousWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author DEV
 */

class comparing implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
    
}

public class SortingWithComparator{
    
    private static void function(List arr){
        comparing comp = new comparing();
        Collections.sort(arr, comp);
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
    
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("C");
        l.add("D");
        l.add("B");
        l.add("A");
        function(l);
    }

}
