package April;

import java.util.ArrayList;

public class PascalTriangle
{
    private ArrayList<Integer> function(int n){
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        if(n == 1)
            return result;
        int c = 1;
        for(int i=1;i<n;i++){
            c = (c * (n-i))/i;
            result.add(c);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();

        // Test case 1: n = 1
        ArrayList<Integer> result1 = pascalTriangle.function(1);
        ArrayList<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        System.out.println("Test case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        // Test case 2: n = 2
        ArrayList<Integer> result2 = pascalTriangle.function(2);
        ArrayList<Integer> expected2 = new ArrayList<>();
        expected2.add(1);
        expected2.add(1);
        System.out.println("Test case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        // Test case 3: n = 3
        ArrayList<Integer> result3 = pascalTriangle.function(3);
        ArrayList<Integer> expected3 = new ArrayList<>();
        expected3.add(1);
        expected3.add(2);
        expected3.add(1);
        System.out.println("Test case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));

        // Test case 4: n = 4
        ArrayList<Integer> result4 = pascalTriangle.function(4);
        ArrayList<Integer> expected4 = new ArrayList<>();
        expected4.add(1);
        expected4.add(3);
        expected4.add(3);
        expected4.add(1);
        System.out.println("Test case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));
    }


}